package com.fossil.assetmanagementsystem.dtos;

import com.fossil.assetmanagementsystem.enums.DepreciationEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Integer locationId;
    private String barcode;
    private Integer userId;
    private LocalDate dateOfPurchase;

}
