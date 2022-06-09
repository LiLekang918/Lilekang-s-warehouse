package com.llk.laborsystem.mapper.users;


import com.llk.laborsystem.bean.users.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {

    //判断账号密码是否正确

    @Select("SELECT * FROM t_users WHERE u_name=#{uName} AND u_pass=#{uPass}")
    Users userLogin(Users users);


    //注册
    @Insert("INSERT INTO t_users VALUES(0,#{uName},#{uPass},#{uGender},#{uEmail})")
    void addUser(Users users);


    //通过账号查询是否有该用户
    @Select("SELECT * FROM t_users WHERE u_name=#{uName}")
    Users getUserByName(String uName);

    //通过id查询是否有该用户
    @Select("SELECT * FROM t_users WHERE u_id=#{uId}")
    Users getUserById(Integer uId);

    //修改密码
    @Update("UPDATE t_users SET u_pass=#{uPass} WHERE u_email=#{uEmail}")
    Boolean editUser(Users users);


    //查询是否有该邮箱
    @Select("SELECT * FROM t_users WHERE u_email=#{uEmail}")
    Users getEmail(Users users);
}
