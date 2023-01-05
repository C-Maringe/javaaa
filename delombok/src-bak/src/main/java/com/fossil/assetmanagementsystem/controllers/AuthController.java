package com.fossil.assetmanagementsystem.controllers;


import com.fossil.assetmanagementsystem.dtos.LoginResponseDto;
import com.fossil.assetmanagementsystem.dtos.LoginTo;
import com.fossil.assetmanagementsystem.dtos.UserDto;
import com.fossil.assetmanagementsystem.services.AuthService;
import com.fossil.assetmanagementsystem.services.UserService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Repository
@CrossOrigin
public class AuthController {

    @Autowired
    private final AuthService authService;
    private final UserService userService;
    private final ResponseBuild<UserDto> userResponseBuild;




}
