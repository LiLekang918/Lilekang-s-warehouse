package com.llk.laborsystem.service.contractors;

import com.llk.laborsystem.bean.contractors.Department;
import com.llk.laborsystem.bean.contractors.Project;
import com.llk.laborsystem.utils.pager.Pager;

import java.util.List;

public interface ProjectService {


    //无条件查询全部项目
    List<Project> getConstructionUnitList();

    //查询全部数据+分页+多条件
    public Pager<Project> getProjectList(Project project);

    //查询全部数据
    public List<Project> projectAll();

    //通过id查询数据
    public Project getProjectById(Project project);

    //总共条数
    public long total(Integer[] clsAll,String name,String creditCode,String address);

    //添加数据

    Boolean addProject(Project project);

    //删除数据
    Boolean delProject(Project project);

    //修改数据
    Boolean editProject(Project project);

    //查询全部部门
    public List<Department> depList();

}
