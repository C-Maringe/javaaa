package com.fossil.assetmanagementsystem.projections;

import java.time.LocalDate;

public interface AssetMovementLogsView {
    Integer getId();
    String getCreatedBy();
    Integer getAssetId();
    Integer getUserId();
    Integer getLocationId();
    String getAssetName();
    String getUserName();
    String getLocationName();
    String getStatus();
    Double getValue();
    Double getDepreciationValue();
    Integer getSourceId();
    Integer getDestinationId();
    LocalDate getDateOfMovement();
    String getNotes();
}

