package com.mooc.house.biz.service;


import com.mooc.house.biz.mapper.UserMapper;
import com.mooc.house.common.model.User;
import com.mooc.house.common.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.selectUsers();
    }

    /**
     * 1.插入数据库, 非激活; 密码加盐md5; 保存头像到本地
     * 2.生成key, 绑定email
     * 3.发送邮件给用户
     * @param account
     * @return
     */
    public boolean addAccount(User account){
        account.setPasswd(HashUtils.encryPassword(account.getPasswd()));
        return false;
    }
}
