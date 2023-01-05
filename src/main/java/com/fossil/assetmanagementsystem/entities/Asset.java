package com.fossil.assetmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fossil.assetmanagementsystem.enums.DepreciationEnum;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "asset")
public class Asset extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3431441698184406613L;


    @Column(name = "asset_name",nullable = false)
    private String assetName;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "serial_number",nullable = false)
    private Integer serialNumber;

    @Column(name = "supplier_name",nullable = false)
    private String supplierName;

    @Column(name = "value",nullable = false)
    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "depreciation_method",nullable = false)
    private DepreciationEnum depreciationMethod;

    @Column(name = "depreciation_rate",nullable = false)
    private Double depreciationRate;

    @Column(name="depreciation_value",nullable = false)
    private Double depreciationValue;

    @Column(name = "location_id",nullable = false)
    private Integer locationId;

    @Column(name = "barcode",nullable = false)
    private String barcode;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name="status",nullable = false)
    private StatusEnum status;



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_purchase",nullable = false)
    private LocalDate dateOfPurchase;
   /* @Basic
    @JsonFormat(pattern="yyyy-MM-dd",timezone = " GMT+8")
    @Column(name = "date_of_purchase",nullable = false)
    private LocalDateTime dateOfPurchase;*/






}
