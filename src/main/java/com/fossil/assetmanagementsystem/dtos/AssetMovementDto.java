package com.fossil.assetmanagementsystem.dtos;

import com.fossil.assetmanagementsystem.enums.StatusEnum;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class AssetMovementDto {
    private Integer id;
    private Integer assetId;
    private Integer userId;
    private Integer locationId;
    private StatusEnum status;
    private Double value;
    private String notes;


}
