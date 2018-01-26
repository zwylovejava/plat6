package net.northking.cloudplatform.service;



import net.northking.cloudplatform.domain.user.CltProjectTeam;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;


import java.util.List;


public interface ProjecTeamtService {

    Integer createTeam(List<CltProjectTeamQuery> listCltProjectTeamQuery);

    Integer removeUserByIds(List<CltProjectTeamQuery> cltProjectTeamQuery);

    //根据用户ID角色ID项目ID查询团队表
    CltProjectTeam selectByProIdAndUserIdAndRoleId(CltProjectTeamQuery cltProjectTeamQuery);

    //根据角色ID和用户ID查询团队表的记录数
    Integer countByRoleIdAndUserId(CltProjectTeamQuery cltProjectTeamQuery);








}
