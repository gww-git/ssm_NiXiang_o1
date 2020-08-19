package com.sz.controller;

import com.sz.entity.Users;
import com.sz.service.IUserService;
import com.sz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/byuser")
    public List<Users> BuUsers(){
        return userService.ByUsers();
    }


    @RequestMapping("/byname")
    public List<Users> ByUserLikeName(){
        return userService.ByUsersName("肖");
    }

    @RequestMapping("/byname2")
    public List<Users> ByUserLikeNameOrId(){
        return userService.ByUsers2(null);
    }


    @RequestMapping("/update")
    public int update(){
        Users users=new Users();
        users.setId(10);
        users.setName(" 萧筱");
        return userService.update(users);
    }


    @RequestMapping("/delete")
    public int delete(){
        return userService.delete(10);
    }


    @RequestMapping("/save")
    public int save(){
        Users users=new Users();
        users.setName("");
        return userService.save(users);
    }


}
