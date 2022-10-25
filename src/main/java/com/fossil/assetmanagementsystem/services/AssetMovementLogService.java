package com.fossil.assetmanagementsystem.services;

import com.fossil.assetmanagementsystem.dtos.AssetMovementDto;

import com.fossil.assetmanagementsystem.projections.AssetMovementLogsView;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetMovementLogService extends BaseService<AssetMovementDto,AssetMovementDto> {

    List<AssetMovementLogsView> findAllAssetMovementsLogs();
}
