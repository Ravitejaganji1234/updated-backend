package com.accesshr.emsbackend.Repo;

import com.accesshr.emsbackend.Entity.EmployeeManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeManagerRepository extends JpaRepository<EmployeeManager, Integer> {
    // Custom method to find Employee by their corporate email
    EmployeeManager findByCorporateEmail(String corporateEmail);

    EmployeeManager findByEmployeeId(String email);

    boolean existsByEmployeeId(String employeeId);



//    @Query("SELECT e FROM EmployeeManager e WHERE e.employeeId = :employeeId")
//    List<EmployeeManager> findByEmployeeId(@Param("employeeId") String employeeId);


//    Optional<EmployeeManager> findByEmployeeId(String employeeId);

}
