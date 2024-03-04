package org.example.license;

@jakarta.jws.WebService
public interface ILicenseGenerator {
    @jakarta.jws.WebMethod
    License generateLicense(LicenseRequest licenseRequest);
}
