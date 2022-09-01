package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.Location;
import com.fossil.assetmanagementsystem.projections.LocationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {

    @Query("SELECT l.id as id FROM Location l")
    List<LocationView> findAllLocations();
}
