package com.llk.laborsystem.service.impl.worker;

import com.llk.laborsystem.bean.contractors.Project;
import com.llk.laborsystem.bean.worker.*;
import com.llk.laborsystem.mapper.contractors.ProjectMapper;
import com.llk.laborsystem.mapper.worker.WorkerMapper;
import com.llk.laborsystem.service.worker.WorkerService;
import com.llk.laborsystem.utils.pager.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 工人库业务逻辑层
 * @Author:李乐康
 * @Date: 2022/4/25 10:32
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Resource
    private WorkerMapper workerMapper;

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Boolean addWorkerProject(Integer pId, Integer wId) {
        return workerMapper.addWorkerProject(pId,wId);
    }

    @Override
    public Worker getNumberById(String numberId) {
        return workerMapper.getNumberById(numberId);
    }

    @Override
    public List<WorkerType> workerTypeList() {
        return workerMapper.workerTypeList();
    }

    @Override
    public Worker getWorkById(Integer id) {
        return workerMapper.getWorkById(id);
    }

    @Override
    public List<Education> educationList() {
        return workerMapper.educationList();
    }

    @Override
    public List<Nation> nationList() {
        return workerMapper.nationList();
    }

    @Override
    public List<WorkerSeed> workSeedList() {
        return workerMapper.workSeedList();
    }

    @Override
    public List<WorkerGroup> groupList() {
        return workerMapper.groupList();
    }

    @Override
    public Education getEducationById(Integer noid) {
        return workerMapper.getEducationById(noid);
    }

    @Override
    public Nation getNationById(Integer nId) {
        return workerMapper.getNationById(nId);
    }

    @Override
    public WorkerSeed getWorkSeedById(Integer id) {
        return workerMapper.getWorkSeedById(id);
    }

    @Override
    public Pager<Worker> workerList(Worker worker) {
        if(worker.getCurrentPage()==null||worker.getCurrentPage()<=0){
            worker.setCurrentPage(1);
        }
        Pager<Worker> pager=new Pager<>();
        pager.setCurrentPage(worker.getCurrentPage());
        worker.setCurrentPage((worker.getCurrentPage()-1)*12);
        pager.setList(workerMapper.workerList(worker));
        pager.setPageSize(12);
        pager.setTotal(total(worker));
        List<Worker> list = pager.getList();
        //查询所以工人当前的种族
        for (Worker w : list) {
            Nation nation = workerMapper.getNationById(w.getNationId());
            w.setNation(nation);
        }
        for (Worker w2 : list) {
            w2.setWorkerSeed(workerMapper.getWorkSeedById(w2.getWSId()));
        }
        for (Worker w3 : list) {
            w3.setEducation(workerMapper.getEducationById(w3.getEduId()));
        }
        return pager;
    }

    @Override
    public Worker getWorkerById(Worker worker) {
        Worker workerById = workerMapper.getWorkerById(worker);
        workerById.setNation(workerMapper.getNationById(workerById.getNationId()));
        workerById.setWorkerSeed(workerMapper.getWorkSeedById(workerById.getWSId()));
        workerById.setEducation(workerMapper.getEducationById(workerById.getEduId()));
        List<WorkerGroup> workerGroups = workerMapper.groupList();
        for (WorkerGroup workerGroup : workerGroups) {
            if (workerById.getGroupId()==workerGroup.getId()){
                workerById.setWorkerGroup(workerGroup);
                break;
            }
        }
        return workerById;
    }

    @Override
    public long total(Worker worker) {
        return workerMapper.total(worker);
    }

    @Override
    public Boolean addWorker(Worker worker) {
        if (worker.getDormitoryType()==null||worker.getDormitoryType()==""){
            worker.setDormitoryType(" ");
        }
        if (worker.getDormitoryNumber()==null||worker.getDormitoryNumber()==""){
            worker.setDormitoryNumber(" ");
        }
        if (worker.getBedNumber()==null||worker.getBedNumber()==""){
            worker.setBedNumber(" ");
        }
        return workerMapper.addWorker(worker);
    }

    @Override
    public Boolean editWorked(Worker worker) {
        return workerMapper.editWorked(worker);
    }

    @Override
    public Boolean delWorker(Integer id) {
        return workerMapper.delWorker(id);
    }

    @Override
    public List<Worker> getProjectByWorkerId(Integer id) {
        List<Worker> projectByWorkerId = workerMapper.getProjectByWorkerId(id);
        List<Project> constructionUnitList = projectMapper.getConstructionUnitList();
        for (Worker worker : projectByWorkerId) {
            for (Project project : constructionUnitList) {
                if (worker.getPId()==project.getId()){
                    worker.setProject(project);
                    break;
                }
            }
        }
        return projectByWorkerId;
    }
}
