package net.northking.cloudplatform.dao.base;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: DAO基类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/5
 * @UpdateUser:
 * @Version:0.1
 */
public interface BaseDao<T, V, ID extends Serializable> {
    int countByExample(V example);

    int deleteByExample(V example);

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(V example);

    T selectByPrimaryKey(ID id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") V example);

    int updateByExample(@Param("record") T record, @Param("example") V example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
