package com.fossil.assetmanagementsystem.dtos;

import com.fossil.assetmanagementsystem.enums.DepreciationEnum;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class AssetDto {
    private Integer id;
    private String createdBy;
    private String assetName;
    private String description;
    private Integer serialNumber;
    private String supplierName;
    private Double value;
    private DepreciationEnum depreciationMethod;
    private Double depreciationRate;
    private Double depreciationValue;
    private Integer locationId;
    private String barcode;
    private Integer userId;
    private LocalDate dateOfPurchase;
    private StatusEnum status;

}
