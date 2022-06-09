package com.llk.laborsystem.service.impl.users;

import com.llk.laborsystem.bean.users.Users;
import com.llk.laborsystem.mapper.users.UsersMapper;
import com.llk.laborsystem.service.users.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users userLogin(Users users) {
        //MD5解密
        users.setUPass(MD5Encryption(users));
        return usersMapper.userLogin(users);
    }

    @Override
    public void addUser(Users users) {
        usersMapper.addUser(users);
    }

    @Override
    public Users getUserByName(String uName) {
        return usersMapper.getUserByName(uName);
    }

    @Override
    public Users getUserById(Integer uId) {
        return usersMapper.getUserById(uId);
    }

    @Override
    public Boolean editUser(Users users){
        //MD5加密
        users.setUPass(MD5Encryption(users));
        return usersMapper.editUser(users);
    }

    @Override
    public Users getEmail(Users users) {
        return usersMapper.getEmail(users);
    }

    //MD5加密方法
    public static String MD5Encryption(Users users){
        MessageDigest md= null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(users.getUPass().getBytes());
        String encryption=new BigInteger(1,md.digest()).toString(16);
        System.out.println("加密后的🔐："+encryption);
        return encryption;//返回加密后的密码
    }
}
