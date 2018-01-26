package net.northking.cloudplatform.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.northking.cloudplatform.common.PageQuery;


/**
 * <p/>
 * PageUtil 分页工具类
 * <p/>
 *
 * @author chuangsheng.huang
 */
public class PageUtil {
    /**
     * 开始分页
     * @param query 分页查询对象
     * @return
     */
    public static Page startPage(PageQuery query) {
        Page page = PageHelper.startPage(query.getPageNum(), query.getPageSize());
        //page.setRequestUrl(query.getRequestUrl());
        return page;
    }


}