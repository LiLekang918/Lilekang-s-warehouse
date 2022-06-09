package com.llk.laborsystem.service.worker;

import com.llk.laborsystem.bean.worker.*;
import com.llk.laborsystem.utils.pager.Pager;

import java.util.List;

/**
 * @Description: 工人库service层
 * @Author: 李乐康
 * @Date: 2022/4/25 10:30
 */
public interface WorkerService {
    //给工人添加参见单位
    Boolean addWorkerProject(Integer pId,Integer wId);

    //通过编号查询
    Worker getNumberById(String numberId);

    //全部工人类别
    List<WorkerType> workerTypeList();

    //通过id查询信息
    Worker getWorkById(Integer id);

    //全部学历
    List<Education> educationList();

    //全部民族
    List<Nation> nationList();

    //全部工种
    List<WorkerSeed> workSeedList();

    //查询全部组
    List<WorkerGroup> groupList();

    //通过id查询学历
    Education getEducationById(Integer noid);

    //通过id查询民族
    Nation getNationById(Integer nId);

    //通过id查询工种
    WorkerSeed getWorkSeedById(Integer id);

    //展示全部信息
    Pager<Worker> workerList(Worker worker);//Integer[] workerSeedAll,Integer[] educationAll,Integer state,Integer formal

    //通过id查询信息
    Worker getWorkerById(Worker worker);

    //总条数
    long total(Worker worker);

    //添加员工
    Boolean addWorker(Worker worker);

    //修改员工
    Boolean editWorked(Worker worker);

    //删除员工
    Boolean delWorker(Integer id);

    //查询当前员工做过的项目
    List<Worker> getProjectByWorkerId(Integer id);

}
