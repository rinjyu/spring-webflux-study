package com.study.webflux.service;

import com.study.webflux.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<Employee> findEmployees();

    Mono<Employee> findByEmployee(String id);
}
