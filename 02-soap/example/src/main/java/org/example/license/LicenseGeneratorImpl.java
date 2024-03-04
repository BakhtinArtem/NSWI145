package org.example.license;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@jakarta.jws.WebService(endpointInterface = "org.example.license.ILicenseGenerator")
public class LicenseGeneratorImpl implements ILicenseGenerator {

    @Override
    public License generateLicense(LicenseRequest licenseRequest) {
        return License.builder()
                .serialNumber(licenseRequest.getSerialNumber())
                .fromDate(licenseRequest.getFromDate())
                .toDate(licenseRequest.getToDate())
                .generated(LocalDateTime.now().toString())
                .licenseId(UUID.randomUUID().toString())
                .build();
    }
}
