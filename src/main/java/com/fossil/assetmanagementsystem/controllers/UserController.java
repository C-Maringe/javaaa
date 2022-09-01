package com.fossil.assetmanagementsystem.controllers;

import com.fossil.assetmanagementsystem.dtos.UserDto;
import com.fossil.assetmanagementsystem.projections.UserView;
import com.fossil.assetmanagementsystem.services.UserService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

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
    @PostMapping("/save")
    public ResponseEntity<Response> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userDtoResponseBuild.responseFunction.
                apply(userService.save(userDto)), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable("id") Integer id,@RequestBody UserDto userDto){
        return new ResponseEntity<>(userDtoResponseBuild.responseFunction.
                apply(userService.update(id,userDto)), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userDeleteResponseBuild.responseFunction.
                apply(userService.deleteById(id)), HttpStatus.OK);
    }

}
