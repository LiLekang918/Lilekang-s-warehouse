package com.llk.laborsystem.controller.worker;

import com.llk.laborsystem.bean.contractors.Project;
import com.llk.laborsystem.bean.worker.*;
import com.llk.laborsystem.service.contractors.ProjectService;
import com.llk.laborsystem.service.worker.WorkerService;
import com.llk.laborsystem.utils.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 工人库视图控制层
 * @Author: 李乐康
 * @Date: 2022/4/25 14:58
 */
@Controller
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private ProjectService projectService;

    //无条件查询全部
    @RequestMapping("/getConstructionUnitList")
    @ResponseBody
    public List<Project> getConstructionUnitList(){
        return projectService.getConstructionUnitList();
    }

    //多条件+分页
    @RequestMapping("/workerList")
    @ResponseBody
    public Pager<Worker> workerList(Worker worker){
        System.out.println(worker.toString());
        Pager<Worker> pager = workerService.workerList(worker);
        List<Worker> list = pager.getList();
        return pager;
    }

    //全部工种
    @RequestMapping("/workerSeedList")
    @ResponseBody
    List<WorkerSeed> workerSeedList(){
        return workerService.workSeedList();
    }

    //添加工人
    @RequestMapping("/addWorker")
    @ResponseBody
    Boolean addWorker(MultipartFile file,Worker worker) throws IOException {
        System.out.println(worker);
        if(file!=null){
            String name = file.getOriginalFilename();
            String type = name.substring(name.lastIndexOf("."));
            String fileName=UUID.randomUUID().toString().replace("-","")+type;
            File filePath=new File("/Volumes/MacintoshSD/demo/workerPhoto");
            if (!filePath.exists()){
                filePath.mkdirs();
            }
            //写入磁盘
            file.transferTo(new File(filePath +"/"+ fileName));
            //设置数据库路径
            worker.setPhotoPath(fileName);
            Boolean addWorker = workerService.addWorker(worker);//添加工人信息
            Worker numberById = workerService.getNumberById(worker.getNumberId());
            System.out.println(worker.getProAll().length+"............................................");
            if (worker.getProAll().length>0){
                Integer[] proAll = worker.getProAll();
                for (Integer integer : proAll) {
                    Boolean addWorkerProject = workerService.addWorkerProject(integer, numberById.getId());
                }
            }
            return addWorker;
        }else {
            return false;
        }
    }

    //查询单个工人信息
    @RequestMapping("/getWorkById")
    @ResponseBody
    public Worker getWorkById(Integer id){
        System.out.println(workerService.getWorkById(id).toString());
        return workerService.getWorkById(id);
    }

    //全部学历
    @RequestMapping("/educationList")
    @ResponseBody
    List<Education> educationList(){
        return workerService.educationList();
    }


    //全部种族
    @RequestMapping("/nationList")
    @ResponseBody
    List<Nation> nationList(){
        return workerService.nationList();
    }

    //全部分组
    @RequestMapping("/workerGroupList")
    @ResponseBody
    List<WorkerGroup> workerGroupList(){
        return workerService.groupList();
    }

    //全部工人类别
    @RequestMapping("/workerTypeList")
    @ResponseBody
    List<WorkerType> workerTypeList(){
        return workerService.workerTypeList();
    }

    //删除员工
    @RequestMapping("/delWorker")
    @ResponseBody
    public Boolean delWorker(Integer id){
        return workerService.delWorker(id);
    }

    //查询当前员工之前做的项目
    @RequestMapping("/getProjectByWorkerById")
    @ResponseBody
    public List<Worker> getProjectByWorkerById(Integer id){
        List<Worker> projectByWorkerId = workerService.getProjectByWorkerId(id);
        for (Worker worker : projectByWorkerId) {
            System.out.println("员工的项目:"+worker);
        }
        return projectByWorkerId;

    }


    //通过id查询当前工人信息(多表联查全部信息)
    @RequestMapping("/getWorkerById")
    @ResponseBody
    Worker getWorkerById(Worker worker){
        return workerService.getWorkerById(worker);
    }
}
