package com.llk.laborsystem.mapper.worker;

import com.llk.laborsystem.bean.worker.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: 员工库的数据访问层
 * @Author: 李乐康
 * @Date: 2022/4/24 14:44
 */
@Mapper
public interface WorkerMapper {

    //通过编号查询
    @Select("SELECT * FROM t_worker WHERE number_id=#{numberId}")
    Worker getNumberById(String numberId);

    //给工人添加参见单位
    @Insert("INSERT INTO t_project_worker VALUES(0,#{pId},#{wId})")
    Boolean addWorkerProject(Integer pId,Integer wId);

    //全部工人类别
    @Select("SELECT * FROM t_worker_type")
    List<WorkerType> workerTypeList();

    //全部学历
    @Select("select * from t_education")
    List<Education> educationList();

    //全部民族
    @Select("select * from t_nation")
    List<Nation> nationList();

    //全部工种
    @Select("select * from t_worker_seed")
    List<WorkerSeed> workSeedList();

    //查询全部组
    @Select("SELECT * FROM t_team_group")
    List<WorkerGroup> groupList();

    //通过id查询学历
    @Select("select * from t_education where noid=#{noid}")
    Education getEducationById(Integer noid);

    //通过id查询民族
    @Select("select * from t_nation where n_id=#{nId}")
    Nation getNationById(Integer nId);

    //通过id查询工种
    @Select("select * from t_worker_seed where id=#{id}")
    WorkerSeed getWorkSeedById(Integer id);

    //展示全部信息
    List<Worker> workerList(@Param("worker")Worker worker);//Integer[] workerSeedAll,Integer[] educationAll,Integer state,Integer formal

    //通过id查询信息
    Worker getWorkerById(@Param("worker")Worker worker);

    //通过id查询信息
    @Select("SELECT * FROM t_worker WHERE id=#{id}")
    Worker getWorkById(Integer id);

    //总条数
    long total(@Param("worker") Worker worker);

    //添加员工
    @Insert("INSERT INTO t_worker VALUES(0,#{numberId},#{name},#{sex},#{age},#{eduId},#{birthDate},#{address},#{appearance},#{papersId},#{phone},#{hisState},#{wTId},#{photoPath},#{prPath},#{wSId},#{enterTime},#{exitTime},#{sosLianxiren},#{sosPhone},#{nationId},#{groupId},#{formal},#{provinceId},#{cityId},#{countyId},1,#{dormitoryType},#{dormitoryNumber},#{bedNumber})")
    Boolean addWorker(Worker worker);

    //修改员工
    @Update("UPDATE t_worker SET number_id=#{numberId},name=#{name},sex=#{sex},age=#{age},edu_id=#{eduId},birth_date=#{birthDate},address=#{address},appearance=#{appearance},papers_id=#{papersId},phone=#{phone},his_state=#{hisState},w_t_id=#{wTId},photo_path=#{photoPath},pr_path=#{prPath},w_s_id=#{wSId},enter_time=#{enterTime},exit_time=#{exitTime},sos_ contacts=#{sosContacts},sos_phone=#{sosPhone},nation_id=#{nationId},group_id=#{groupId},formal=#{formal},province_id=#{provinceId},city_id=#{cityId},county_id=#{countyId},hide=#{hide},dormitory_type=#{dormitoryType},dormitory_number=#{dormitoryNumber},bed_number=#{bedNumber} WHERE id=#{id}")
    Boolean editWorked(Worker worker);

    //删除员工
    @Update("UPDATE t_worker SET hide=2 WHERE id=#{id}")
    Boolean delWorker(Integer id);

    //查询当前员工做过的项目
    @Select("SELECT * FROM t_worker w JOIN t_project_worker pw JOIN t_project p WHERE w.id=pw.w_id AND p.id=pw.p_id AND w.id=#{id}")
    List<Worker> getProjectByWorkerId(Integer id);


}
