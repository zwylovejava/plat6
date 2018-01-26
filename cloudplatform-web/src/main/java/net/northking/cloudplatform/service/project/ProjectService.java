package net.northking.cloudplatform.service.project;

import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.query.project.ProjectQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface ProjectService {

    //根据项目ID查询项目详情
    ResultInfo<CltProject>  queryProjectInfoByProId(ProjectQuery projectQuery)throws Exception;
    //根据客户号查询出项目列表
    ResultInfo<List<CltProject>> queryCltProjectByCustId(ProjectQuery projectQuery)throws  Exception;

}
