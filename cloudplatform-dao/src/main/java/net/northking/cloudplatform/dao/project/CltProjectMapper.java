package net.northking.cloudplatform.dao.project;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.domain.project.CltProjectExample;
import net.northking.cloudplatform.domain.project.CltProjectUserInfo;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CltProjectMapper extends BaseDao<CltProject, CltProjectExample, String> {


    //通过用户id查询项目信息
    List<CltProject> selectProjectByUserId(String userId);

    //查询所有的项目信息
    List<CltProject> queryAllProject(String cusId);

    CltProject queryCltProject(String proId);

    //根据项目ID查询所有用户信息
    List<CltProjectUserInfo> queryProjectUserInfoListByProId(CltProjectTeamQuery cltProjectTeamQuery);

    //查询客户下的所有项目
    List<CltProject> queryCltProjectByCustId(String custId);
}