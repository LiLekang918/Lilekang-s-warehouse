package com.llk.laborsystem.mapper.project;

import com.llk.laborsystem.bean.project.ConstructionUnit;
import com.llk.laborsystem.bean.project.GeneralContractor;
import com.llk.laborsystem.bean.project.ProjectType;
import com.llk.laborsystem.bean.project.Projects;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectsMapper {

    //查询全部项目+搜索+分页
    List<Projects> getProjectList(@Param("projects") Projects projects);

    //查询单个
    @Select("SELECT * FROM t_items i JOIN t_constructionUnits c JOIN t_generalContractors g JOIN t_project_type p where i.construction_unit=c.id AND i.general_contractor=g.id AND i.cls_id=p.id AND i.id=#{id}")
    Projects getProjectById(Projects projects);

    //添加
    Boolean addProject(@Param("projects") Projects projects);


    //删除
    Boolean delProject(Integer id);

    //修改
    Boolean editProject(Projects projects);

    //查询全部条数
    Long total(Projects projects);

    //全部项目类型
    @Select("SELECT * FROM t_project_type")
    List<ProjectType> allTypes();


    //全部总承包单位
    @Select("SELECT * FROM t_generalContractors")
    List<GeneralContractor> allGeneralContractor();

    //全部施工单位
    @Select("SELECT * FROM t_constructionUnits")
    List<ConstructionUnit> allConstructionUnit();
}
