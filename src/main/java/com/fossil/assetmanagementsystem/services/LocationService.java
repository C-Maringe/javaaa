package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.LocationDto;
import com.fossil.assetmanagementsystem.entities.Location;
import com.fossil.assetmanagementsystem.projections.LocationView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService extends BaseService<LocationDto, LocationDto> {
    List<LocationView> findAllLocations();
}

