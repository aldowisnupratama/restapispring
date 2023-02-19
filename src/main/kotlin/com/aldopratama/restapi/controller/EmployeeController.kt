package com.aldopratama.restapi.controller

import com.aldopratama.restapi.configurations.BasicConfiguration
import com.aldopratama.restapi.dto.VersionResponse
import com.aldopratama.restapi.model.Employee
import com.aldopratama.restapi.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/employee")
class EmployeeController(
        @Autowired
        val service: EmployeeService,
        @Autowired
        val enviroment: Environment,

        @Autowired
        val configuration: BasicConfiguration

) {
    @GetMapping
    fun getAllEmployees() = service.getAll()

    @GetMapping("/{id}")
    fun genEmployee(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveEmployee(@RequestBody employee: Employee): Employee = service.create(employee)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEmployee(@PathVariable id: Long) = service.remove(id)


    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: Long, @RequestBody employee: Employee) = service.update(id, employee)


//    @GetMapping("/enviroment")
//    fun showEnviroment(): ResponseEntity<VersionResponse> {
//        return ResponseEntity<VersionResponse>(enviroment.getProperty("application.version")?.let { VersionResponse(version = it, productionMode = false, name = "PakeEnviromentBiasa") }, HttpStatus.OK)
//    }

    @GetMapping("/another")
    fun showEnviromentA(): ResponseEntity<VersionResponse> {
        return ResponseEntity<VersionResponse>(VersionResponse(version = configuration.version, name = configuration.name, productionMode = configuration.productionMode,), HttpStatus.OK)
    }
}