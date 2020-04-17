/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: CustomFilter
 * Author:   Administrator
 * Date:     2020/3/11 5:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.config;

import com.fern.vhr.model.Menu;
import com.fern.vhr.model.Role;
import com.fern.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.net.URI;
import java.util.Collection;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/11
 * @since 1.0.0
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的URL
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //获取所有路径需要的角色
        List<Menu> menuList= menuService.getMenuAll();

        for (Menu menu : menuList) {
            //判断请求的URL与数据库中的URL是否能匹配上
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] needRoles=new String[roles.size()];
                for (int i = 0; i < needRoles.length; i++) {
                    needRoles[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(needRoles);
            }
        }
        //如果请求的URL与数据库中的URL没匹配上返回一个默认的角色（用于标记这些没匹配上的URL）
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}