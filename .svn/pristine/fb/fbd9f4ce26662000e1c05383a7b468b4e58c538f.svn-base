package net.northking.cloudplatform.service.user;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.dto.auth.AuthToken;
import net.northking.cloudplatform.dto.auth.Authority;
import net.northking.cloudplatform.query.auth.AuthQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.query.user.UserUpdatePwd;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface UserLoginService {

    ResultInfo<String> checkVerificationCode(UserLoginQuery userLoginQuery) throws Exception;

    AuthToken authLogin(AuthQuery authQuery) throws Exception;

    CltUserLogin getLoginUser(AuthToken authToken) throws Exception;

    ResultInfo<Authority> getUserFuncList(String authorization,String parentFuncId) throws Exception;

}
