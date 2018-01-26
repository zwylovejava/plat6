package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltUser;
import net.northking.cloudplatform.domain.user.CltUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CltUserMapper extends BaseDao<CltUser, CltUserExample, String> {
    String selectUserByEmail(String email);

    //根据用户id批量修改orgId
    int updateOrgIdByPrimaryKeySelective(@Param("userId") String userId, @Param("orgId") String orgId);
}