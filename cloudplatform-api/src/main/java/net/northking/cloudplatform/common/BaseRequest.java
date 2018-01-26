package net.northking.cloudplatform.common;

/**
 * Created by hcs on 2017/5/9.
 */



import net.northking.cloudplatform.utils.ParamCheckUtil;

import java.io.Serializable;

/**
 * <p/>
 * BaseRequest 请求参数基类
 * <p/>
 *
 * @author chuangsheng.huang
 */
public class BaseRequest implements Serializable {
    public String checkParam() {
        return ParamCheckUtil.checkParam(this);
    }

    public void validate() {
        ParamCheckUtil.validate(this);
    }
}
