package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.AssetDto;
import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.projections.AssetView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetService extends BaseService<AssetDto,AssetDto> {

    List<AssetView> findAllAssets();
}
