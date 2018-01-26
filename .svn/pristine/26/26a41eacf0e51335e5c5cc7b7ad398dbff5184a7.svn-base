package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.domain.user.CltProjectTeam;
import net.northking.cloudplatform.domain.user.CltProjectTeamExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CltProjectTeamMapper extends BaseDao<CltProjectTeam, CltProjectTeamExample, String> {

    int deleteByUserIds(@Param("proId") String proId, @Param("userId") String userId, @Param("roleId") String roleId);

    List<CltProject> selectProjectByUserId(String userId);

    CltProjectTeam selectByProId(String proId);

    CltProjectTeam selectByProIdAndUserIdAndRoleId(@Param("proId") String proId, @Param("roleId") String roleId, @Param("userId") String userId);

    int countByProIdAndUserIdAndRoleId(@Param("proId") String proId, @Param("roleId") String roleId, @Param("userId") String userId);

    Integer selectByProIdAndRoleId(@Param("proId") String proId, @Param("roleId") String roleId);

    int deleteByProId(String ProId);

    //根据用户ID和角色ID查询对应的团队的记录数
    Integer countByRoleIdAndUserId(@Param("roleId") String roleId, @Param("userId") String userId);




}