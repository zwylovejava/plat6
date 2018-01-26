package net.northking.cloudplatform.dao.base;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.common.PageQuery;
import net.northking.cloudplatform.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: 基础service实现体
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/5
 * @UpdateUser:
 * @Version:0.1
 */
public abstract class BaseServiceImpl<T, V, ID extends Serializable> implements BaseService<T, V, ID> {

    @Autowired
    private BaseDao<T, V, ID> baseDao;

    @Override
    public int delete(V example) {
        return baseDao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(ID id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(ID[] ids){
        int num = 0;
        for(ID id : ids){
            baseDao.deleteByPrimaryKey(id);
            num ++;
        }
        return num;
    }

    @Override
    public int insert(T record) {
        return baseDao.insert(record);
    }

    @Override
    public int update(T record, V example) {
        return baseDao.updateByExampleSelective(record, example);
    }

    @Override
    public int update(T record) {
        return baseDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public T findObject(ID id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public T findObject(V example) throws RuntimeException {
        List<T> list = baseDao.selectByExample(example);
        if(list == null || list.size() == 0)
            return null;
        else
            return list.get(0);
    }

    @Override
    public boolean isExist(ID id) {
        T t = baseDao.selectByPrimaryKey(id);
        if(t == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean isExist(V example) {
        int num = baseDao.countByExample(example);
        if(num>0)
            return true;
        else
            return false;
    }

    @Override
    public List<T> findAll() {
        return baseDao.selectByExample(null);
    }


    @Override
    public List<T> findList(V example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public Page<T> findPage(PageQuery query, V example) {
        query.validate();
        PageUtil.startPage(query);//获取分页信息
        List<T> data = baseDao.selectByExample(example);
        return new Page<>(data);
    }

    @Override
    public int countByExample(V example){
        return baseDao.countByExample(example);
    }
}
