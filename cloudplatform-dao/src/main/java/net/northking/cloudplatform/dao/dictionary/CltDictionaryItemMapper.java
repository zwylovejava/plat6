package net.northking.cloudplatform.dao.dictionary;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.dictionary.CltDictionaryItem;
import net.northking.cloudplatform.domain.dictionary.CltDictionaryItemExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface CltDictionaryItemMapper extends BaseDao<CltDictionaryItem,CltDictionaryItemExample,String> {



    //根据字典类型查询字典明细记录数
    List<CltDictionaryItem> queryDictionaryItemByTypeId(String typeId);


}