package org.example.maturalast.persistence;

import org.example.maturalast.domain.Employee;
import org.example.maturalast.domain.User;
import org.example.maturalast.dto.SalesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmployeeByUserId_UserId(Long userIdUserId);

}
