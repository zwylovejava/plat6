package net.northking.cloudplatform.service.impl;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.user.CltFuncRoleMapper;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.domain.user.CltFuncRoleExample;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.service.FuncRoleService;
import net.northking.cloudplatform.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title: 功能角色逻辑实现类
 * @Description:
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017/11/11
 * @UpdateUser:
 * @Version:0.1
 */
@Service
public class FuncRoleServiceImpl extends BaseServiceImpl<CltFuncRole, CltFuncRoleExample, String> implements FuncRoleService {

    @Autowired
    private CltFuncRoleMapper cltFuncRoleMapper;

    private final static Logger logger = LoggerFactory.getLogger(FuncRoleServiceImpl.class);

    //根据角色ID查询所属功能
    @Override
    public Page<CltFunc> queryByRoleId(String roleId) throws Exception {

        List<CltFunc> cltFuncRoleList = null;
        try{
            cltFuncRoleList = cltFuncRoleMapper.selectByRoleId(roleId);
        }catch (Exception e){
            logger.error("queryByRoleId",e);
            throw new GlobalException(ErrorConstants.QUERY_FUNC_ROLE_ERROR_CODE,ErrorConstants.QUERY_FUNC_ROLE_ERROR_MESSAGE);
        }
        return new Page<>(cltFuncRoleList);
    }



    //根据funRoleIds批量删除角色功能表
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public String deleteFuncRoleByfunRoleIds(FuncRoleQuery funcRoleQuery) throws Exception {

        String[] funcRoleIds = funcRoleQuery.getFuncRoleIds();

        Integer count = 0;

        String msg = "";

        for (int i = 0; i < funcRoleIds.length; i++) {
            String funcRoleId = funcRoleIds[i];

            try{

                int deleteCount = cltFuncRoleMapper.deleteByPrimaryKey(funcRoleId);
                //判断要删除的对象是否存在
                if (deleteCount == 0) {
                    msg += "id为" + funcRoleId + "的数据不存在";
                } else {
                    count++;
                }

            }catch (Exception e){

                logger.error("deleteFuncRoleByfunRoleIds", e);

                throw new GlobalException(ErrorConstants.DELETE_CLT_FUNC_ROLE_BY_FUNCROLEIDS_BATCH_ERROR_CODE, ErrorConstants.DELETE_CLT_FUNC_ROLE_BY_FUNCROLEIDS_BATCH_ERROR_MESSAGE);

            }

        }
        msg = "删除的数据个数为" + count + "  " + msg;
        //返回拼接好的字符串
        return msg;

    }


    //批量添加功能角色
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Integer addFuncRoles(FuncRoleQuery funcRoleQuery) throws Exception {

        //先删除已有的数据,再添加
        //根据角色ID 删除所有的funcId数据（多条）
        cltFuncRoleMapper.deleteFuncListByRoleIds(funcRoleQuery.getRoleId());

        Integer addNum=0;

        String[] funcIds= funcRoleQuery.getFuncIds();

        String roldId=funcRoleQuery.getRoleId();

        CltFuncRole cltFuncRole=new CltFuncRole();

        for (int i = 0; i < funcIds.length; i++) {

            String funcId = funcIds[i];

            try{
                cltFuncRole.setFuncRoleId(UUIDUtil.getUUID());

                cltFuncRole.setRoleId(roldId);

                cltFuncRole.setFuncId(funcId);

                int result =cltFuncRoleMapper.insertSelective(cltFuncRole);

                if (result>0){
                    addNum++;
                }
            }catch (Exception e){

                logger.error("addFuncRole",e);

                throw new GlobalException(ErrorConstants.ADD_CLT_FUNC_ROLE_BATCH_ERROR_CODE, ErrorConstants.ADD_CLT_FUNC_ROLE_BATCH_ERROR_MESSAGE);
            }


        }

        return addNum;

    }

}
