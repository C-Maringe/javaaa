package com.fossil.assetmanagementsystem.projections;

import com.fossil.assetmanagementsystem.enums.DepreciationEnum;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AssetView {
    Integer getId();
    String getAssetName();
    String getDescription();
    Integer getSerialNumber();
    String getSupplierName();
    Double getValue();
    DepreciationEnum getDepreciationMethod();
    Double getDepreciationRate();
    Integer getLocationId();
    String getBarcode();
    Integer getUserId();
    LocalDate getDateOfPurchase();
    String getCreatedBy();
    Instant getCreatedAt();
    Instant getUpdatedAt();
}
