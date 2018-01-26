package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltTestStepExecute;
import net.northking.cloudplatform.domain.testexecute.CltTestStepExecuteExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CltTestStepExecuteMapper {
    int countByExample(CltTestStepExecuteExample example);

    int deleteByExample(CltTestStepExecuteExample example);

    int deleteByPrimaryKey(String stepExecuteId);

    int insert(CltTestStepExecute record);

    int insertSelective(CltTestStepExecute record);

    List<CltTestStepExecute> selectByExample(CltTestStepExecuteExample example);

    CltTestStepExecute selectByPrimaryKey(String stepExecuteId);

    int updateByExampleSelective(@Param("record") CltTestStepExecute record, @Param("example") CltTestStepExecuteExample example);

    int updateByExample(@Param("record") CltTestStepExecute record, @Param("example") CltTestStepExecuteExample example);

    int updateByPrimaryKeySelective(CltTestStepExecute record);

    int updateByPrimaryKey(CltTestStepExecute record);

    void updateByAndCaseID(CltTestStepExecute cltTestStepExecute);

    CltTestStepExecute queryTestStepExecuteById(@Param("stepId") String stepId, @Param("caseId") String caseId);
}