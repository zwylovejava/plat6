package net.northking.cloudplatform.utils;

import java.util.UUID;

/**
 * @Title: UUID工具类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/13
 * @UpdateUser:
 * @Version:0.1
 */
public class UUIDUtil {
    /**
     * 获取UUID字符串
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().trim().replace("-","");
    }
}
