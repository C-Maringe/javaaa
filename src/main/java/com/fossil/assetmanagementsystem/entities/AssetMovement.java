package com.fossil.assetmanagementsystem.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "asset_movement")
public class AssetMovement extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3431441698184406613L;
    @Column(name = "asset_id",nullable = false)
    private Integer assetId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "location_id",nullable = false)
    private Integer locationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private StatusEnum status;

    @Column(name = "value",nullable = false)
    private Double value;

    @Column(name="notes",nullable = false)
    private String notes;



}
