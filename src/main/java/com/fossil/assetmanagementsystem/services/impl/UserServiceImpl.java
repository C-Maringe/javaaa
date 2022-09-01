package com.fossil.assetmanagementsystem.services.impl;

import com.fossil.assetmanagementsystem.dtos.AssetDto;
import com.fossil.assetmanagementsystem.dtos.UserDto;
import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.entities.User;
import com.fossil.assetmanagementsystem.exceptions.InvalidParameterException;
import com.fossil.assetmanagementsystem.projections.UserView;
import com.fossil.assetmanagementsystem.repositories.LocationRepository;
import com.fossil.assetmanagementsystem.repositories.UserRepository;
import com.fossil.assetmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;


    @Override
    public UserDto findById(Integer id) {
        final var foundUser = userRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("User not found"));

        return buildUserDto(foundUser);
    }

    @Override
    public UserDto save(UserDto userDto) {
        //check if location exists
        final var foundLocation = locationRepository.findById(userDto.getLocationId());
                if (foundLocation == null) {
                    throw new EntityNotFoundException("Location not found");
                }


        final var User = buildUser(userDto);
        final var savedUser = userRepository.save(User);
        return buildUserDto(savedUser);
    }

    @Override
    public UserDto update(Integer id, UserDto userDto)
    {
        if (!Objects.equals(id, userDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User with provided id not found");
        }

        final var User = buildUser(userDto);

        final var savedUser = userRepository.save(User);
        return buildUserDto(savedUser);
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User with provided id not found");
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<UserView> findAllUsers() {
        return userRepository.findAllUsers();
    }

    User buildUser(UserDto userDto) {
        final var User = new User();
        BeanUtils.copyProperties(userDto, User);
        return User;

    }
    UserDto buildUserDto(User user) {
        final var UserDto = new UserDto();
        BeanUtils.copyProperties(user, UserDto);
        return UserDto;
    }
}
