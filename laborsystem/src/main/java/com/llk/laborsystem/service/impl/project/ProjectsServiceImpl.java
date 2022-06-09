package com.llk.laborsystem.service.impl.project;

import com.llk.laborsystem.bean.project.ConstructionUnit;
import com.llk.laborsystem.bean.project.GeneralContractor;
import com.llk.laborsystem.bean.project.ProjectType;
import com.llk.laborsystem.bean.project.Projects;
import com.llk.laborsystem.mapper.project.ProjectsMapper;
import com.llk.laborsystem.service.project.ProjectsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Resource
    private ProjectsMapper projectsMapper;

    @Override
    public List<Projects> getProjectList(Projects projects) {
        return projectsMapper.getProjectList(projects);
    }

    @Override
    public Projects getProjectById(Projects projects) {
        return projectsMapper.getProjectById(projects);
    }

    @Override
    public Boolean addProject(Projects projects) {

        return projectsMapper.addProject(projects);
    }

    @Override
    public Boolean delProject(Integer id) {
        return projectsMapper.delProject(id);
    }

    @Override
    public Boolean editProject(Projects projects) {
        return projectsMapper.editProject(projects);
    }

    @Override
    public Long total(Projects projects) {
        return projectsMapper.total(projects);
    }

    @Override
    public List<ProjectType> allTypes() {
        return projectsMapper.allTypes();
    }

    @Override
    public List<GeneralContractor> allGeneralContractor() {

        return projectsMapper.allGeneralContractor();
    }

    @Override
    public List<ConstructionUnit> allConstructionUnit() {

        return projectsMapper.allConstructionUnit();
    }
}
