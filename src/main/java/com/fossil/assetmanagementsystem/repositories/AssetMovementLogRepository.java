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


 @Query(value="select " +
         "asset_movement_logs.user_id as userId," +
         "       u.first_name as firstName," +
         "       u.last_name as surname," +
         "       asset_movement_logs.id as id," +
         "       asset_movement_logs.date_of_movement as dateM," +
         "       asset_movement_logs.status as status," +
         "       asset_movement_logs.notes as notes," +
         "       asset_movement_logs.value as value," +
         "       a.asset_name as assetName," +
         "       l.location_name as sourceLocation," +
         "       ll.location_name as destinationLocation " +
         "       from asset_movement_logs" +
         "            left join user u on asset_movement_logs.user_id = u.id" +
         "            left join asset a on asset_movement_logs.asset_id = a.id" +
         "            left join location l on asset_movement_logs.source_id = l.id" +
         "            left join location ll on asset_movement_logs.destination_id = ll.id", nativeQuery = true)
    List<AssetMovementLogsView> findAssetMovementLogs();









}
