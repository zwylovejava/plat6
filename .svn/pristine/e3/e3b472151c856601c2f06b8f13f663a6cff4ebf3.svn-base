package net.northking.cloudplatform.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Title:
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/28
 * @UpdateUser:
 * @Version:0.1
 */
@Service
public class CltAccessDecisionManager implements AccessDecisionManager {
    private static Logger log = LoggerFactory.getLogger(CltAccessDecisionManager.class);
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if( configAttributes == null ) {
            return ;
        }
        /*if(object != null) {
            FilterInvocation filterInvocation = (FilterInvocation) object;
            if("/getVerificationCode".equals(filterInvocation.getRequestUrl()) || "/authToken".equals(filterInvocation.getRequestUrl()) || "/checkVerificationCode".equals(filterInvocation.getRequestUrl())){
                return;
            }

        }*/

        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while( ite.hasNext()){
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig)ca).getAttribute();

            //ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
            for( GrantedAuthority ga: authentication.getAuthorities()){

                if(needRole.trim().equals(ga.getAuthority().trim())){

                    return;
                }

            }

        }

        throw new AccessDeniedException("权限不足");
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
