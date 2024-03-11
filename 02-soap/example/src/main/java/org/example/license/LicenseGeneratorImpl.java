package org.example.license;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

@jakarta.jws.WebService(endpointInterface = "org.example.license.ILicenseGenerator")
public class LicenseGeneratorImpl implements ILicenseGenerator {

    private HashSet<License> licenses = new HashSet<>();

    @Override
    public License generateLicense(LicenseRequest licenseRequest) {
        final var license = License.builder()
                .serialNumber(licenseRequest.getSerialNumber())
                .fromDate(licenseRequest.getFromDate())
                .toDate(licenseRequest.getToDate())
                .generated(LocalDateTime.now().toString())
                .licenseId(UUID.randomUUID().toString())
                .build();
        licenses.add(license);
        return license;
    }

    @Override
    public License getLicenseBySerialNumber(long serialNumber) {
        return licenses.stream()
                .filter(it -> it.getSerialNumber() == serialNumber)
                .findFirst()
                .orElse(License.builder().build());
    }


}
