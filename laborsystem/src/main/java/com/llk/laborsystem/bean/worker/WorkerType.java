package com.llk.laborsystem.bean.worker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 员工类型
 * @Author:李乐康
 * @Date: 2022/4/28 11:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerType {

    private Integer noid;
    private String workerType;
}
