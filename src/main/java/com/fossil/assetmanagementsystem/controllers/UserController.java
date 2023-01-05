package com.fossil.assetmanagementsystem.controllers;

import com.fossil.assetmanagementsystem.dtos.LoginResponseDto;
import com.fossil.assetmanagementsystem.dtos.LoginTo;
import com.fossil.assetmanagementsystem.dtos.UserDto;
import com.fossil.assetmanagementsystem.projections.UserView;
import com.fossil.assetmanagementsystem.services.AuthService;
import com.fossil.assetmanagementsystem.services.UserService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private final UserService userService;

    private final AuthService authService;

    private final ResponseBuild<UserDto> userResponseBuild;
    private final ResponseBuild<UserDto> userDtoResponseBuild;

    private final ResponseBuild<UserView> userViewResponseBuild;

    private final ResponseBuild<Boolean> userDeleteResponseBuild;

    @GetMapping("/")
    public ResponseEntity<Response> findAllUsers(){
        return new ResponseEntity<>(userViewResponseBuild.listResponseFunction.
                apply(userService.findAllUsers()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getSingleUser(@PathVariable Integer id){
        return new ResponseEntity<>(userDtoResponseBuild.responseFunction.
                apply(userService.findById(id)), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable("id") Integer id,@RequestBody UserDto userDto){
        return new ResponseEntity<>(userDtoResponseBuild.responseFunction.
                apply(userService.update(id,userDto)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userDeleteResponseBuild.responseFunction.
                apply(userService.deleteById(id)), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateUser(@RequestBody LoginTo loginTo) {
        return ResponseEntity.ok(authService.login(loginTo.getUserName(), loginTo.getPassword()));
    }
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userResponseBuild.responseFunction
                .apply(userService.save(userDto)), HttpStatus.OK);
    }
}
