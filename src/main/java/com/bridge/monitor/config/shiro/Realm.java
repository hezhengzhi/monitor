package com.bridge.monitor.config.shiro;

import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.repo.UserRepo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created by pc on 2019/2/21 9:35
 **/
public class Realm extends AuthorizingRealm {

    @Resource
    private UserRepo userRepo;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected org.apache.shiro.authc.AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String username = (String) token.getPrincipal();
        UserPo user = userRepo.findByName(username);
        String password = user.getPassword();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                username, password, getName()
        );
        return info;
    }
}
