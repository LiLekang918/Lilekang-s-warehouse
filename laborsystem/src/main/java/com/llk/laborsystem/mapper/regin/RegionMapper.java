package com.llk.laborsystem.mapper.regin;

import com.llk.laborsystem.bean.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionMapper {

    //查询全部省
    @Select("select * FROM t_province")
    List<Region> getProvince();

    //通过父类id查询全部市
    @Select("select * FROM t_city WHERE parent_id=#{parentId}")
    List<Region> getCity(Integer parentId);

    //查询全部县
    @Select("select * FROM t_county WHERE parent_id=#{parentId}")
    List<Region> getCounty(Integer parentId);

}
