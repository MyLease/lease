package com.mcmc.service;

import com.mcmc.common.entity.User;
import com.mcmc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by sunlei on 2017/10/12.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public boolean checkLogin(String userName, String password) {
        boolean flag = false;
        User user = studentDao.selectOneStudent(userName, password);
        if(user != null) {
            System.out.print(userName);
            System.out.print(password);
            System.out.print("登陆成功");
            flag = true;
        }
        System.out.print(userName);
        System.out.print(password);
        System.out.print("登陆失败");

        return flag;
    }
}
