package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltAppBizParam;
import net.northking.cloudplatform.domain.testexecute.CltAppBizParamExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CltAppBizParamMapper {
    int countByExample(CltAppBizParamExample example);

    int deleteByExample(CltAppBizParamExample example);

    int deleteByPrimaryKey(String id);

    int insert(CltAppBizParam record);

    int insertSelective(CltAppBizParam record);

    List<CltAppBizParam> selectByExample(CltAppBizParamExample example);

    CltAppBizParam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CltAppBizParam record, @Param("example") CltAppBizParamExample example);

    int updateByExample(@Param("record") CltAppBizParam record, @Param("example") CltAppBizParamExample example);

    int updateByPrimaryKeySelective(CltAppBizParam record);

    int updateByPrimaryKey(CltAppBizParam record);
}