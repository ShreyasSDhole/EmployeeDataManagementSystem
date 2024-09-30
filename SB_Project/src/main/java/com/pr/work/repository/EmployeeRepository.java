package com.pr.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pr.work.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
