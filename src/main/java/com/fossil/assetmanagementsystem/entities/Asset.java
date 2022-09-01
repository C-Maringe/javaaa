package com.fossil.assetmanagementsystem.entities;

import com.fossil.assetmanagementsystem.enums.DepreciationEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "location_id",nullable = false)
    private Integer locationId;

    @Column(name = "barcode",nullable = false)
    private String barcode;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "date_of_purchase",nullable = false)
    private String dateOfPurchase;






}
