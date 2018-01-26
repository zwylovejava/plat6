package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.domain.testexecute.CltTestTeamExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper

public interface CltTestTeamMapper {
    int countByExample(CltTestTeamExample example);

    int deleteByExample(CltTestTeamExample example);

    int deleteByPrimaryKey(String teamId);

    int insert(CltTestTeam record);

    int insertSelective(CltTestTeam record);

    List<CltTestTeam> selectByExample(CltTestTeamExample example);

    CltTestTeam selectByPrimaryKey(String teamId);

    int updateByExampleSelective(@Param("record") CltTestTeam record, @Param("example") CltTestTeamExample example);

    int updateByExample(@Param("record") CltTestTeam record, @Param("example") CltTestTeamExample example);

    int updateByPrimaryKeySelective(CltTestTeam record);

    int updateByPrimaryKey(CltTestTeam record);

    Integer countByJobIdAndUserId(@Param("jobId") String jobId,@Param("userId") String userId);

    Integer countByJobId(@Param("jobId") String jobId);

    Integer deleteTestTeamByJobIdAndUserId(@Param("jobId") String jobId,@Param("userId") String userId);

    CltTestTeam queryByJobIdAndUserId(@Param("jobId") String jobId,@Param("userId") String userId);

    List<CltTestTeam> querUserIdByJobId(String jobId);

    int deleteUsersByJobId(String jobId);


}