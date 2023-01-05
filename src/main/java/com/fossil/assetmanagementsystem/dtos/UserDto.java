package com.fossil.assetmanagementsystem.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String createdBy;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private String department;
    private Integer locationId;
}
