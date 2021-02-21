package com.study.webflux.web.controller;

import com.study.webflux.api.domain.Employee;
import com.study.webflux.web.service.EmployeeWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/web/employee")
@AllArgsConstructor
public class EmployeeWebController {

    private final EmployeeWebService employeeWebService;

    @GetMapping({"", "/"})
    private Flux<Employee> getAllEmployees() {

        System.out.println("들어옴");

        return employeeWebService.findEmployees();
    }

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(@PathVariable String id) {

        return employeeWebService.findByEmployee(id);
    }

}
