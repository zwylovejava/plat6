package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.testexecute.CltCaseExecute;
import net.northking.cloudplatform.domain.testexecute.CltCaseExecuteExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
@Mapper
public interface CltCaseExecuteMapper  extends BaseDao<CltCaseExecute, CltCaseExecuteExample, String> {

    List<CltCaseExecute> queryCaseExecuteByCaseId(String caseId);

    Integer updatStatusByCaseId(@Param("caseId") String caseId, @Param("status") String status);

   List<CltCaseExecute> queryOverNumBybathId(@Param("map") Map<String, Object> map);

    List<CltCaseExecute> querySuccessNumBybathId(@Param("map") Map<String, Object> map);

    List<CltCaseExecute> queryFailNumBybathId(@Param("map")Map<String, Object> map);
}