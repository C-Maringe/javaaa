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

    private final AuthService authService;
    private final UserService userService;
    private final ResponseBuild<UserDto> userResponseBuild;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateUser(@RequestBody LoginTo loginTo) {
        return ResponseEntity.ok(authService.login(loginTo.getFullName(), loginTo.getPassword()));
    }
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userResponseBuild.responseFunction
                .apply(userService.save(userDto)), HttpStatus.OK);

    }


}
