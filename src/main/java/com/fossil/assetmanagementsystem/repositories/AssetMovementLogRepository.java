package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.AssetMovementLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetMovementLogRepository extends JpaRepository<AssetMovementLogs,Integer> {

}
