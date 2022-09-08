package com.example.waterdeliverysystem.controller;


import com.example.waterdeliverysystem.model.User;
import com.example.waterdeliverysystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserWeb {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/test")
    @ResponseBody
    public String test(){

        List<User> userList = userService.getUserList();

        String res = "";

        for (User user:userList
             ) {
            res+=user.toString();
        }

        return res;
    }



    @GetMapping("/")
    public String toLogin(){


        return "login";
    }


    //  handleLogin

    @PostMapping("/handleLogin")
    public String handleLogin(User user, HttpSession session){

        User login = userService.login(user);

        if(login != null){
            //登录成功 将该用户信息 保存在session会话中
            session.setAttribute("id",login.getId());
            session.setAttribute("userName",login.getUserName());

            return "index";
        }else{
            return "loginFail";
        }
    }



    @GetMapping("/toUpdatePassword")
    public String toUpdatePassword(HttpSession session, Model model){

        int id = (int)session.getAttribute("id");

        User userById = userService.getUserById(id);
        model.addAttribute("user",userById);

        return "updateUserPassword";

    }

    // handleUpdatePassword
    @PostMapping("/handleUpdatePassword")
    public String handleUpdatePassword(User user, HttpSession session){

        int count = userService.updatePassword(user);

        if(count == 1){
            //密码修改成功  删除session中的用户数据
            session.removeAttribute("id");
            session.removeAttribute("userName");

            return "login";
        }else{
            return "updateFail";
        }


    }


}
