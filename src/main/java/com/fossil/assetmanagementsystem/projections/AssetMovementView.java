package com.fossil.assetmanagementsystem.projections;

import com.fossil.assetmanagementsystem.enums.StatusEnum;

public interface AssetMovementView {
    Integer getId();
    Integer getAssetId();
    Integer getUserId();
    Integer getLocationId();
    StatusEnum getStatus();
    Double getValue();
    String getNotes();


}
