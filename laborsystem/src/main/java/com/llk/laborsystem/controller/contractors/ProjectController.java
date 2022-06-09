package com.llk.laborsystem.controller.contractors;

import com.alibaba.excel.EasyExcel;
import com.llk.laborsystem.bean.contractors.Department;
import com.llk.laborsystem.bean.contractors.Project;
import com.llk.laborsystem.bean.contractors.ProjectClass;
import com.llk.laborsystem.service.contractors.ProjectClassService;
import com.llk.laborsystem.service.contractors.ProjectService;
import com.llk.laborsystem.utils.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description: 操作项目接口控制器
 * @Author: 李乐康
 * @Date: 2022-04-10 10:33
 */

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectClassService projectClassService;

    @Autowired
    private ProjectService projectService;

    //多条件查询+分页
    @RequestMapping("/getProgectList")
    @ResponseBody
    public Pager<Project> getProgectList(Project project){
        System.out.println(project.toString());
        Pager<Project> pager = projectService.getProjectList(project);
        List<Project> list = pager.getList();
        for (Project project1 : list) {
            project1.setProjectClass(projectClassService.getClsById(project1.getClsId()));

        }
        return pager;
    }

    //查询单个项目
    @RequestMapping("/getProjectById")
    @ResponseBody
    public Project getProjectById(Project project){
        return projectService.getProjectById(project);
    }

    //添加项目
    @RequestMapping("/addxm")
    @ResponseBody
    public Boolean addProject(Project project){
        return  projectService.addProject(project);
    }

    //修改项目
    @RequestMapping("/editPoject")
    @ResponseBody
    public Boolean editPoject(@RequestBody Project project){
        System.out.println(project);
        return  projectService.editProject(project);
    }
    //导出excel表
    @RequestMapping("/writeExcel")
    @ResponseBody
    public void writeExcel(){
        String fileName="/Users/lilekang/Downloads/中铁十六局集团全部项目.xlsx";
        EasyExcel.write(fileName,Project.class).sheet("模板").doWrite(getEmpData());

    }

    //查询全部数据返回一个集合

    private List<Project> getEmpData() {
        List<Project> excelEmpDataList = new ArrayList<>();
        List<Project> projects = projectService.projectAll();

        Project data = null;
        for (Project project : projects) {
            excelEmpDataList.add(project);
        }
        return excelEmpDataList;
    }

    //查询单个类别
    @RequestMapping("/projectClassList")
    @ResponseBody
    public List<ProjectClass> projectClassList(){

        return projectClassService.getProjectClassList();
    }

    //删除(把状态设置成0,隐藏掉)
    @RequestMapping("/delPro")
    @ResponseBody
    public Boolean delPro(Project project){

        return projectService.delProject(project);
    }

    //查询全部部门
    @RequestMapping("/depList")
    @ResponseBody
    public List<Department> depList(){
        List<Department> departments = projectService.depList();


        return projectService.depList();
    }
}
