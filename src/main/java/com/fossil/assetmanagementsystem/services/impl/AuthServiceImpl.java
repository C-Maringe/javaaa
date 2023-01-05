package com.fossil.assetmanagementsystem.services.impl;

import com.fossil.assetmanagementsystem.dtos.LoginResponseDto;
import com.fossil.assetmanagementsystem.entities.User;
import com.fossil.assetmanagementsystem.exceptions.InvalidLoginException;
import com.fossil.assetmanagementsystem.exceptions.UnexpectedErrorException;
import com.fossil.assetmanagementsystem.repositories.UserRepository;
import com.fossil.assetmanagementsystem.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepo;
    @Override
    public LoginResponseDto login(String userName, String password) {
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            throw new UnexpectedErrorException("Username or password is empty","username or password is empty");
        }
        User user = userRepo.findByUserName(userName);
        if(user == null){
            throw new InvalidLoginException("Invalid username or password","Invalid username or password");
        }
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setStatus(200);
        loginResponseDto.setMessage("login successful");
        loginResponseDto.setUser(user);
        return loginResponseDto;
    }
}