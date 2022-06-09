package com.llk.laborsystem.service.regin;

import com.llk.laborsystem.bean.Region;

import java.util.List;

public interface ReginService {
    //查询全部省
    List<Region> getProvince();

    //通过父类id查询全部市
    List<Region> getCity(Integer parentId);

    //查询全部县
    List<Region> getCounty(Integer parentId);
}
