package com.fossil.assetmanagementsystem.projections;

import com.fossil.assetmanagementsystem.enums.StatusEnum;

import java.time.Instant;

public interface AssetMovementView {
    Integer getId();
    Integer getAssetId();
    Integer getUserId();
    Integer getLocationId();
    StatusEnum getStatus();
    Double getValue();
    String getNotes();
    String getCreatedBy();
    Instant getCreatedAt();
    Instant getUpdatedAt();



}
