package com.fossil.assetmanagementsystem.projections;

import java.time.Instant;

public interface LocationView {
    Integer getId();
    String getLocationName();
    String getCreatedBy();
    Instant getCreatedDate();
    Instant getUpdatedDate();

}
