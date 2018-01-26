package net.northking.cloudplatform.dao.testexecute;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.testexecute.CltCaseItemSetup;
import net.northking.cloudplatform.domain.testexecute.CltCaseItemSetupExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by ZW on 2017/12/18.
 */
@Component
@Mapper
public interface CltCaseItemSetupMapper extends BaseDao<CltCaseItemSetup,CltCaseItemSetupExample,String> {
    /**
     * 查询自定义索引
     * @param proId
     * @return
     */
    List<CltCaseItemSetup> selectUserDefinedInx(String proId);

    /**
     * 查询启用的自定义索引
     * @param proId
     * @return
     */
    List<CltCaseItemSetup> selectIndexInUse(String proId);

    /**
     * 根据字段名查询
     * @param columnName
     * @return
     */
    CltCaseItemSetup selectByColumnNameAndProId(@Param("columnName") String columnName, @Param("proId") String proId);
}