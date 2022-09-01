package com.fossil.assetmanagementsystem.projections;

import com.fossil.assetmanagementsystem.enums.DepreciationEnum;

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
    String getDateOfPurchase();
}
