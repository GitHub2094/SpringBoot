package com.lsm.frame.config;

import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserRoleService;
import com.lsm.frame.service.intf.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import javax.security.sasl.SaslServer;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 *
 * @author lsm
 * @create 2019-01-27-13:57
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        System.out.println("------获取权限------");
        User user = (User)pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        String role =userRoleService.selectKeyByUserID(user.getUserId());
        // 角色列表
        Set<String>roles = new HashSet<String>();
        // 功能列表
        //Set<String> menus = new HashSet<String>();
        //menus.add("system:student");
        //info.setStringPermissions(menus);

        roles.add(role);
        info.setRoles(roles);
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String userName = upToken.getUsername();
        User user = null;
        try{
            user = userService.selectByLoginName(userName);
            System.out.println("打印通过登录账号查找到的用户"+user);
        }
        catch (NullPointerException e){
            throw new AuthenticationException(e.getMessage(), e);
        }
        catch (Exception e){
            throw new AuthenticationException(e.getMessage(),e);
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        return info;
    }
}
