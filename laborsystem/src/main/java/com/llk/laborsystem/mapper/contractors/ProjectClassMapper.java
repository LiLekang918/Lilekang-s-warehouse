package com.llk.laborsystem.mapper.contractors;

import com.llk.laborsystem.bean.contractors.ProjectClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectClassMapper {

    @Select("select * from t_project_class")
    List<ProjectClass> getProjectClassList();//查询全部项目类别

    //查询单个类别
    @Select("select * from t_project_class where c_id=#{cId}")
    ProjectClass getClsById(Integer cId);
}
