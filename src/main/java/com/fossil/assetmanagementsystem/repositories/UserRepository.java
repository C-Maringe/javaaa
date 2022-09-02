package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.User;
import com.fossil.assetmanagementsystem.projections.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.id as id,u.createdAt as createdAt,u.createdBy as createdBy," +
            "u.updatedAt as updatedAt,u.department as department,u.email as email," +
            "u.firstName as firstName,u.jobTitle as jobTitle,u.lastName as lastName," +
            "u.locationId as locationId,u.phoneNumber as phoneNumber,u.userName as userName FROM User u")
    List<UserView> findAllUsers();

}

