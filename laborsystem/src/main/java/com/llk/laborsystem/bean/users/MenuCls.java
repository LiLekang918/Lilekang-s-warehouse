package com.llk.laborsystem.bean.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCls {

    private Integer mId;
    private Integer pId;
    private String mName;
    private String path;
    private Boolean open=true;
    private Boolean checked=false;
    private List<MenuCls> children = new ArrayList<MenuCls>();
}
