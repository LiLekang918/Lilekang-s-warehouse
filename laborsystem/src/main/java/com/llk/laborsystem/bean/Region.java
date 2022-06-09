package com.llk.laborsystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    private Integer id;//地区id
    private String name;//地区名称
    private Integer parentId;//父级id
}
