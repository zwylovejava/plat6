package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltAppFunc;
import net.northking.cloudplatform.domain.testexecute.CltAppFuncExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CltAppFuncMapper {
    int countByExample(CltAppFuncExample example);

    int deleteByExample(CltAppFuncExample example);

    int deleteByPrimaryKey(String id);

    int insert(CltAppFunc record);

    int insertSelective(CltAppFunc record);

    List<CltAppFunc> selectByExample(CltAppFuncExample example);

    CltAppFunc selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CltAppFunc record, @Param("example") CltAppFuncExample example);

    int updateByExample(@Param("record") CltAppFunc record, @Param("example") CltAppFuncExample example);

    int updateByPrimaryKeySelective(CltAppFunc record);

    int updateByPrimaryKey(CltAppFunc record);
}