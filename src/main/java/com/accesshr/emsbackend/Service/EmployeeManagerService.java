package com.accesshr.emsbackend.Service;

import com.accesshr.emsbackend.Dto.EmployeeManagerDTO;
import com.accesshr.emsbackend.Dto.LoginDTO;
import com.accesshr.emsbackend.response.LoginResponse;

import java.util.List;

public interface EmployeeManagerService {
//    EmployeeManagerDTO addEmployee(EmployeeManagerDTO employeeManagerDTO);
//    EmployeeManagerDTO addAdmin(EmployeeManagerDTO employeeManagerDTO);
//    LoginResponse loginEmployee(LoginDTO loginDTO);
//    List<EmployeeManagerDTO> getAllEmployees(); // New method to fetch all employees
//    EmployeeManagerDTO getEmployeeById(String employeeId); // New method to fetch employee by ID
//    boolean deleteEmployeeById(int employeeId); // New method to delete employee by ID

    EmployeeManagerDTO addEmployee(EmployeeManagerDTO employeeManagerDTO);
    EmployeeManagerDTO addAdmin(EmployeeManagerDTO employeeManagerDTO);
    LoginResponse loginEmployee(LoginDTO loginDTO);
    List<EmployeeManagerDTO> getAllEmployees(); // New method to fetch all employees
    //    EmployeeManagerDTO getById(int id); // New method to fetch employee by ID
    boolean deleteById(int id); // New method to delete employee by ID
    EmployeeManagerDTO getEmployeeDataById(String employeeId); // New method to fetch employee by ID
    EmployeeManagerDTO updateEmployee(int id, EmployeeManagerDTO employeeManagerDTO);
    EmployeeManagerDTO getEmployeeById(int id);
}

