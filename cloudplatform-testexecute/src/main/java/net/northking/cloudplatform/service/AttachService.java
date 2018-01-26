package net.northking.cloudplatform.service;

import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.testexecute.CltAttach;
import net.northking.cloudplatform.domain.testexecute.CltAttachExample;
import net.northking.cloudplatform.query.testexecute.CltAttachQuery;

import java.util.List;

public interface AttachService extends BaseService<CltAttach,CltAttachExample,String> {
    /**
     * 查询操作步骤id下的附件
     * @param query
     * @return
     */
    List<CltAttach> findAttachByFuncId(CltAttachQuery query)throws Exception;

    /**
     * 添加附件
     * @param query
     * @return
     */
    int insertAttach(CltAttachQuery query) throws Exception;

    /**
     * 删除附件
     * @param query
     * @return
     * @throws Exception
     */
    int deleteAttach(CltAttachQuery query) throws Exception;
}
