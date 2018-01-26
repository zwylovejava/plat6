package net.northking.cloudplatform.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.portable.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;


/**
 * @Title: Zuul过滤器
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/25
 * @UpdateUser:
 * @Version:0.1
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    private static final String HEAD_TOKEN = "Authorization";

    private ResponseHandler responseHandler;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    public ResponseHandler getResponseHandler() {
        return responseHandler;
    }

    public void setResponseHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public Object run() {
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();


        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        InputStream in = (InputStream) ctx.get("requestEntity");
        String body = "";
        if (in == null) {
            try {
                in = ctx.getRequest().getInputStream();
                 body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
                 if(request.getHeader(HEAD_TOKEN) != null && request.getHeader(HEAD_TOKEN).indexOf("bearer")>=0) {
                     String accessToken = StringUtils.substringAfter(request.getHeader(HEAD_TOKEN).trim(), "bearer").trim();
                     log.info("accessToken:" + accessToken);
                     if (StringUtils.isNotBlank(accessToken)) {
                         if(StringUtils.isNotEmpty(body) && body.indexOf("\"")>=0) {
                             body = StringUtils.replace(body, "}", ",\"access_token\":\"" + accessToken + "\"}");
                         }else{
                             body = StringUtils.replace(body, "}", "\"access_token\":\"" + accessToken + "\"}");
                         }
                         log.info("请求body:" + body);

                         final byte[] reqBodyBytes = body.getBytes();
                         ctx.setRequest(new HttpServletRequestWrapper(getCurrentContext().getRequest()) {
                             @Override
                             public ServletInputStream getInputStream() throws IOException {
                                 return new ServletInputStreamWrapper(reqBodyBytes);
                             }

                             @Override
                             public int getContentLength() {
                                 return reqBodyBytes.length;
                             }

                             @Override
                             public long getContentLengthLong() {
                                 return reqBodyBytes.length;
                             }
                         });
                         return null;
                     }
                 }


            }catch (IOException e){
                log.error("error:", e);
            }
        }
        return null;
    }

}
