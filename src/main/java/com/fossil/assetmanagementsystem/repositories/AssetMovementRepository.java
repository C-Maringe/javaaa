package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.AssetMovement;
import com.fossil.assetmanagementsystem.projections.AssetMovementView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetMovementRepository extends JpaRepository<AssetMovement, Integer> {


    @Query("SELECT am.id as id FROM AssetMovement am")
    List<AssetMovementView> findAllAssetMovements();
}
