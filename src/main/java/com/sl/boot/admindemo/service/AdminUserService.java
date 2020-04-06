package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.dto.UserDTO;
import com.sl.boot.admindemo.entity.AdminUser;
import com.sl.boot.admindemo.entity.PwdUser;
import com.sl.boot.admindemo.vo.resp.BaseResp;

import java.util.List;

public interface AdminUserService {


    Integer addOneUser(String userName, String password, Integer type);

    Integer delUser(String userName, Integer type);

    List<UserDTO> queryAllUser(Integer page, Integer limit, BaseResp baseResp);

    Integer updateOne(Integer id, String userName, String password, Integer type);


}
