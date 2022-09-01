package com.fossil.assetmanagementsystem.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3431441698184406613L;

    @Column(name = "location_name",nullable = false)
    private String locationName;
}