package com.study.webflux.api.service;

import com.study.webflux.api.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeApiService {

    Flux<Employee> findEmployees();

    Mono<Employee> findByEmployee(String id);
}
