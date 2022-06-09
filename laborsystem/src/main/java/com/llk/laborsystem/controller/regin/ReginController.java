package com.llk.laborsystem.controller.regin;


import com.llk.laborsystem.bean.Region;
import com.llk.laborsystem.service.regin.ReginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/regin")
@Controller
public class ReginController {

    @Autowired
    private ReginService reginService;

    //查询所有父级
    @RequestMapping("/getProvince")
    @ResponseBody
    public List<Region> getProvince() {
        return reginService.getProvince();
    }

    //通过父类id查询全部市
    @RequestMapping("/getCity")
    @ResponseBody
    public List<Region> getCity(Integer parentId) {
        return reginService.getCity(parentId);
    }

    //查询全部县
    @RequestMapping("/getCounty")
    @ResponseBody
    public List<Region> getCounty(Integer parentId) {
        return reginService.getCounty(parentId);
    }

}
