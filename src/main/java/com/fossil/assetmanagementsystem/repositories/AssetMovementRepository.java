package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.AssetMovement;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import com.fossil.assetmanagementsystem.projections.AssetMovementView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetMovementRepository extends JpaRepository<AssetMovement, Integer> {


    @Query("SELECT am.id as id,am.createdAt as createdAt,am.createdBy as createdBy," +
            "am.updatedAt as updatedAt,am.assetId as assetId,am.locationId as locationId," +
            "am.notes as notes,am.status as status,am.userId as userId," +
            "am.value as value FROM AssetMovement am")
    List<AssetMovementView> findAllAssetMovements();

    List<AssetMovementView> findAllByStatus(StatusEnum status);
}
