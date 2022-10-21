package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.Location;
import com.fossil.assetmanagementsystem.projections.LocationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {

    @Query("SELECT l.id as id,l.locationName as locationName,l.createdAt as createdAt,l.createdBy as createdBy," +
            "l.updatedAt as updatedAt FROM Location l")
    List<LocationView> findAllLocations();
}

