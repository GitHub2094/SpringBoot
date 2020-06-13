package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.UserMapper;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.string.Convert;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByLoginName(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public boolean matches(User user, String oldPassword) {
        return  user.getPassword().equals(encryptPassword(oldPassword,user.getSalt()));
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public String encryptPassword( String password, String salt)
    {
        String hashAlgorithName = "MD5";
        //加密次数
        int hashIterations = 1024;
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        String newPassword = new SimpleHash(hashAlgorithName, password,credentialsSalt, hashIterations).toHex();
        return newPassword;
    }

    @Override
    public List<User> selectUserTable(User user) {
        return userMapper.selectUserTable(user);
    }

    @Override
    public int deleteUserByIds(String ids) {
        Integer[] userIds = Convert.toIntArray(ids);
        return userMapper.deleteUserByIds(userIds);
    }
}
