package com.llk.laborsystem.service.project;


import com.llk.laborsystem.bean.project.Projects;

import java.util.List;

public interface ProjectsService {
    //查询全部项目+搜索+分页
    List<Projects> getProjectList(Projects projects);

    //查询单个项目
    Projects getProjectById(Projects projects);

    //添加
    Boolean addProject(Projects projects);


    //删除
    Boolean delProject(Integer id);

    //修改
    Boolean editProject(Projects projects);

    //查询全部条数
    Long total(Projects projects);

    //全部项目类型
    List allTypes();


    //全部总承包单位
    List allGeneralContractor();

    //全部施工单位
    List allConstructionUnit();
}
