package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.AssetMovementDto;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import com.fossil.assetmanagementsystem.projections.AssetMovementView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetMovementService extends BaseService<AssetMovementDto,AssetMovementDto> {

    List<AssetMovementView> findAllAssetMovements();

    List<AssetMovementView> findAllByStatus(StatusEnum status);
}
