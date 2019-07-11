package com.didispace.web;

import com.didispace.bean.User;
import com.didispace.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *@Author chenyun
 * @blog https://blog.csdn.net/sss996
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(Long id) {

        User user = userDao.findOne(id);

        return user;
    }

}