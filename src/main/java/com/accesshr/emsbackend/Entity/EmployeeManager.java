package com.accesshr.emsbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employeesManager")
public class EmployeeManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String streetAddress;
    private String city;
    private String region;
    private String postalCode;
    private String companyName;
    private String employeeId;
    private String corporateEmail;
    private String jobRole;
    private String employmentStatus;
    private String reportingTo;
    private String role;

    private String nationalCard;
    private String tenthCertificate;
    private String twelfthCertificate;
    private String graduationCertificate;

    private String password; // Added password field
}




