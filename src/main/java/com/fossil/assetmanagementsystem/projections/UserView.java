package com.fossil.assetmanagementsystem.projections;

import java.time.Instant;

public interface UserView {

    Integer getId();

    String getUserName();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhoneNumber();

    String getJobTitle();

    String getDepartment();

    Integer getLocationId();

    String getCreatedBy();

    Instant getCreatedAt();

    Instant getUpdatedAt();
}



