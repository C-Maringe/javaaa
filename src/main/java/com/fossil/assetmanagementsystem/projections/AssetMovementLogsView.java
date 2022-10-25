package com.fossil.assetmanagementsystem.projections;

import java.time.LocalDate;

public interface AssetMovementLogsView {
    Integer getId();
    String getAssetName();
    String getDestinationLocation();
    String getSourceLocation();
    String getStatus();
    Double getValue();
    LocalDate getDateM();
    String getSurname();
    String getFirstName();
    String getNotes();

}

