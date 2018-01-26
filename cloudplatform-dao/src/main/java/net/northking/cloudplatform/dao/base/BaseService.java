package net.northking.cloudplatform.dao.base;





import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.common.PageQuery;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: service基础接口
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/5
 * @UpdateUser:
 * @Version:0.1
 */
public interface BaseService<T, V, ID extends Serializable> {
    /**
     * 按条件删除数据
     * @param example
     * @return
     */
    int delete(V example);

    /**
     * 删除某个主键的数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 根据IDS删除批量数据
     * @param ids
     * @return
     */
    int deleteByIds(ID[] ids);

    /**
     * 保存单个实体
     * @param record
     * @return
     */
    int insert(T record);


    /**
     * 更新单个对象
     * @param record
     * @return
     */
    int update(T record);

    /**
     * 按条件更新单个对象
     * @param record
     * @return
     */
    int update(T record, V example);


    /**
     * 查询单个对象
     * @param id
     * @return
     */
    T findObject(ID id);

    /**
     * 按条件查询对象
     * @param example
     * @return
     * @throws RuntimeException
     */
    T findObject(V example) throws RuntimeException;

    /**
     * 实体是否存在
     * @param id 主键
     * @return 存在 返回true，否则false
     */
    boolean isExist(ID id);

    /**
     * 判断是否存在
     * @return 存在 true 不存在 false
     */
    boolean isExist(V example);

    /**
     * 查询出所有的记录
     * @return
     */
    List<T> findAll();


    /**
     * @param example 排序及按条件
     * @return
     */
    List<T> findList(V example);

    /**
     * 分页、排序及按条件查询实体
     * @param
     * @return
     */
    Page<T> findPage(PageQuery query, V example);

    /**
     * 根据条件查询条数
     * @param example
     * @return
     */
    int countByExample(V example);

}
