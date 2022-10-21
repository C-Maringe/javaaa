package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LoginResponseDto login(String userName, String password);
}
