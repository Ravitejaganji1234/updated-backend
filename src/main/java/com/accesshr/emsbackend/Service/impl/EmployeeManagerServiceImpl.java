


package com.accesshr.emsbackend.Service.impl;

import com.accesshr.emsbackend.Dto.EmployeeManagerDTO;
import com.accesshr.emsbackend.Dto.LoginDTO;
import com.accesshr.emsbackend.Entity.EmployeeManager;
import com.accesshr.emsbackend.Repo.EmployeeManagerRepository;
import com.accesshr.emsbackend.Service.EmployeeManagerService;
import com.accesshr.emsbackend.Service.JWT.JWTService;
import com.accesshr.emsbackend.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeManagerServiceImpl implements EmployeeManagerService {

    @Autowired
    private EmployeeManagerRepository employeeManagerRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public EmployeeManagerDTO addEmployee(EmployeeManagerDTO employeeManagerDTO) {
        return saveEmployee(employeeManagerDTO);
    }

    @Override
    public EmployeeManagerDTO addAdmin(EmployeeManagerDTO employeeManagerDTO) {
        // Set the role to Admin
        employeeManagerDTO.setRole("Admin");
        return saveEmployee(employeeManagerDTO);
    }

    private EmployeeManagerDTO saveEmployee(EmployeeManagerDTO employeeManagerDTO) {
        EmployeeManager employee = new EmployeeManager();
        employee.setFirstName(employeeManagerDTO.getFirstName());
        employee.setLastName(employeeManagerDTO.getLastName());
        employee.setEmail(employeeManagerDTO.getEmail());
        employee.setCountry(employeeManagerDTO.getCountry());
        employee.setStreetAddress(employeeManagerDTO.getStreetAddress());
        employee.setCity(employeeManagerDTO.getCity());
        employee.setRegion(employeeManagerDTO.getRegion());
        employee.setPostalCode(employeeManagerDTO.getPostalCode());
        employee.setCompanyName(employeeManagerDTO.getCompanyName());
        employee.setEmployeeId(employeeManagerDTO.getEmployeeId());
        employee.setCorporateEmail(employeeManagerDTO.getCorporateEmail());
        employee.setJobRole(employeeManagerDTO.getJobRole());
        employee.setEmploymentStatus(employeeManagerDTO.getEmploymentStatus());
        employee.setReportingTo(employeeManagerDTO.getReportingTo());
        employee.setRole(employeeManagerDTO.getRole());
        employee.setNationalCard(employeeManagerDTO.getNationalCard());
        employee.setTenthCertificate(employeeManagerDTO.getTenthCertificate());
        employee.setTwelfthCertificate(employeeManagerDTO.getTwelfthCertificate());
        employee.setGraduationCertificate(employeeManagerDTO.getGraduationCertificate());

        // Generate or use the provided password
        String password = employeeManagerDTO.getPassword() != null ? employeeManagerDTO.getPassword()
                : UUID.randomUUID().toString().substring(0, 8); // Generate random password if not provided
        String hashedPassword = passwordEncoder.encode(password);
        employee.setPassword(hashedPassword); // Store hashed password

        employeeManagerRepository.save(employee);

        // Set the plain text password back to DTO for display purposes
        employeeManagerDTO.setPassword(password);

        return employeeManagerDTO;
    }

//    @Override
//    public LoginResponse loginEmployee(LoginDTO loginDTO) {
//        EmployeeManager employee = employeeManagerRepository.findByCorporateEmail(loginDTO.getEmail());
//
//        if (employee != null) {
//            boolean isPasswordValid = new BCryptPasswordEncoder().matches(loginDTO.getPassword(), employee.getPassword());
//            if (isPasswordValid) {
//                // Return role along with message and status
//                return new LoginResponse("Login Success", true, employee.getRole());
//            } else {
//                return new LoginResponse("Password does not match", false, null); // No role if login fails
//            }
//        } else {
//            return new LoginResponse("Email does not exist", false, null); // No role if email not found
//        }
//    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        EmployeeManager employee = employeeManagerRepository.findByCorporateEmail(loginDTO.getEmail());
        if (employee!=null){
            boolean isPasswordValid = new BCryptPasswordEncoder().matches(loginDTO.getPassword(), employee.getPassword());
            if (isPasswordValid){
                Authentication authentication=authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
                if (authentication.isAuthenticated()){
                    String token = jwtService.generateToken(loginDTO.getEmail());
                    return new LoginResponse("Login Success",true,employee.getRole(),token);
                } else {
                    return new LoginResponse("Authentication failed", false, null,null);
                }
            } else {
                return new LoginResponse("Password does not match", false, null,null);
            }
        }else {
            return new LoginResponse("Email not found", false, null,null);
        }
    }

    @Override
    public List<EmployeeManagerDTO> getAllEmployees() {
        List<EmployeeManager> employees = employeeManagerRepository.findAll();
        return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeManagerDTO getEmployeeDataById(String employeeId) {
        EmployeeManager employee = employeeManagerRepository.findByEmployeeId(employeeId);
        System.out.println(employee);
        if (employee != null) {
            return convertToDTO(employee);
        }
        return null;
    }

    @Override
    public EmployeeManagerDTO getEmployeeById(int id) {
        Optional<EmployeeManager> employeeId = employeeManagerRepository.findById(id);
        if (employeeId.isEmpty()){
            return null;
        }else {
            return convertToDTO(employeeId.get());
        }
    }

    @Override
    public EmployeeManagerDTO updateEmployee(int id, EmployeeManagerDTO employeeManagerDTO) {
        EmployeeManager update = employeeManagerRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        if (update!=null){
            update.setFirstName(employeeManagerDTO.getFirstName());
            update.setLastName(employeeManagerDTO.getLastName());
            update.setEmail(employeeManagerDTO.getEmail());
            update.setCountry(employeeManagerDTO.getCountry());
            update.setStreetAddress(employeeManagerDTO.getStreetAddress());
            update.setCity(employeeManagerDTO.getCity());
            update.setRegion(employeeManagerDTO.getRegion());
            update.setPostalCode(employeeManagerDTO.getPostalCode());
            update.setCompanyName(employeeManagerDTO.getCompanyName());
            update.setCorporateEmail(employeeManagerDTO.getCorporateEmail());
            update.setJobRole(employeeManagerDTO.getJobRole());
            update.setEmploymentStatus(employeeManagerDTO.getEmploymentStatus());
            update.setReportingTo(employeeManagerDTO.getReportingTo());
            update.setRole(employeeManagerDTO.getRole());
            update.setNationalCard(employeeManagerDTO.getNationalCard());
            update.setTenthCertificate(employeeManagerDTO.getTenthCertificate());
            update.setTwelfthCertificate(employeeManagerDTO.getTwelfthCertificate());
            update.setGraduationCertificate(employeeManagerDTO.getGraduationCertificate());
            update.setPassword(employeeManagerDTO.getPassword());
            employeeManagerRepository.save(update);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        if (employeeManagerRepository.existsById(id)) {
            employeeManagerRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    @Override
//    public EmployeeManagerDTO getEmployeeById(String employeeId) {
//        EmployeeManager employee = employeeManagerRepository.findById(Integer.valueOf(employeeId)).orElse(null);
//        if (employee != null) {
//            return convertToDTO(employee);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean deleteEmployeeById(int employeeId) {
//        if (employeeManagerRepository.existsById(employeeId)) {
//            employeeManagerRepository.deleteById(employeeId);
//            return true;
//        }
//        return false;
//    }

    // Helper method to convert entity to DTO
    private EmployeeManagerDTO convertToDTO(EmployeeManager employee) {
        EmployeeManagerDTO dto = new EmployeeManagerDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setCountry(employee.getCountry());
        dto.setStreetAddress(employee.getStreetAddress());
        dto.setCity(employee.getCity());
        dto.setRegion(employee.getRegion());
        dto.setPostalCode(employee.getPostalCode());
        dto.setCompanyName(employee.getCompanyName());
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setCorporateEmail(employee.getCorporateEmail());
        dto.setJobRole(employee.getJobRole());
        dto.setEmploymentStatus(employee.getEmploymentStatus());
        dto.setReportingTo(employee.getReportingTo());
        dto.setRole(employee.getRole());
        dto.setNationalCard(employee.getNationalCard());
        dto.setTenthCertificate(employee.getTenthCertificate());
        dto.setTwelfthCertificate(employee.getTwelfthCertificate());
        dto.setGraduationCertificate(employee.getGraduationCertificate());
        return dto;
    }
}
