package com.llk.springsecuritydemo.mapper;

import com.llk.springsecuritydemo.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper{

    @Select("select * from users where username=#{username}")
    Users getUserByName(String username);

}
