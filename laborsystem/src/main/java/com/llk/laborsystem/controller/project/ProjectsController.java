package com.llk.laborsystem.controller.project;

import com.llk.laborsystem.bean.project.Projects;
import com.llk.laborsystem.service.project.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @RequestMapping("/getProjectList")
    @ResponseBody
    public List<Projects> getProjectList(Projects projects) {
        return projectsService.getProjectList(projects);
    }

    @RequestMapping("/getProjectById")
    @ResponseBody
    Projects getProjectById(Projects projects){

        return projectsService.getProjectById(projects);
    }

    @RequestMapping("/addProject")
    @ResponseBody
    public Boolean addProject(MultipartFile file,Projects projects) throws IOException {
        System.out.println(projects.toString());
//        BigDecimal b=new BigDecimal(111.0);
        //判断文件是否为空
        if (file!=null){
            //不是空就开始编辑
            String name = file.getOriginalFilename();//文件名
            String type = name.substring(name.lastIndexOf("."));
            String fileNmae = UUID.randomUUID().toString().replace("-", "") + type;
            //判断路径
            File filePath=new File("/Volumes/MacintoshSD/demo/projectPhoto");
            if(!filePath.exists()){
                //如果没有该路径就生成
               filePath.mkdirs();
            }
            //写入磁盘
            file.transferTo(new File(filePath+"/"+fileNmae));
            //设置数据库路径
            projects.setImage(fileNmae);
            //执行数据库添加
            return projectsService.addProject(projects);
        }
        //图片为空返回false
        return false;
    }

    @RequestMapping("/delProject")
    @ResponseBody
    public Boolean delProject(Integer id) {
        return projectsService.delProject(id);
    }

    @RequestMapping("/editProject")
    @ResponseBody
    public Boolean editProject(Projects projects) {
        return projectsService.editProject(projects);
    }

    //全部项目类型
    @RequestMapping("/allTypes")
    @ResponseBody
    public List allTypes(){
        return projectsService.allTypes();
    }


    //全部总承包单位
    @RequestMapping("/allGeneralContractor")
    @ResponseBody
    public List allGeneralContractor(){
        return projectsService.allGeneralContractor();
    }

    //全部施工单位
    @RequestMapping("/allConstructionUnit")
    @ResponseBody
    public List allConstructionUnit(){
        return projectsService.allConstructionUnit();
    }

}
