package com.llk.laborsystem.controller.meunCls;

import com.llk.laborsystem.bean.users.MenuCls;
import com.llk.laborsystem.service.menu.MenuClsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuClsController {

    @Autowired
    private MenuClsService menuClsService;

    //查询全部父级菜单
    @RequestMapping("/parentMenuClsList")
    @ResponseBody
    List<MenuCls> parentMenuClsList(){
        return menuClsService.parentMenuClsList();
    }


    //查询父级有多少子菜单
    @RequestMapping("/childrenMenuClsList")
    @ResponseBody
    List<MenuCls> childrenMenuClsList(){//@RequestBody Integer pId

        //创建一个新的集合重新存放数据
        List<MenuCls> menuClsList=new ArrayList<>();
        //查询全部父子级菜单
        List<MenuCls> menuCls = menuClsService.childrenMenuClsList();
        //遍历查询
        for (MenuCls menuCl : menuCls) {
            if (menuCl.getPId()==0){//先判断父级(判断pid==0,是0就是父级)说明menuCl对象是父级
                menuClsList.add(menuCl);//存放父级菜单
            }else {//pid不是0的话menuCl对象就是子级就走else
                for (MenuCls cl : menuCls) {
                    if (menuCl.getPId()==cl.getMId()){//根据menuCl的pid(走else了就是子级)==cl的mid(它是父级)判断该菜单是哪个父级菜单的子菜单,并存放到父级菜单里面
                        cl.getChildren().add(menuCl);
                        break;
                    }
                }
            }
        }
        return menuClsList;
    }
}
