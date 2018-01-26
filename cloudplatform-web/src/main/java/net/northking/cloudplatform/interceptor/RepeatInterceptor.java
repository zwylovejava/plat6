package net.northking.cloudplatform.interceptor;

import com.alibaba.fastjson.JSONObject;
import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.result.ResultCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @Title:
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2018/1/4
 * @UpdateUser:
 * @Version:0.1
 */
@Component
public class RepeatInterceptor implements HandlerInterceptor{



    @Autowired
    private RedisUtil redisUtil;

    private Logger logger = LoggerFactory.getLogger(RepeatInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
        String timestamp = request.getParameter("timestamp");
        if(StringUtils.isNotEmpty(timestamp)){
            Object timestampValue = redisUtil.get(timestamp.toString());
            if(timestampValue == null) { //第一次进入为空,即插入
                redisUtil.set(timestamp.toString(), true, 60l);
            }else{
                if((Boolean)timestampValue){ //第一次提交
                    redisUtil.set(timestamp.toString(), false, 60l);
                }else{ //重复提交
                    throw new GlobalException(ResultCode.REPEATCOMMIT);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView var4) throws Exception{


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception{

    }


}
