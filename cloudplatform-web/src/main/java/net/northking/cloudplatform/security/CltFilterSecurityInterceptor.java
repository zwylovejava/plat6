package net.northking.cloudplatform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

/**
 * @Title:
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/28
 * @UpdateUser:
 * @Version:0.1
 */
@Component
public class CltFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
    @Autowired
    private CltFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    private CltAccessDecisionManager myAccessDecisionManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init(){
        super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(myAccessDecisionManager);
    }

    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{
        FilterInvocation fi = new FilterInvocation( request, response, chain );
        invoke(fi);

    }


    public Class<? extends Object> getSecureObjectClass(){
        return FilterInvocation.class;
    }


    public void invoke( FilterInvocation fi ) throws IOException, ServletException{
        InterceptorStatusToken  token = super.beforeInvocation(fi);
        try{
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally{
            super.afterInvocation(token, null);
        }

    }


    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource(){
        return this.securityMetadataSource;
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }
    public void init(FilterConfig filterconfig) throws ServletException {

    }
}
