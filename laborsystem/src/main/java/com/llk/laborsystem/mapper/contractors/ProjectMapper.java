package com.llk.laborsystem.mapper.contractors;

import com.llk.laborsystem.bean.contractors.Department;
import com.llk.laborsystem.bean.contractors.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectMapper {
    //无条件查询全部项目
    @Select("select * from t_project")
    List<Project> getConstructionUnitList();

    //查询全部部门
    @Select("select * from t_department")
    public List<Department> depList();

    //查询全部数据+分页+多条件
    public List<Project> getProjectList(@Param("clsAll")Integer[] clsAll,@Param("name")String name,@Param("creditCode")String creditCode,@Param("address")String address,@Param("currentPage")Integer currentPage);

    //查询全部数据
    @Select("select * from t_project")
    public List<Project> projectAll();

    //通过id查询数据
    @Select("select * from t_project where id=#{id}")
    public Project getProjectById(Project project);


    //总共条数
    public long total(@Param("clsAll")Integer[] clsAll,@Param("name")String name,@Param("creditCode")String creditCode,@Param("address")String address);

    //添加数据

    Boolean addProject(@Param("project")Project project);

    //删除数据
    @Update("UPDATE t_project SET state=0 WHERE id=#{id}")
    Boolean delProject(Project project);

    //修改数据
    @Update("UPDATE t_project SET name=#{name},permission=#{permission},credit_code=#{creditCode},abbreviation=#{abbreviation},cls_id=#{clsId},province_id=#{provinceId},city_id=#{cityId},county_id=#{countyId},dep_id=#{depId},shenfenzheng=#{shenfenzheng},address=#{address},money=#{money},contact=#{contact},phone=#{phone},e_mail=#{eMail},website=#{website},intro=#{intro} WHERE id=#{id}")
    Boolean editProject(Project project);

}
