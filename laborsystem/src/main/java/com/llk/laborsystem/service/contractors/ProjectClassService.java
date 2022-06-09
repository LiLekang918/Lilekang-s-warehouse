package com.llk.laborsystem.service.contractors;

import com.llk.laborsystem.bean.contractors.ProjectClass;

import java.util.List;

public interface ProjectClassService {
    List<ProjectClass> getProjectClassList();//查询全部项目类别
    ProjectClass getClsById(Integer cId);
}
