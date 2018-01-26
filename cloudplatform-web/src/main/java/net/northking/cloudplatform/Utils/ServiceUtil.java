package net.northking.cloudplatform.Utils;

import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.result.ResultInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class ServiceUtil {

    //微服务接口如果返回为异常则抛出异常信息
    public static  void  throwServiceException(ResultInfo resultInfo)throws Exception{

        if(resultInfo!=null&&!"CLT000000000".equals(resultInfo.getResultCode())){

            throw new GlobalException(resultInfo.getResultCode(),resultInfo.getResultMsg());

        }
    }
}
