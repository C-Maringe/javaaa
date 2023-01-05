package com.fossil.assetmanagementsystem.projections;

import com.fossil.assetmanagementsystem.entities.Location;
import com.fossil.assetmanagementsystem.enums.StatusEnum;

import java.time.Instant;
import java.time.LocalDate;

public interface AssetMovementView {
    Integer getId();
    Integer getAssetId();
    Integer getUserId();
    Integer getLocationId();
    StatusEnum getStatus();
    Double getValue();
    Double getDepreciationValue();
    Integer getSourceId();
    Integer getDestinationId();
    LocalDate getDateOfMovement();
    String getNotes();
    String getCreatedBy();
    Instant getCreatedAt();
    Instant getUpdatedAt();




}
