/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Custom
 * Author:   Administrator
 * Date:     2020/3/11 6:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/11
 * @since 1.0.0
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//        configAttributes里存放着CustomFilterInvocationSecurityMetadataSource返回的URL所需要的角色
        for (ConfigAttribute configAttribute : configAttributes) {
            if ("ROLE_LOGIN".equals(configAttribute.getAttribute())) {
                //匿名用户，也就是未登录的用户
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登陆,请先登陆!");
                }else {
                    //已经登陆直接访问
                    return;
                }
            }

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //用户具有的角色与URL需要的角色比较
                //这里的判断比较简单，只需要满足URL所需要的角色的其中一个角色就放行
                //如果想写必须满足URL需要的所有角色才放行，请查看本包下的Test类里面有具体逻辑
                if (authority.getAuthority().equals(configAttribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足,请登录！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}