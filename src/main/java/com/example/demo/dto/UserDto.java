package com.example.demo.dto;

import javax.validation.constraints.Email;

//import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data; //get, set
//import javax.

@Data
public class UserDto {
    private long id;
//    private Date creatAt;
//    private Date updateAt;
  
    private String username;

    @NotNull(message = "Email Can Not Be Null")
    @Email(message = "Email Format Error")
    private String email;
    
    @NotNull(message = "Phone Can Not Be Null")
    private String phone;
    
    @NotNull(message = "Password Can Not Be Null")
    @Length(min = 6, max = 20, message = "Password Length Error")
    private String password;    
//    private Date updateAt;
}