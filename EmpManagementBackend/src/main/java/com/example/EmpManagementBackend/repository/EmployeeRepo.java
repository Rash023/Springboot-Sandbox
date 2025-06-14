package com.example.EmpManagementBackend.repository;

import com.example.EmpManagementBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmailId(String emailId);

}
