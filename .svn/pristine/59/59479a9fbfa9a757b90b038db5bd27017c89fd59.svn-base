package net.northking.cloudplatform.service.impl;


import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.user.CltProjectTeamMapper;
import net.northking.cloudplatform.domain.user.CltProjectTeam;
import net.northking.cloudplatform.domain.user.CltProjectTeamExample;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.service.ProjecTeamtService;
import net.northking.cloudplatform.utils.UUIDUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class ProjectTeamServiceImpl extends BaseServiceImpl<CltProjectTeam, CltProjectTeamExample, String> implements ProjecTeamtService {
    @Autowired
    private CltProjectTeamMapper cltProjectTeamMapper;

    @Autowired
    private RedisUtil redisUtil;


    //日志
    private final static Logger logger = LoggerFactory.getLogger(ProjectTeamServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Integer createTeam(List<CltProjectTeamQuery> listCltProjectTeamQuery) {

          Integer addNum=0;

        CltProjectTeam cltProjectTeam = new CltProjectTeam();
        cltProjectTeam.setCreateDate(new Date());
        cltProjectTeam.setUpdateDate(cltProjectTeam.getCreateDate());
        cltProjectTeam.setProId(listCltProjectTeamQuery.get(0).getProId());
        cltProjectTeam.setTeamName("团队" + System.currentTimeMillis());
        CltUserLogin cltUserLogin = (CltUserLogin)redisUtil.get(listCltProjectTeamQuery.get(0).getAccess_token());
        cltProjectTeam.setCreateUser(cltUserLogin.getLoginNo());
        cltProjectTeam.setUpdateUser(cltProjectTeam.getCreateUser());
        for(CltProjectTeamQuery cltProjectTeamQuery:listCltProjectTeamQuery){
            cltProjectTeam.setTeamId(UUIDUtil.getUUID());
            cltProjectTeam.setUserId(cltProjectTeamQuery.getUserId());
            String roleId = cltProjectTeamQuery.getRoleId();
            if(StringUtils.isEmpty(roleId)){
                throw  new GlobalException(ResultCode.INVALID_PARAM.msg(),"角色ID为空");
            }
                cltProjectTeam.setRoleId(roleId);
                //根据项目ID用户id和角色ID去查询是否重复插入相同数据
                int integer = cltProjectTeamMapper.countByProIdAndUserIdAndRoleId(cltProjectTeamQuery.getProId(), roleId, cltProjectTeamQuery.getUserId());
                if(integer>0){
                    throw  new GlobalException(ResultCode.INVALID_PARAM.msg(),"不能重复插入数据");

                }
              addNum = cltProjectTeamMapper.insertSelective(cltProjectTeam);


        }
        cltProjectTeam = null;
        return addNum;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Integer removeUserByIds(List<CltProjectTeamQuery> cltProjectTeamQuery) {

          Integer delteNum=0;

         if(cltProjectTeamQuery==null){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(), "参数不能为空");
         }
        for(CltProjectTeamQuery clt:cltProjectTeamQuery){
            if("".equals(clt.getProId())||clt.getProId()==null){
                throw new GlobalException(ResultCode.INVALID_PARAM.code(), "项目ID不能为空");
            }
            if("".equals(clt.getUserId())||clt.getUserId()==null){
                throw new GlobalException(ResultCode.INVALID_PARAM.code(), "用户ID不能为空");
            }
            if(StringUtils.isEmpty(clt.getUserId())){
                throw new GlobalException(ResultCode.INVALID_PARAM.code(), "角色ID不能为空");
            }

            delteNum= cltProjectTeamMapper.deleteByUserIds(clt.getProId(), clt.getUserId(), clt.getRoleId());


        }

        return delteNum;
    }



    //根据项目ID,用户ID,角色ID查询项目
    @Override
    public CltProjectTeam selectByProIdAndUserIdAndRoleId(CltProjectTeamQuery cltProjectTeamQuery) {
        try {

            String proId = cltProjectTeamQuery.getProId();
            String roleId = cltProjectTeamQuery.getRoleId();
            String userId = cltProjectTeamQuery.getUserId();

            CltProjectTeam cltProjectTeam = cltProjectTeamMapper.selectByProIdAndUserIdAndRoleId(proId, roleId, userId);

            return cltProjectTeam;

        } catch (Exception e) {

            logger.error("selectByProIdAndUserIdAndRoleId", e);

            throw new GlobalException(ErrorConstants.QUERY_PROJECTTEAM_BY_PROIDANDUSERIDANDROLEID_ERROR_CODE, ErrorConstants.QUERY_PROJECTTEAM_BY_PROIDANDUSERIDANDROLEID_ERROR_MESSAGE);
        }

    }



    //根据角色ID和用户ID查询团队表记录数
    @Override
    public Integer countByRoleIdAndUserId(CltProjectTeamQuery cltProjectTeamQuery) {

         String roleId = cltProjectTeamQuery.getRoleId();
         String userId = cltProjectTeamQuery.getUserId();
         Integer count=0;

        try {

            count = cltProjectTeamMapper.countByRoleIdAndUserId(roleId,userId);

            return count;

        } catch (Exception e) {

            logger.error("countByRoleIdAndUserId", e);

            throw new GlobalException(ErrorConstants.QUERY_COUNT_PROJECTTEAM_BY_PROIDANDUSERIDANDROLEID_ERROR_CODE, ErrorConstants.QUERY_COUNT_PROJECTTEAM_BY_PROIDANDUSERIDANDROLEID_ERROR_MESSAGE);
        }

    }

    }



