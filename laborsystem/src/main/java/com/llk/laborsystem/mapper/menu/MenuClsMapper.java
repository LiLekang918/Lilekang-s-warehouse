package com.llk.laborsystem.mapper.menu;

import com.llk.laborsystem.bean.users.MenuCls;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuClsMapper {

    //查询全部父级菜单
    @Select("SSELECT * FROM t_menu WHERE p_id=0")
    List<MenuCls> parentMenuClsList();


    //查询父级有多少子菜单
    @Select("SELECT * FROM t_menu")
    List<MenuCls> childrenMenuClsList();

}
