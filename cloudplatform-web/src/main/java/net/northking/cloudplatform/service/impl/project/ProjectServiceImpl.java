package net.northking.cloudplatform.service.impl.project;

import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.project.ProjectFeignClient;
import net.northking.cloudplatform.query.project.ProjectQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.project.ProjectService;
import net.northking.cloudplatform.utils.CltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectFeignClient projectFeignClient ;
    @Override
    public ResultInfo<CltProject> queryProjectInfoByProId(@RequestBody ProjectQuery projectQuery) throws Exception {
        CltUtils.printStartInfo(projectQuery, "queryProjectInfoByProId");

        ResultInfo<CltProject> result = null;

        long startTime = System.currentTimeMillis();

        try {
            //调用微服务接口
            result = projectFeignClient.queryProjectInfoByProId(projectQuery);

        } catch (Exception e) {

            e.printStackTrace();

            throw new GlobalException(ErrorConstants.CLT_WEB_PROJECT_ERROR_CODE, ErrorConstants.CLT_WEB_PROJECT_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryProjectInfoByProId", startTime);

        return result;
    }

    @Override
    public ResultInfo<List<CltProject>> queryCltProjectByCustId(ProjectQuery projectQuery) throws Exception {

        CltUtils.printStartInfo(projectQuery, "queryProjectInfoByProId");

        long startTime = System.currentTimeMillis();

        ResultInfo<List<CltProject>> result = null;

        try {
            //调用微服务接口
            result = projectFeignClient.queryCltProjectByCustId(projectQuery);

        } catch (Exception e) {

            e.printStackTrace();

            throw new GlobalException(ErrorConstants.CLT_WEB_PROJECT_ERROR_CODE, ErrorConstants.CLT_WEB_PROJECT_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryProjectInfoByProId", startTime);

        return result;
    }
}
