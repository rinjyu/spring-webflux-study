package com.study.webflux.web.service;

import com.study.webflux.api.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeWebService {

    Flux<Employee> findEmployees();

    Mono<Employee> findByEmployee(String id);
}
