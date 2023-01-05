package com.fossil.assetmanagementsystem.dtos;


import com.fossil.assetmanagementsystem.entities.User;
import lombok.Data;

@Data
public class LoginResponseDto {
    Integer status;
    String message;
    User user;
}
