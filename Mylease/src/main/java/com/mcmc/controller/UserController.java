package com.mcmc.controller;

import com.mcmc.common.entity.User;
import com.mcmc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sunlei on 2017/10/12.
 * controller
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session) throws IOException {

        if(studentService.checkLogin(user.getUserName(),user.getPassword())){
//            session.setAttribute("user", user);
            return "index";
        }
        return "redirect:/login.jsp";
    }
}
