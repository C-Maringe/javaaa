package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.projections.AssetView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

    @Query("SELECT a.id as id,a.createdAt as createdAt,a.createdBy as createdBy," +
            "a.updatedAt as updatedAt,a.assetName as assetName,a.barcode as barcode," +
            "a.dateOfPurchase as dateOfPurchase,a.depreciationMethod as depreciationMethod," +
            "a.depreciationRate as depreciationRate,a.description as description," +
            "a.locationId as locationId,a.serialNumber as serialNumber,a.supplierName as supplierName," +
            "a.userId as userId,a.value as value  FROM Asset a")
    List<AssetView> findAllAssets();


    @Query("SELECT a.id as id,a.createdAt as createdAt,a.createdBy as createdBy," +
            "a.updatedAt as updatedAt,a.assetName as assetName,a.barcode as barcode,"+
            "a.dateOfPurchase as dateOfPurchase,a.depreciationMethod as depreciationMethod," +
            "a.depreciationRate as depreciationRate,a.description as description," +
            "a.locationId as locationId,a.serialNumber as serialNumber,a.supplierName as supplierName," +
            "a.userId as userId,a.value FROM Asset a WHERE DATE(a.dateOfPurchase) = DATE(:dateOfPurchase) ")
    List<AssetView> findByDateOfPurchase(LocalDate dateOfPurchase);
}