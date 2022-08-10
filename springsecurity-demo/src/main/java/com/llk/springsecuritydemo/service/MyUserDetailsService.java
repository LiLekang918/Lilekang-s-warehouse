package com.llk.springsecuritydemo.service;

//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llk.springsecuritydemo.bean.Users;
import com.llk.springsecuritydemo.mapper.UsersMapper;
import org.omg.CORBA.UserException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        QueryWrapper<Users> wrapper=new QueryWrapper<>();
//        wrapper.eq("username",username);
//        Users users = usersMapper.selectOne(wrapper);
        Users users = usersMapper.getUserByName(username);
        //判断
        if(users==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);
    }
}
