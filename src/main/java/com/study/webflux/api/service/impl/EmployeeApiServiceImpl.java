package com.study.webflux.api.service.impl;

import com.study.webflux.api.domain.Employee;
import com.study.webflux.api.repository.EmployeeRepository;
import com.study.webflux.api.service.EmployeeApiService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeApiServiceImpl implements EmployeeApiService {

    private final EmployeeRepository employeeRepository;

    public EmployeeApiServiceImpl(EmployeeRepository employeeRepository) {
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
