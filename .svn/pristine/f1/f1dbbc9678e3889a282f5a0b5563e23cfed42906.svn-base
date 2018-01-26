package net.northking.cloudplatform.security;

import lombok.extern.slf4j.Slf4j;

import net.northking.cloudplatform.dao.user.CltUserLoginMapper;
import net.northking.cloudplatform.domain.user.CltRole;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by chuangsheng.huang on 2017/11/25.
 */
//@Service("userDetailsService")
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private CltUserLoginMapper cltUserLoginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CltUserLogin cltUserLogin = cltUserLoginMapper.findOneWithRolesByLoginNo(username);
        Optional<CltUserLogin> realUser = Optional.of(cltUserLogin);



        return realUser.map(user -> {
            Set<GrantedAuthority> userAuthotities = new HashSet<>();
            for(CltRole role : user.getRoles()){
                userAuthotities.add(new SimpleGrantedAuthority(role.getRoleCode()));
            }
            Set<GrantedAuthority> grantedAuthorities = userAuthotities;
            return new User(user.getLoginNo(),user.getLoginPwd(),grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("用户" + username + "不存在!"));
    }
}
