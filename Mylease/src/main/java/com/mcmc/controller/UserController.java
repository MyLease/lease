package com.mcmc.controller;

import com.mcmc.common.entity.User;
import com.mcmc.dao.StudentDao;
import com.mcmc.dao.UserDao;
import com.mcmc.service.StudentService;


import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/login")
    public String login(User user, HttpSession session) throws IOException {

        if(studentService.checkLogin(user.getUserName(),user.getPassword())){
//            session.setAttribute("user", user);
            return "index";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/seeUser")
    @ResponseBody

    //public List<User> lselectAllUser(){
       //List<User> list = studentDao.selectAllUser();
       //System.out.println(list.get(0).getPassword());
        //JSONObject json = new JSONObject();
        //json.put("allUser", list);
        //String json="{\"data\":" + JSONArray.fromObject(list) + "}";
        //String json="{"+JSONArray.fromObject(list) + "}";
        //return list;
        //JSONObject obj = new JSONObject();
        //obj.put("list", list);
        //return obj.toString();
    public JSONObject selectAllUser(){

        List<User> list =studentService.selectAllUser();
        //System.out.println(list.get(0).getPassword());
        JSONObject json = new JSONObject();
        json.put("allUser", list);
        //String json="{\"data\":" + JSONArray.fromObject(list) + "}";
        //String json="{"+JSONArray.fromObject(list) + "}";

        //JSONObject json = new JSONObject();
        //json.put("username","swillion");
        //json.put("password","123456");
        return json;
    }
    @RequestMapping("/selectUserByName")
    @ResponseBody
    public JSONObject selectUserByName(User user, HttpSession session){
        List<User> list=studentService.selectUserByName(user.getUserName());
        JSONObject json = new JSONObject();
        json.put("allUser", list);
        return json;
    }
}
