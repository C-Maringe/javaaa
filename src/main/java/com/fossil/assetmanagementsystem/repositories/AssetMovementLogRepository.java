package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.AssetMovement;
import com.fossil.assetmanagementsystem.entities.AssetMovementLogs;
import com.fossil.assetmanagementsystem.projections.AssetMovementLogsView;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetMovementLogRepository extends JpaRepository<AssetMovementLogs,Integer> {


    /*@Query(value="Select asset_movement_logs.user_id as userId,u.first_name as firstName, asset_movement_logs.value, " +
            "asset_movement_logs.date_of_movement," +
            "asset_movement_logs.status," +
             "a.asset_name as assetName," +
            "l.location_name as source," +
            "ll.location_name as destination " +
            "from asset_movement_logs inner join user u on asset_movement_logs.user_id = u.id inner join asset a on asset_movement_logs.asset_id = a.id " +
            "inner join location l on asset_movement_logs.source_id = l.id join location ll on asset_movement_logs.destination_id= ll.id", nativeQuery = true)
            List<AssetMovementLogsView> findAssetMovementLogs();*/

   /* @Query(value = "SELECT * FROM asset_movement_logs aml,location l WHERE aml.asset_id = :assetId"+
            "AND aml.location_id=location.id ",nativeQuery = true)
    public List<AssetMovementLogs> findAssetMovementLogs(Integer assetId);*/

    /*@Query(value = "SELECT aml.userId as userId,u.firstName as firstName," +
            "a.assetName as assetName  FROM asset_movement_logs aml,location l,user u,asset a WHERE aml.asset_id = asset.id"+
            " AND aml.location_id=location.id AND aml.user_id=user.id ",nativeQuery = true)
    List<AssetMovementLogsView> findAssetMovementLogs();*/


    @Query(value="SELECT aml.id as id,aml.createdAt as createdAt,aml.createdBy as createdBy,aml.updatedAt as updatedAt," +
            "aml.assetId as assetId,aml.locationId as locationId,aml.notes as notes,aml.status as status,aml.userId as userId," +
            "aml.value as value,aml.sourceId as sourceId,aml.destinationId as destinationId,aml.dateOfMovement as dateOfMovement," +
            "aml.depreciationValue as depreciationValue FROM AssetMovementLogs aml")
    List<AssetMovementLogsView> findAssetMovementLogs();




}
