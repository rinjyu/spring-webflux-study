package com.study.webflux.api.controller;

import com.study.webflux.api.domain.Employee;
import com.study.webflux.api.service.EmployeeApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeApiController {

    private final EmployeeApiService employeeApiService;

    @GetMapping({"", "/"})
    private Flux<Employee> getAllEmployees() {

        return employeeApiService.findEmployees();
    }

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(@PathVariable String id) {

        return employeeApiService.findByEmployee(id);
    }

}
