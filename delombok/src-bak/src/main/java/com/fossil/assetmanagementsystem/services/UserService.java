package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.UserDto;
import com.fossil.assetmanagementsystem.projections.UserView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends BaseService<UserDto,UserDto> {
    List<UserView> findAllUsers();
}
