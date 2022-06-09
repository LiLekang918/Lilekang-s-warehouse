package com.llk.laborsystem.service.impl.contractors;

import com.llk.laborsystem.bean.contractors.Department;
import com.llk.laborsystem.bean.contractors.Project;
import com.llk.laborsystem.mapper.contractors.ProjectMapper;
import com.llk.laborsystem.service.contractors.ProjectService;
import com.llk.laborsystem.utils.pager.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getConstructionUnitList() {
        return projectMapper.getConstructionUnitList();
    }

    @Override
    public Pager<Project> getProjectList(Project project) {
        if(project.getCurrentPage()==null||project.getCurrentPage()<=0){
            project.setCurrentPage(1);
        }
        Pager<Project> pager=new Pager<>();
        pager.setCurrentPage(project.getCurrentPage());//project.getClsAll()
        pager.setList(projectMapper.getProjectList(project.getClsAll(),project.getName(),project.getCreditCode(),project.getAddress(),(project.getCurrentPage()-1)*9));
        pager.setPageSize(9);
        pager.setTotal(total(project.getClsAll(),project.getName(),project.getCreditCode(),project.getAddress()));
        return pager;
    }

    @Override
    public List<Project> projectAll() {
        return projectMapper.projectAll();
    }

    @Override
    public Project getProjectById(Project project) {
        return projectMapper.getProjectById(project);
    }

    @Override
    public long total(Integer[] clsAll, String name, String creditCode, String address) {
        return projectMapper.total(clsAll,name,creditCode,address);
    }

    @Override
    public Boolean addProject(Project project) {
        BigDecimal lastTax = new BigDecimal("10000");

        // 乘法
        BigDecimal multiply = project.getMoney().multiply(lastTax);
        project.setMoney(multiply);
       return projectMapper.addProject(project);
    }

    @Override
    public Boolean delProject(Project project) {
       return projectMapper.delProject(project);
    }

    @Override
    public Boolean editProject(Project project) {
       return projectMapper.editProject(project);
    }

    @Override
    public List<Department> depList() {
        return projectMapper.depList();
    }
}
