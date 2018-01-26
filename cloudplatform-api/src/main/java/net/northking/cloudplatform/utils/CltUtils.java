package net.northking.cloudplatform.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
public class CltUtils {

    private final static Logger logger = LoggerFactory.getLogger(ParamVerifyUtil.class);

    public static final void processErrorInfo(String className,Object object, String errorCode, String errorMessage, Throwable t){


        logger.error(className+" invoke error. dataMap is: " + object);

        logger.error(className+" invoke error. error code is: " + errorCode);

        logger.error(className+" invoke error. error info is: " + errorMessage);

        logger.error(className+" invoke error. action name is: " + className);

        t.printStackTrace();

    }

    public static final void printStartInfo(Object object,String className) {

        StringBuffer printInfo = new StringBuffer("\n");

        printInfo.append("\n***********************************" + className+
                " invoke  start******************************\n");

        printInfo.append("Input paramData: " + object.toString());

        logger.info(printInfo.toString());


        //COSCLogger.infoBegin(logger, "1111111111111","0501" ,printInfo.toString());

    }

    public static  final void printEndInfo(Object object,String className, long startTime) {

        if(object == null) return;

        StringBuffer printInfo = new StringBuffer("");

        printInfo.append("\nOutput object: " + object.toString());

        printInfo.append("\nSpent time: " + (System.currentTimeMillis() - startTime) + "ms");

        printInfo.append("\n***********************************" + className +
                " invoke  finished******************************\n");

        logger.info(printInfo.toString());

    }

    public static Map<String, Object> beanToMap(Object obj) {

        Map<String, Object> map = new HashMap();

        if (obj != null) {

            BeanMap beanMap = BeanMap.create(obj);

            for (Object key : beanMap.keySet()) {

                map.put(key+"", beanMap.get(key));
            }
        }

        return map;
    }

    /**
     * 将map装换为javabean对象
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }


    //获取token值
    public static String getAccessToken(HttpServletRequest request){

        return  "access:"+ StringUtils.substringAfter(request.getHeader("Authorization").trim(),"bearer").trim();
    }

}
