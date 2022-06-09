package com.llk.laborsystem.bean.users;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Integer uId;
    private String uName;
    private String uPass;
    private Integer uGender;
    private String uEmail;
    private String uRealname;
}
