package org.example.license;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.Builder
public class License {
    private long serialNumber;
//    private LocalDate fromDate;
//    private LocalDate toDate;
//    private LocalDateTime generated;
    private String generated;
    private String fromDate;
    private String toDate;
    private String licenseId;
}
