package com.aust.ssml.controller;

import com.aust.ssml.model.UserInfo;
import com.aust.ssml.service.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

@RequestMapping(value = "/user")
public class HomeController {

    private IUserRegisterService registerService;

    @Autowired
    public void setRegisterService(IUserRegisterService registerService) {
        this.registerService = registerService;
    }

    //注册页面
    @RequestMapping(value = "/RegUser")
    public String RegUser() {
        return "register";
    }

    @RequestMapping(value = "/AddUser")
    public String AddUser(
            @RequestParam("username") String username,
            @RequestParam("userpassword") String userpassword,
            @RequestParam("useremail") String email,
            @RequestParam("userphone") String phone) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(username);
        userInfo.setUpwd(userpassword);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);
//        User user = new User();
//        user.registerUser(userInfo);
        registerService.placeUser(userInfo.getUserName(), userInfo.getPhone(), userInfo.getEmail(), userInfo.getUpwd());
        System.out.println("进入注册页面");
        return "login";
    }

    @RequestMapping(value = "/showLogin")
    public String showLogin() {
        return "login";
    }

    /*验证用户
     */
    @RequestMapping(value = "/Login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("userpassword") String userpassword) {
        String upwd = registerService.selectUser(username);
            //成功则进入欢迎页面
            if (upwd.equals(userpassword)) {
                return "welcome";
            }
        //失败返回登录页面
        return "login";
    }
}
