package net.northking.cloudplatform.controller.project;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.query.project.ProjectQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.project.ProjectService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @Title:
 * @Description:项目控制层
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017-12-07 17:04
 * @UpdateUser:
 * @Version:0.1
 */

@RestController
public class ProjectController {
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);


    @Autowired
    ProjectService projectService;

    //查询项目详情
    @PostMapping("/queryProjectById")
    public ResultInfo<CltProject> queryProjectById(@RequestBody ProjectQuery projectQuery) throws Exception {

        CltUtils.printStartInfo(projectQuery, "queryProjectById");

        long startTime = System.currentTimeMillis();

        //参数校验
        init(projectQuery, "Q_ID");

        ResultInfo<CltProject> result = projectService.queryProjectInfoByProId(projectQuery);

        CltUtils.printEndInfo(result, "queryProjectById", startTime);

        return result;
    }

    public static void init(ProjectQuery projectQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String, Object> dataMap = CltUtils.beanToMap(projectQuery);
        if ("Q_ID".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "proId");
        }


    }
}