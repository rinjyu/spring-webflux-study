package com.study.webflux.service.impl;

import com.study.webflux.domain.Employee;
import com.study.webflux.repository.EmployeeRepository;
import com.study.webflux.service.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Flux<Employee> findEmployees() {
        return employeeRepository.findEmployees();
    }

    @Override
    public Mono<Employee> findByEmployee(String id) {
        return employeeRepository.findByEmployee(id);
    }
}
