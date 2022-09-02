package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.AssetDto;
import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.projections.AssetView;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface AssetService extends BaseService<AssetDto,AssetDto> {

    List<AssetView> findAllAssets();

    List<AssetView> findByDateOfPurchase(LocalDate dateOfPurchase);
}
