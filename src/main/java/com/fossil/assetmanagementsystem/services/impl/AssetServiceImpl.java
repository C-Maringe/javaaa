package com.fossil.assetmanagementsystem.services.impl;


import com.fossil.assetmanagementsystem.dtos.AssetDto;
import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.exceptions.InvalidParameterException;
import com.fossil.assetmanagementsystem.projections.AssetView;
import com.fossil.assetmanagementsystem.repositories.AssetRepository;
import com.fossil.assetmanagementsystem.repositories.LocationRepository;
import com.fossil.assetmanagementsystem.services.AssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    private final LocationRepository locationRepository;

    @Override
    public List<AssetView> findAllAssets() {
        return assetRepository.findAllAssets();
    }

    @Override
    public List<AssetView> findByDateOfPurchase(LocalDate dateOfPurchase) {
        return assetRepository.findByDateOfPurchase(dateOfPurchase);
    }


    @Override
    public AssetDto findById(Integer id) {
        final var foundAsset= assetRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Asset not found"));
        return buildAssetDto(foundAsset);
    }

    @Override
    public AssetDto save(AssetDto assetDto) {

        //check if location exists
        final var foundLocation = locationRepository.findById(assetDto.getLocationId());
        if (foundLocation == null) {
            throw new EntityNotFoundException("Location not found");
        }
        final var asset = buildAsset(assetDto);
        final var savedAsset = assetRepository.save(asset);
        return buildAssetDto(savedAsset);
    }

    @Override
    public AssetDto update(Integer id, AssetDto assetDto) {
        if(!Objects.equals(id,assetDto.getId())){
            throw new InvalidParameterException("invalid details");
        }
        if(!assetRepository.existsById(id)){
            throw new EntityNotFoundException("Allocation with id provided not found");
        }
        final var Allocation=buildAsset(assetDto);
        final var saveAsset=assetRepository.save(Allocation);
        return buildAssetDto(saveAsset);
    }

    @Override
    public Boolean deleteById(Integer id) {
        assetRepository.deleteById(id);
        return true;
    }
    Asset buildAsset(AssetDto assetDto) {
        Asset asset = new Asset();
        BeanUtils.copyProperties(assetDto, asset);
        return asset;
    }
    AssetDto buildAssetDto(Asset asset) {
        AssetDto assetDto = new AssetDto();
        BeanUtils.copyProperties(asset, assetDto);
        return assetDto;
    }
}
