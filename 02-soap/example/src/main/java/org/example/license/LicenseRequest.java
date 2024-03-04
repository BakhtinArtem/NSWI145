package org.example.license;

import org.example.LocalDateAdapter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@lombok.Data
//@XmlAccessorType(XmlAccessType.FIELD)
public class LicenseRequest {
    private long serialNumber;
//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private String fromDate;
//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private String toDate;
}
