package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltPlan;
import net.northking.cloudplatform.domain.testexecute.CltPlanExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CltPlanMapper {
    int countByExample(CltPlanExample example);

    int deleteByExample(CltPlanExample example);

    int deleteByPrimaryKey(String planId);

    int insert(CltPlan record);

    int insertSelective(CltPlan record);

    List<CltPlan> selectByExample(CltPlanExample example);

    CltPlan selectByPrimaryKey(String planId);

    int updateByExampleSelective(@Param("record") CltPlan record, @Param("example") CltPlanExample example);

    int updateByExample(@Param("record") CltPlan record, @Param("example") CltPlanExample example);

    int updateByPrimaryKeySelective(CltPlan record);

    int updateByPrimaryKey(CltPlan record);
}