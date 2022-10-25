package com.fossil.assetmanagementsystem.dtos;

import com.fossil.assetmanagementsystem.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssetMovementDto {
    private Integer id;
    private String createdBy;
    private Integer assetId;
    private Integer userId;
    private Integer locationId;
    private StatusEnum status;
    private Double value;
    private Double depreciationValue;
    private Integer sourceId;
    private Integer destinationId;
    private LocalDate dateOfMovement;
    private String notes;


}
