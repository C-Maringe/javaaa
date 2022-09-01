package com.fossil.assetmanagementsystem.services.impl;

import com.fossil.assetmanagementsystem.dtos.AssetDto;
import com.fossil.assetmanagementsystem.dtos.LocationDto;
import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.entities.Location;
import com.fossil.assetmanagementsystem.exceptions.InvalidParameterException;
import com.fossil.assetmanagementsystem.projections.LocationView;
import com.fossil.assetmanagementsystem.repositories.LocationRepository;
import com.fossil.assetmanagementsystem.services.LocationService;
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
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    @Override
    public LocationDto findById(Integer id) {
        final var foundLocation= locationRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Location not found"));
        return buildLocationDto(foundLocation);
    }

    @Override
    public LocationDto save(LocationDto locationDto) {
        final var location = buildLocation(locationDto);
        final var savedLocation = locationRepository.save(location);
        return buildLocationDto(savedLocation);

    }

    @Override
    public LocationDto update(Integer id, LocationDto locationDto) {

        if (!Objects.equals(id, locationDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!locationRepository.existsById(id)) {
            throw new EntityNotFoundException("Location with provided id not found");
        }

        final var Location = buildLocation(locationDto);

        final var savedLocation = locationRepository.save(Location);
        return buildLocationDto(savedLocation);
    }

    @Override
    public Boolean deleteById(Integer id) {
        locationRepository.deleteById(id);
        return true;
    }

    @Override
    public List<LocationView> findAllLocations() {
        return locationRepository.findAllLocations();
    }
    Location buildLocation(LocationDto locationDto) {
        final var location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        return location;
    }
    LocationDto buildLocationDto(Location location) {
        final var locationDto = new LocationDto();
        BeanUtils.copyProperties(location, locationDto);
        return locationDto;
    }
}




