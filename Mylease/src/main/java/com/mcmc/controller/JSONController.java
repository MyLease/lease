package com.mcmc.controller;

import com.mcmc.common.entity.User;
import com.mcmc.common.utils.BeanToJson;
import com.mcmc.common.utils.PageBean;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lw
 * @time 2017/9/12 19:38
 */
@Controller
@RequestMapping(value = "/json")
public class JSONController extends AbstractController {

    @RequestMapping(value = "getJson")
    public void getJson() {

        List userList = new ArrayList();

        for(int i=0; i<5; i++) {
            User user = new User();

            user.setUserName("swillion");
            user.setPassword("123456");

            userList.add(user);
        }

        this.putJson("1",userList);

        sendJson();
    }
}
