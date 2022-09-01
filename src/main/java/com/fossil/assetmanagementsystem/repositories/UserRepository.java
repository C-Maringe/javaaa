package com.fossil.assetmanagementsystem.repositories;

import com.fossil.assetmanagementsystem.entities.User;
import com.fossil.assetmanagementsystem.projections.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.id as id FROM User u")
    List<UserView> findAllUsers();

}

