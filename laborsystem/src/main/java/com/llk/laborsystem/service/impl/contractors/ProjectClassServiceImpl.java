package com.llk.laborsystem.service.impl.contractors;

import com.llk.laborsystem.bean.contractors.ProjectClass;
import com.llk.laborsystem.mapper.contractors.ProjectClassMapper;
import com.llk.laborsystem.service.contractors.ProjectClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectClassServiceImpl implements ProjectClassService {

    @Resource
    private ProjectClassMapper projectClassMapper;
    @Override
    public List<ProjectClass> getProjectClassList() {
        return projectClassMapper.getProjectClassList();
    }

    @Override
    public ProjectClass getClsById(Integer cId) {
        return projectClassMapper.getClsById(cId);
    }
}
