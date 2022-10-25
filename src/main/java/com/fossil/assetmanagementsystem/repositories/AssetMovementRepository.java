package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.AssetMovement;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import com.fossil.assetmanagementsystem.projections.AssetMovementView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AssetMovementRepository extends JpaRepository<AssetMovement, Integer> {


    @Query("SELECT am.id as id,am.createdAt as createdAt,am.createdBy as createdBy," +
            "am.updatedAt as updatedAt,am.assetId as assetId,am.locationId as locationId," +
            "am.notes as notes,am.status as status,am.userId as userId," +
            "value as value,am.sourceId as sourceId,am.destinationId as destinationId,am.dateOfMovement as dateOfMovement," +
            "am.depreciationValue as depreciationValue FROM AssetMovement am")
    List<AssetMovementView> findAllAssetMovements();

    List<AssetMovementView> findAllByStatus(StatusEnum status);


    @Query("SELECT am.id as id,am.createdAt as createdAt,am.createdBy as createdBy," +
            "am.updatedAt as updatedAt,am.assetId as assetId,am.locationId as locationId," +
            "am.notes as notes,am.status as status,am.userId as userId," +
            "am.value as value,am.sourceId as sourceId,am.destinationId as destination,am.dateOfMovement as dateOfMovement," +
            "am.depreciationValue as depreciationValue FROM AssetMovement am WHERE DATE(am.dateOfMovement) = DATE(:dateOfMovement)")
    List<AssetMovementView> findAllByDateOfMovement(LocalDate dateOfMovement);
}

