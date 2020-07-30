package com.aust.ssml.service;


import com.aust.ssml.mapper.UserRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
// 接口
public class UserRegisterServiceImpl implements com.aust.ssml.service.IUserRegisterService {

    private UserRegisterMapper registerMapper;

    @Autowired
//    可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    public void setRegisterMapper(UserRegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

//    public void setInfoSelectMapper(UserInfoSelectMapper infoSelectMapper) {
//        this.infoSelectMapper = infoSelectMapper;
//    }

    @Override
    //    重写父类方法
    @Transactional
    //    访问数据库事务管理
    public void placeUser(String username, String phone, String email, String  userpwd) {
        registerMapper.insertUser(username, userpwd, email, phone);
    }

    @Override
    public String selectUser(String username) {
        String upwd = registerMapper.selectUser(username);
        return upwd;
    }
}