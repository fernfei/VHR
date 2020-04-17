/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SecurityConfig
 * Author:   Administrator
 * Date:     2020/3/6 5:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fern.vhr.model.Hr;
import com.fern.vhr.model.RespBean;
import com.fern.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/6
 * @since 1.0.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private HrService hrService;
    @Autowired
    private CustomAccessDecisionManager customAccessDecisionManager;
    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    /*从 Spring5 开始，强制要求密码要加密*/
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /***
         * .loginPage("/login")
         * 由于所有url都需要登陆后访问，导致我们自定义的login url也被拦截了
         * 因此需要忽略掉login
         */
        web.ignoring().antMatchers("/login","/getIP","/session/invalid","/css/**","/js/**","/index.html","/img/**","/fonts/**","/favicon.ico/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customAccessDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                //剩下的其他路径请求验证之后就可以访问
                .anyRequest().authenticated()
                .and()
                //表单登陆
                .formLogin()
                //定义登陆时的key,默认username
                .usernameParameter("username")
                //定义登陆时的key,默认username
                .passwordParameter("password")
                //处理登陆请求的url
                .loginProcessingUrl("/doLogin")
                //登陆页面，不写使用SpringSecurity默认的登陆页面
                .loginPage("/login")
                //登陆成功后的处理
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Hr hr = ((Hr) authentication.getPrincipal());
                        hr.setPassword(null);
                        RespBean respBean = RespBean.getSuccess("登陆成功!", hr);
                        //使用Jackson将hr对象写成json字符串
                        String json = new ObjectMapper().writeValueAsString(respBean);
                        out.write(json);
                        out.flush();
                        out.close();
                    }
                })
                //登陆失败后的处理
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        RespBean respBean = null;
                        if (exception instanceof LockedException) {
                            respBean=respBean.getError("账户被锁定，登陆失败！");
                        } else if (exception instanceof BadCredentialsException ||
                                   exception instanceof UsernameNotFoundException) {
                            respBean=respBean.getError("账户或者密码错误，登陆失败！");
                        } else if (exception instanceof DisabledException) {
                            respBean=respBean.getError("账户被禁用，登陆失败！");
                        } else if (exception instanceof AccountExpiredException) {
                            respBean=respBean.getError("账户已过期，登陆失败！");
                        } else if (exception instanceof CredentialsExpiredException) {
                            respBean=respBean.getError("密码已过期，登陆失败！");
                        } else {
                            respBean=respBean.getError("登陆失败！");
                        }
                        //使用Jackson将hr对象写成json字符串
                        String json = new ObjectMapper().writeValueAsString(respBean);
                        out.write(json);
                        out.flush();
                        out.close();
                    }
                })
                //放行上面登陆接口url
                .permitAll()
                .and()
                //登出
                .logout()
                //登出成功处理
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.getSuccess("注销成功！")));
                        out.flush();
                        out.close();
                    }
                })
                //放开登出url
                .permitAll()
                .and()
                //设置session超时的管理
                .sessionManagement()
                //session超时时跳往的路径
                .invalidSessionUrl("/session/invalid")
                .and()
                //关闭csrf攻击，因为需要postman测试
                .csrf().disable()
                //未登录时访问受保护页面，不去重定向到登陆页面，而是给出错误信息
                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                if (authException instanceof InsufficientAuthenticationException) {
                    response.setStatus(401);
                    RespBean.getError("身份验证异常,请联系管理QQ1639670695");
                }
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(new ObjectMapper().writeValueAsString(RespBean.getError("非法请求!")));
                out.flush();
                out.close();

            }
        });

    }
}