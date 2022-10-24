package com.fossil.assetmanagementsystem.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "asset_movement_logs")
public class AssetMovementLogs extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 9092154693445912972L;

    @Column(name = "asset_id")
    private Integer assetId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "location_id")
    private Integer locationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "value")
    private Double value;

    @Column(name = "depreciation_value")
    private Double depreciationValue;

    @Column(name="notes")
    private String notes;

    @Column(name="source")
    private String source;

    @Column(name="destination")
    private String destination;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_movement")
    private LocalDate dateOfMovement;
}
