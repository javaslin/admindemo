package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.dao.AdminUserDAO;
import com.sl.boot.admindemo.dto.UserDTO;
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

    @PostMapping(value = "/delOneUser")
    public BaseResp delOnerUser(@RequestBody UserDTO userDTO) {
        UserVo userVo = new UserVo();
        userVo.setUserName(userDTO.getUserName());
        if (userDTO.getUserType().equals("管理员")) {
            userVo.setType(1);
        } else if (userDTO.getUserType().equals("药库管理员")) {
            userVo.setType(2);
        } else if (userDTO.getUserType().equals("医生")) {
            userVo.setType(3);
        } else if (userDTO.getUserType().equals("病患")) {
            userVo.setType(4);
        }
        adminUserService.delUser(userVo.getUserName(), userVo.getType());
        return new BaseResp();
    }

    @GetMapping(value = "/all")
    public BaseResp getAllUser() {
        return new BaseResp(adminUserService.queryAllUser());
    }


}
