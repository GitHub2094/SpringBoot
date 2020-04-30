package com.lsm.frame.utils;

import com.alibaba.fastjson.serializer.MapSerializer;
import com.lsm.frame.constant.enums.RoleOperation;
import com.lsm.frame.constant.enums.UserType;
import com.lsm.frame.model.entity.Role;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.aspectj.weaver.TypeFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 明文转密文
 */
public class Test {
    public static void main(String[] args) {
        String hashAlgorithName = "MD5";
        //密码
        String password = "111111";
        //加密次数
        int hashIterations = 1024;
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes("33333333");
        String newpassword = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations).toHex();
        System.out.println(newpassword);
        UserType userType = UserType.valueOf("STUDENT");
        System.out.println(userType.op());
    }
}




