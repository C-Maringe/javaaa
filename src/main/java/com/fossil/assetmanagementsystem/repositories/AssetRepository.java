package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.projections.AssetView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

    @Query("SELECT a.id as id FROM Asset a")
    List<AssetView> findAllAssets();
}