package com.llk.laborsystem.service.users;

import com.llk.laborsystem.bean.users.Users;

import java.security.NoSuchAlgorithmException;

public interface UsersService {

    //判断账号密码是否正确

    Users userLogin(Users users);


    //注册
    void addUser(Users users);


    //查询是否有该用户
    Users getUserByName(String uName);


    //通过id查询是否有该用户
    Users getUserById(Integer uId);

    //修改密码
    Boolean editUser(Users users) throws NoSuchAlgorithmException;

    //查询是否有该邮箱
    Users getEmail(Users users);
}
