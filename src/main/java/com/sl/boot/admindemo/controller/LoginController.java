package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.dao.PwdUserDAO;
import com.sl.boot.admindemo.entity.PwdUser;
import com.sl.boot.admindemo.entity.PwdUserExample;
import com.sl.boot.admindemo.vo.LoginVo;
import com.sl.boot.admindemo.vo.resp.LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private PwdUserDAO pwdUserDAO;


    @PostMapping("/login")
    public LoginResp login(@RequestBody LoginVo loginVo) {

        LoginResp loginResp = new LoginResp();

        PwdUserExample pwdUserExample = new PwdUserExample();
        pwdUserExample.createCriteria().andUserNameEqualTo(loginVo.getUsername()).andPasswordEqualTo(loginVo.getPassword());
        List<PwdUser> pwdUsers = pwdUserDAO.selectByExample(pwdUserExample);
        if (pwdUsers.size() == 0) {
            return new LoginResp(404, "用户名或密码错误");
        }

        PwdUser pwdUser = pwdUsers.get(0);
        if (!loginVo.getRole().equals(pwdUser.getUserType().toString())) {
            return new LoginResp(424, "用户名或密码错误");
        }
        if (loginVo.getPassword().equals(pwdUser.getPassword())) {
            loginResp.setType(pwdUser.getUserType());
        }
        return loginResp;

    }
}
