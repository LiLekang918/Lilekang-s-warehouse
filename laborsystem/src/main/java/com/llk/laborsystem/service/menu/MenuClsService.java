package com.llk.laborsystem.service.menu;

import com.llk.laborsystem.bean.users.MenuCls;

import java.util.List;


public interface MenuClsService {
    //查询全部父级菜单
    List<MenuCls> parentMenuClsList();


    //查询父级有多少子菜单
    List<MenuCls> childrenMenuClsList();

}
