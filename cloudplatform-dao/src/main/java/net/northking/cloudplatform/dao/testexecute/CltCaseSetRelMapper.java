package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltCaseSetRel;
import net.northking.cloudplatform.domain.testexecute.CltCaseSetRelExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CltCaseSetRelMapper {
    int countByExample(CltCaseSetRelExample example);

    int deleteByExample(CltCaseSetRelExample example);

    int deleteByPrimaryKey(String caseSetRelId);

    int insert(CltCaseSetRel record);

    int insertSelective(CltCaseSetRel record);

    List<CltCaseSetRel> selectByExample(CltCaseSetRelExample example);

    CltCaseSetRel selectByPrimaryKey(String caseSetRelId);

    int updateByExampleSelective(@Param("record") CltCaseSetRel record, @Param("example") CltCaseSetRelExample example);

    int updateByExample(@Param("record") CltCaseSetRel record, @Param("example") CltCaseSetRelExample example);

    int updateByPrimaryKeySelective(CltCaseSetRel record);

    int updateByPrimaryKey(CltCaseSetRel record);
}