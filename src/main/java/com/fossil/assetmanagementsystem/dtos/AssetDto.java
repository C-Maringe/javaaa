package com.fossil.assetmanagementsystem.dtos;

import com.fossil.assetmanagementsystem.enums.DepreciationEnum;
import lombok.Data;

@Data
public class AssetDto {
    private Integer id;
    private String assetName;
    private String description;
    private Integer serialNumber;
    private String supplierName;
    private Double value;
    private DepreciationEnum depreciationMethod;
    private Double depreciationRate;
    private Integer locationId;
    private String barcode;
    private Integer userId;
    private String dateOfPurchase;

}
