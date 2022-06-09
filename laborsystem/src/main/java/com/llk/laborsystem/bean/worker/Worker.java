package com.llk.laborsystem.bean.worker;

import com.llk.laborsystem.bean.contractors.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 工人库实体类
 * @Author: 李乐康
 * @Date: 2022/4/25 09:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private Integer id;
    private String numberId;
    private String name;
    private String sex;
    private Integer age;
    private Integer eduId;
    private String birthDate;
    private String address;
    private String appearance;
    private String papersId;
    private String phone;
    private Integer hisState;
    private Integer wTId;
    private String photoPath;
    private String prPath;
    private Integer wSId;
    private String enterTime;
    private String exitTime;
    private String sosLianxiren;
    private String sosPhone;
    private Integer nationId;
    private Integer groupId;
    private Nation nation;
    private WorkerSeed workerSeed;
    private Education education;
    private WorkerGroup workerGroup;
    private Integer formal;
    private Integer currentPage;
    private Integer[] workerSeedAll=new Integer[0];
    private Integer[] educationAll=new Integer[0];
    private Integer[] proAll=new Integer[0];
    private Integer provinceId;//省
    private Integer cityId;//城市
    private Integer countyId;//县
    private Integer hide;
    private String dormitoryType;
    private String dormitoryNumber;
    private String bedNumber;
    private Project project;//全部项目
    private Integer pId;
    private Integer wId;
}
