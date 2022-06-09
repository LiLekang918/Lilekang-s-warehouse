package com.llk.laborsystem.bean.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projects {
    private Integer id;//id
    private String number;//编号
    private String secretKey;//密钥
    private String appKey;
    private String appSecret;
    private String buildingName;//建筑名称
    private String projectAbbreviation;//项目简称
    private Integer provinceId;//省
    private Integer cityId;//市
    private Integer countyId;//县
    private String detailedAddress;//详情地址
    private String constructionUnit;//施工单位
    private String generalContractor;//总承包单位
    private String buildUnit;//建设单位
    private String creditCode;//统一社会信用代码
    private BigDecimal money;//合同金额
    private Long coveredArea;//建筑面积
    private String startData;//开工日期
    private String completeData;//完工日期
    private String licence;//施工许可证号
    private String contacts;//联系人
    private String phone;//联系电话
    private String email;//联系邮箱
    private String intro;//项目简介
    private String image;//项目图片
    private Integer isWork;//疫情是否工作
    private Integer emphasis;//是否重点
    private Integer isOpen;//是否为开放项目
    private Integer clsId;//类别id
    private String signingDate;//项目签订日期
    private Integer itemState;//项目状态
//    private String biddingNumber;//招标编号
//    private String zgName;//劳资专管员姓名
//    private String zgId;//劳资专管员身份证
//    private String constructionScale;//建设规模
//    private String projectManagement;//项目管理机构
    private String videoConference;//视频会议
    private String username;//管理员账号
    private String password;//管理员密码
    private String coordinate;//坐标
    private Integer currentPage;
}
