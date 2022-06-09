package com.llk.laborsystem.service.impl.regin;

import com.llk.laborsystem.bean.Region;
import com.llk.laborsystem.mapper.regin.RegionMapper;
import com.llk.laborsystem.service.regin.ReginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReginServiceImpl implements ReginService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public List<Region> getProvince() {
        return regionMapper.getProvince();
    }

    @Override
    public List<Region> getCity(Integer parentId) {
        return regionMapper.getCity(parentId);
    }

    @Override
    public List<Region> getCounty(Integer parentId) {
        return regionMapper.getCounty(parentId);
    }
}
