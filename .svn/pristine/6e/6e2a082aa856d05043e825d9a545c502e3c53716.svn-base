package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltTestStepData;
import net.northking.cloudplatform.domain.testexecute.CltTestStepDataExample;
import net.northking.cloudplatform.dto.testexecute.StepDataInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Component
@Mapper
public interface CltTestStepDataMapper {
    int countByExample(CltTestStepDataExample example);

    int deleteByExample(CltTestStepDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(CltTestStepData record);

    int insertSelective(CltTestStepData record);

    List<CltTestStepData> selectByExample(CltTestStepDataExample example);

    CltTestStepData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CltTestStepData record, @Param("example") CltTestStepDataExample example);

    int updateByExample(@Param("record") CltTestStepData record, @Param("example") CltTestStepDataExample example);

    int updateByPrimaryKeySelective(CltTestStepData record);

    int updateByPrimaryKey(CltTestStepData record);


    List<StepDataInfo> queryTestStepDataById(@Param("stepId") String stepId, @Param("caseId") String caseId);


    List<CltTestStepData> queryTestStepDataBytsId(@Param("transId") String transId, @Param("caseId") String caseId);

}