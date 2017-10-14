package com.mcmc.controller;

import com.mcmc.common.entity.User;
import com.mcmc.dao.StudentDao;
import com.mcmc.service.StudentService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by sunlei on 2017/10/12.
 * controller
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private StudentService studentService;

    @Autowired

    private StudentDao studentDao;

    @RequestMapping("/login")
    public String login(User user, HttpSession session) throws IOException {

        if(studentService.checkLogin(user.getUserName(),user.getPassword())){
//            session.setAttribute("user", user);
            return "index";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/seeUser")
    public String selectAllUser(){
        List<User> list = studentDao.selectAllUser();
        System.out.println(list.get(0).getPassword());
        //JSONObject json = new JSONObject();
        //json.put("allUser", list);
        //String json="{\"data\":" + JSONArray.fromObject(list) + "}";
        String json="{"+JSONArray.fromObject(list) + "}";
        return json;

    }
}
