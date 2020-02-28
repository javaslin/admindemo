package com.sl.boot.admindemo.controller;

import com.sl.boot.admindemo.entity.User;
import com.sl.boot.admindemo.service.UserService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author s4n
 * @since 2020-02-27 22:20:16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }


    @GetMapping("/alluser")
    public BaseResp queryAllUsers() {
        List<User> users = this.userService.queryAllByLimit(0, 20);
        return new BaseResp(users.size(), users);
    }

}