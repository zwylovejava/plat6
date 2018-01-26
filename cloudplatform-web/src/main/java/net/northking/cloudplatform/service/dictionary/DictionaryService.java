package net.northking.cloudplatform.service.dictionary;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.dictionary.CltDictionaryItem;
import net.northking.cloudplatform.domain.dictionary.CltDictionaryType;
import net.northking.cloudplatform.query.dictionary.DictionaryItemQuery;
import net.northking.cloudplatform.query.dictionary.DictionaryTypeQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Title:
 * @Description: 数据字典web层实现层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-28 10:40
 * @UpdateUser:
 * @Version:0.1
 */
public interface DictionaryService {
    //添加数据字典类型
    ResultInfo<Integer> addDictionaryType(DictionaryTypeQuery dictionaryTypeQuery)throws Exception;

    //添加数据字典明细
    ResultInfo<Integer> addDictionaryItem(DictionaryItemQuery dictionaryItemQuery)throws Exception;

    //删除数据字典类型
    ResultInfo<Integer>  deleteDictionaryType(DictionaryTypeQuery dictionaryTypeQuery)throws Exception;

    //删除数据字典明细
    ResultInfo<Integer> deleteDictionaryItem(DictionaryItemQuery dictionaryItemQuery)throws Exception;

    //更新数据字典类型
    ResultInfo<Integer> updateDictionaryType(DictionaryTypeQuery dictionaryTypeQuery)throws Exception;


    //更新数据字典明细
    ResultInfo<Integer> updateDictionaryItem(DictionaryItemQuery dictionaryItemQuery)throws Exception;

    //查询所有字典类型列表
    ResultInfo<Page<CltDictionaryType>> queryDictionaryTypeList(DictionaryTypeQuery dictionaryTypeQuery)throws Exception;

    //根据typeId查询字典明细列表
    ResultInfo<List<CltDictionaryItem>> queryCltDictionaryItemsByTypeId(DictionaryItemQuery dictionaryItemQuery)throws Exception;

    //批量删除字典类型表
    ResultInfo<Integer> deleteCltDictionaryTypeBatch(DictionaryTypeQuery dictionaryTypeQuery)throws Exception;

    //批量删除字典明细表
    ResultInfo<Integer> deleteDictionaryItemBatch(DictionaryItemQuery dictionaryItemQuery)throws Exception;

    //启用/禁用
    ResultInfo<Integer> disEnableDictionary(DictionaryTypeQuery dictionaryTypeQuery)throws Exception ;

    //批量修改数据字典排序
    ResultInfo<Integer> updateDictionarysByOrderSeq(List<DictionaryItemQuery> dictionaryItemQueries)throws Exception ;

    //根据typeId查询字典明细列表
    ResultInfo<List<CltDictionaryItem>> queryCltDictionaryItemByTypeCode(DictionaryItemQuery dictionaryItemQuery)throws Exception;


}
