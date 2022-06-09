package com.llk.laborsystem.service.impl.menu;

import com.llk.laborsystem.bean.users.MenuCls;
import com.llk.laborsystem.mapper.menu.MenuClsMapper;
import com.llk.laborsystem.service.menu.MenuClsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuClsServiceImpl implements MenuClsService {

    @Resource
    private MenuClsMapper menuClsMapper;

    @Override
    public List<MenuCls> parentMenuClsList() {
        return menuClsMapper.parentMenuClsList();
    }

    @Override
    public List<MenuCls> childrenMenuClsList() {
        return menuClsMapper.childrenMenuClsList();
    }
}
