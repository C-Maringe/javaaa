package com.fossil.assetmanagementsystem.services.impl;


import com.fossil.assetmanagementsystem.dtos.AssetMovementDto;
import com.fossil.assetmanagementsystem.entities.AssetMovement;
import com.fossil.assetmanagementsystem.entities.AssetMovementLogs;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import com.fossil.assetmanagementsystem.exceptions.InvalidParameterException;
import com.fossil.assetmanagementsystem.projections.AssetMovementView;
import com.fossil.assetmanagementsystem.repositories.*;
import com.fossil.assetmanagementsystem.services.AssetMovementLogService;
import com.fossil.assetmanagementsystem.services.AssetMovementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetMovementServiceImpl implements AssetMovementService, AssetMovementLogService {

    private final AssetMovementRepository assetMovementRepository;

    private final AssetMovementLogRepository assetMovementLogRepository;

    private final AssetRepository assetRepository;

    private final LocationRepository locationRepository;

    private final UserRepository userRepository;

    @Override
    public List<AssetMovementView> findAllAssetMovements() {
      return  assetMovementRepository.findAllAssetMovements();
    }

    @Override
    public List<AssetMovementView> findAllByStatus(StatusEnum status) {
        return assetMovementRepository.findAllByStatus(status);
    }

    @Override
    public List<AssetMovementView> findAllByDateOfMovement(LocalDate dateOfMovement) {
        return assetMovementRepository.findAllByDateOfMovement(dateOfMovement);
    }


    @Override
    public AssetMovementDto findById(Integer id) {
        final var foundAssetMovement = assetMovementRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("AssetMovement not found"));
        return buildAssetMovementDto(foundAssetMovement);
    }

    @Override
    public AssetMovementDto save(AssetMovementDto assetMovementDto) {
        //check if location exists
        final var foundLocation = locationRepository.findById(assetMovementDto.getLocationId());
        if (foundLocation == null) {
            throw new EntityNotFoundException("Location not found");
        }
        //check if asset exists
        final var foundAsset = assetRepository.findById(assetMovementDto.getAssetId());
        if (foundAsset == null) {
            throw new EntityNotFoundException("Asset not found");
        }
        //check if user exists
        final var foundUser = userRepository.findById(assetMovementDto.getUserId());
        if (foundUser == null) {
            throw new EntityNotFoundException("User not found");
        }


        final var assetMovement = buildAssetMovement(assetMovementDto);
        final var savedAssetMovement = assetMovementRepository.save(assetMovement);

        //log trail for asset movement
        AssetMovementLogs assetMovementLogs=new AssetMovementLogs();
        assetMovementLogs.setId(assetMovementDto.getId());
        assetMovementLogs.setCreatedBy(assetMovementDto.getCreatedBy());
        assetMovementLogs.setAssetId(assetMovementDto.getAssetId());
        assetMovementLogs.setUserId(assetMovementDto.getUserId());
        assetMovementLogs.setLocationId(assetMovementDto.getLocationId());
        assetMovementLogs.setStatus(assetMovementDto.getStatus());
        assetMovementLogs.setValue(assetMovementDto.getValue());
        assetMovementLogs.setDepreciationValue(assetMovementDto.getDepreciationValue());
        assetMovementLogs.setSource(assetMovementDto.getSource());
        assetMovementLogs.setDestination(assetMovementDto.getDestination());
        assetMovementLogs.setDateOfMovement(assetMovementDto.getDateOfMovement());
        assetMovementLogs.setNotes(assetMovementDto.getNotes());
        assetMovementLogRepository.save(assetMovementLogs);

        return buildAssetMovementDto(savedAssetMovement);
    }

    @Override
    public AssetMovementDto update(Integer id, AssetMovementDto assetMovementDto) {
        if (!Objects.equals(id, assetMovementDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }
        if(!assetMovementRepository.existsById(id)){
            throw new EntityNotFoundException("AssetMovement with provided id not found");
        }
        final var assetMovement = buildAssetMovement(assetMovementDto);
        final var savedAssetMovement = assetMovementRepository.save(assetMovement);

        //Save record in asset_movement_logs

        AssetMovementLogs assetMovementLogs=new AssetMovementLogs();
        assetMovementLogs.setId(assetMovementDto.getId());
        assetMovementLogs.setCreatedBy(assetMovementDto.getCreatedBy());
        assetMovementLogs.setAssetId(assetMovementDto.getAssetId());
        assetMovementLogs.setUserId(assetMovementDto.getUserId());
        assetMovementLogs.setLocationId(assetMovementDto.getLocationId());
        assetMovementLogs.setStatus(assetMovementDto.getStatus());
        assetMovementLogs.setValue(assetMovementDto.getValue());
        assetMovementLogs.setDepreciationValue(assetMovementDto.getDepreciationValue());
        assetMovementLogs.setSource(assetMovementDto.getSource());
        assetMovementLogs.setDestination(assetMovementDto.getDestination());
        assetMovementLogs.setDateOfMovement(assetMovementDto.getDateOfMovement());
        assetMovementLogs.setNotes(assetMovementDto.getNotes());
        assetMovementLogRepository.save(assetMovementLogs);

        return buildAssetMovementDto(savedAssetMovement);

    }

    @Override
    public Boolean deleteById(Integer id) {

        if(!assetMovementRepository.existsById(id)){
            throw new EntityNotFoundException("AssetMovement with provided id not found");
        }

        //Log trail for delete
        AssetMovementDto assetMovementDto=new AssetMovementDto();
        AssetMovement assetMovement=new AssetMovement();
        AssetMovementLogs assetMovementLogs=new AssetMovementLogs();
        assetMovementLogs.setId(assetMovement.getId());
        assetMovementLogs.setCreatedBy(assetMovement.getCreatedBy());
        assetMovementLogs.setAssetId(assetMovementDto.getAssetId());
        assetMovementLogs.setUserId(assetMovementDto.getUserId());
        assetMovementLogs.setLocationId(assetMovementDto.getLocationId());
        assetMovementLogs.setStatus(StatusEnum.ASSET_DISPOSED);
        assetMovementLogs.setValue(assetMovementDto.getValue());
        assetMovementLogs.setDepreciationValue(assetMovementDto.getDepreciationValue());
        assetMovementLogs.setSource(assetMovementDto.getSource());
        assetMovementLogs.setDestination(assetMovementDto.getDestination());
        assetMovementLogs.setDateOfMovement(assetMovementDto.getDateOfMovement());
        assetMovementLogs.setNotes(assetMovementDto.getNotes());
        assetMovementLogRepository.save(assetMovementLogs);
        //Save record in asset_movement_logs
        assetMovementRepository.deleteById(id);
        return true;
    }
    AssetMovement buildAssetMovement(AssetMovementDto assetMovementDto){
        final var assetMovement=new AssetMovement();
        BeanUtils.copyProperties(assetMovementDto,assetMovement);
        return assetMovement;
    }
    AssetMovementDto buildAssetMovementDto(AssetMovement assetMovement){
        final var assetMovementDto=new AssetMovementDto();
        BeanUtils.copyProperties(assetMovement,assetMovementDto);
        return assetMovementDto;
    }
}

