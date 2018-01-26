package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.dao.base.BaseDao;

import net.northking.cloudplatform.domain.testexecute.CltJob;
import net.northking.cloudplatform.domain.testexecute.CltJobExample;
import net.northking.cloudplatform.dto.testexecute.JobPlan;
import net.northking.cloudplatform.dto.testexecute.JobPlanQuery;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CltJobMapper extends BaseDao<CltJob,CltJobExample,String> {
    //根据manageId查询计划
    List<JobPlan> quertJobListById(JobPlanQuery jobPlanQuery);

    Integer countByManagerId(String manager);


}