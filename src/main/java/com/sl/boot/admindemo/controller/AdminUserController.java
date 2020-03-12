package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.dao.AdminUserDAO;
import com.sl.boot.admindemo.service.AdminUserService;
import com.sl.boot.admindemo.vo.UserVo;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/adminUser")
public class AdminUserController {


    @Autowired
    private AdminUserService adminUserService;

    @PostMapping(value = "/addOne")
    public BaseResp addOnerUser(@RequestBody UserVo userVo) {
        adminUserService.addOneUser(userVo.getUserName(), userVo.getPassWord(), userVo.getType());
        return new BaseResp();
    }

    @DeleteMapping(value = "/delOneUser")
    public BaseResp delOnerUser(@RequestBody UserVo userVo) {
        adminUserService.delUser(userVo.getUserName(), userVo.getType());
        return new BaseResp();
    }

    @GetMapping(value = "/all")
    public BaseResp getAllUser() {
        return new BaseResp(adminUserService.queryAllUser());
    }


}
