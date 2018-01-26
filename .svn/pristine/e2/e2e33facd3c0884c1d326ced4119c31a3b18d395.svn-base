package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.domain.testexecute.CltTestCaseExample;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CltTestCaseMapper {
    int countByExample(CltTestCaseExample example);

    int deleteByExample(CltTestCaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CltTestCase record);

    int insertSelective(CltTestCase record);

    List<CltTestCase> selectByExample(CltTestCaseExample example);

    CltTestCase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CltTestCase record, @Param("example") CltTestCaseExample example);

    int updateByExample(@Param("record") CltTestCase record, @Param("example") CltTestCaseExample example);

    int updateByPrimaryKeySelective(CltTestCase record);

    int updateByPrimaryKey(CltTestCase record);

    List<CltTestCase> queryTestCaseById(TestCaseSetQuery testCaseSetQuery);
}