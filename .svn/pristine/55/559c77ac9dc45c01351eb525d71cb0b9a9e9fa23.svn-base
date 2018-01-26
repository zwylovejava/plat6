package net.northking.cloudplatform.service.impl;

import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.testexecute.CltAttachMapper;
import net.northking.cloudplatform.domain.testexecute.CltAttach;
import net.northking.cloudplatform.domain.testexecute.CltAttachExample;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.testexecute.CltAttachQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.service.AttachService;
import net.northking.cloudplatform.utils.BeanUtil;
import net.northking.cloudplatform.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class AttachServiceImpl extends BaseServiceImpl<CltAttach,CltAttachExample,String> implements AttachService{

    @Autowired
    private CltAttachMapper attachMapper;

    @Autowired
    private RedisUtil redisUtil;

    private Logger logger = LoggerFactory.getLogger(AttachServiceImpl.class);

    /**
     * 根据操作步骤id查询附件
     * @param query
     * @return
     */
    @Override
    public List<CltAttach> findAttachByFuncId(CltAttachQuery query)throws Exception {
        if (StringUtils.isEmpty(query.getFuncId())) {
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"操作步骤id不能为空");
        }
        CltAttachExample example = new CltAttachExample();
        query.addSortOrderAsc("createDate");
        example.setOrderByClause(query.getOrderByClause());
        CltAttachExample.Criteria criteria = example.createCriteria();
        criteria.andFuncIdEqualTo(query.getFuncId());
        List<CltAttach> list = null;
        try {
            list = attachMapper.selectByExample(example);
        }catch (Exception e){
            throw new GlobalException(ResultCode.EXCEPTION.code(),"查询附件失败");
        }
        return list;
    }

    /**
     * 添加附件
     * @param query
     * @return
     * @throws Exception
     */
    @Override
    public int insertAttach(CltAttachQuery query) throws Exception{
        if (StringUtils.isEmpty(query.getFuncId())) {
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"操作步骤id不能为空");
        }
        int index = 0;
        try {
            CltAttach attach = new CltAttach();
            BeanUtil.copyProperties(query,attach);
            String id = UUIDUtil.getUUID();
            attach.setAttachId(id);
            if(StringUtils.hasText(query.getAccess_token())){
                CltUserLogin token = (CltUserLogin)redisUtil.get(query.getAccess_token());
                attach.setCreateUser(token.getUserId());
            }else{
                attach.setCreateUser("U001");
            }
            attach.setCreateDate(new Date());
            index = attachMapper.insertSelective(attach);
        }catch (Exception e){
            logger.error("insertAttach",e);
            throw new GlobalException(ResultCode.EXCEPTION.code(), "添加附件失败");
        }
        return index;
    }

    /**
     * 删除附件
     * @param query
     * @return
     * @throws Exception
     */
    @Override
    public int deleteAttach(CltAttachQuery query) throws Exception {
        if (StringUtils.isEmpty(query.getFuncId())) {
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"操作步骤id不能为空");
        }
        int index = 0;
        try {
            CltAttachExample example = new CltAttachExample();
            CltAttachExample.Criteria criteria = example.createCriteria();
            criteria.andFuncIdEqualTo(query.getFuncId());
            index = attachMapper.deleteByExample(example);
        }catch (Exception e){
            throw new GlobalException(ResultCode.EXCEPTION.code(),"删除附件失败");
        }
        return index;
    }
}
