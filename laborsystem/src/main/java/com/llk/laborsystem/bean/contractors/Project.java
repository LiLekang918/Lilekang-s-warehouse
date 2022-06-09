package com.llk.laborsystem.bean.contractors;


import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelIgnoreUnannotated
public class Project {
    private Integer id;
    @ExcelProperty(index = 0,value = "企业名称")
    public String name;//企业名称
    @ExcelProperty(index = 1,value = "营业执照")
    private String permission;//营业执照
    @ExcelProperty(index = 2,value = "信用代码")
    private String creditCode;//信用代码
    @ExcelProperty(index = 3,value = "企业简称")
    private String abbreviation;//企业简称
    @ExcelProperty(index = 4,value = "类型id")
    private Integer clsId;//类型id
    @ExcelProperty(index = 5,value = "法定人证件号")
    private String shenfenzheng;//法定人证件号
    @ExcelProperty(index = 6,value = "营业地址")
    private String address;//营业地址
    @ExcelProperty(index = 7,value = "注册资金")
    private BigDecimal money;//注册资金
    @ExcelProperty(index = 8,value = "注册日期")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String beginTime;//注册日期
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String endTime;//终止时间
    @ExcelProperty(index = 9,value = "省")
    private Integer provinceId;//省
    @ExcelProperty(index = 10,value = "市")
    private Integer cityId;//城市
    @ExcelProperty(index = 11,value = "县")
    private Integer countyId;//县
    @ExcelProperty(index = 12,value = "联系人")
    private String contact;//联系人
    @ExcelProperty(index = 13,value = "联系电话")
    private String phone;//联系电话
    @ExcelProperty(index = 14,value = "邮箱地址")
    private String eMail;//邮箱地址
    @ExcelProperty(index = 15,value = "网站网址")
    private String website;//网站网址
    @ExcelProperty(index = 16,value = "介绍")
    private String intro;//介绍
    private Integer depId;
    private Integer currentPage;
    private Integer[] clsAll=new Integer[0];
    private ProjectClass projectClass;
}
