package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.domain.testexecute.CltAttach;
import net.northking.cloudplatform.query.testexecute.CltAttachQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.AttachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * create by ZW CltAttach 控制层
 */
@RestController
public class AttachController {

    @Autowired
    private AttachService attachService;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(AttachController.class);

    /**
     * 根据步骤id查询附件
     * @param query
     * @return
     * @throws Exception
     */
    @PostMapping("/pageAttachs")
    public ResultInfo<List<CltAttach>> findAttachs(@RequestBody CltAttachQuery query) throws Exception{
        logger.info("pageAttachs start paramData:"+query.toString());

        List<CltAttach> list = attachService.findAttachByFuncId(query);

        logger.info("pageAttachs end !!!");
        return new ResultInfo<>(ResultCode.SUCCESS,list);
    }

    /**
     * 添加附件
     * @param query
     * @return
     * @throws Exception
     */
    @PostMapping("/addAttach")
    public ResultInfo<Integer> saveAttach(@RequestBody CltAttachQuery query) throws Exception{
        logger.info("addAttach start paramData:"+query.toString());

        int index = attachService.insertAttach(query);

        logger.info("addAttach end !!!");
        return new ResultInfo<>(ResultCode.SUCCESS,index);
    }

    /**
     * 删除附件图片
     * @param query
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteAttach")
    public ResultInfo<Integer> deleteImage(@RequestBody CltAttachQuery query)throws Exception{
        logger.info("deleteAttach start paramData:"+query.toString());

        int index = attachService.deleteAttach(query);

        logger.info("deleteAttach end !!!");
        return new ResultInfo<>(ResultCode.SUCCESS,index);
    }
}
