package com.ding.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session,String username,String pwd) throws Exception{
        //调用service进行身份验证
        //session中保存身份信息
        session.setAttribute("username",username);
        session.setAttribute("pwd",pwd);
        //重定向到商品列表
        return "redirect:items";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        //清除session
        session.invalidate();
        //重定向到商品列表
        return "redirect:items";
    }
}
