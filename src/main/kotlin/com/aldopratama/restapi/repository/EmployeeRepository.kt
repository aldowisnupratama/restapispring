package com.aldopratama.restapi.repository

import com.aldopratama.restapi.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee,Long>