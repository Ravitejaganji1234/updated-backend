package com.accesshr.emsbackend.Dto;

import jakarta.persistence.Column;

public class EmployeeManagerDTO {
    private int id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String country;
    private String streetAddress;
    private String city;
    private String region;
    private String postalCode;
    private String companyName;
    private String employeeId;
    
    @Column(unique = true)
    private String corporateEmail;
    private String jobRole;
    private String employmentStatus;
    private String reportingTo;
    private String role;
    private String password;

    // Document file paths or names
    private String nationalCard;            // Updated field name
    private String tenthCertificate;        // Updated field name
    private String twelfthCertificate;      // Updated field name
    private String graduationCertificate;   // Updated field name

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    public String getCorporateEmail() {
        return corporateEmail;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(String reportingTo) {
        this.reportingTo = reportingTo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters for document fields
    public String getNationalCard() {
        return nationalCard;
    }

    public void setNationalCard(String nationalCard) {
        this.nationalCard = nationalCard;
    }

    public String getTenthCertificate() {
        return tenthCertificate;
    }

    public void setTenthCertificate(String tenthCertificate) {
        this.tenthCertificate = tenthCertificate;
    }

    public String getTwelfthCertificate() {
        return twelfthCertificate;
    }

    public void setTwelfthCertificate(String twelfthCertificate) {
        this.twelfthCertificate = twelfthCertificate;
    }

    public String getGraduationCertificate() {
        return graduationCertificate;
    }

    public void setGraduationCertificate(String graduationCertificate) {
        this.graduationCertificate = graduationCertificate;
    }
}
