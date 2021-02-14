package com.study.webflux.repository;

import com.study.webflux.domain.Employee;
import com.study.webflux.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private final Map<String, Employee> employeeData = new HashMap<>();

    public EmployeeRepository() {
        employeeData.put("N00001", new Employee("N00001","이름1"));
        employeeData.put("N00002", new Employee("N00002","이름2"));
        employeeData.put("N00003", new Employee("N00003","이름3"));
        employeeData.put("N00004", new Employee("N00004","이름4"));
    }

    public Flux<Employee> findEmployees() {

        return Flux.fromIterable(employeeData.values())
                .switchIfEmpty(Flux.error(new DataNotFoundException("등록된 데이터가 없습니다.")));
    }

    public Mono<Employee> findByEmployee(String id) {

        return Mono.justOrEmpty(employeeData.get(id))
                .switchIfEmpty(Mono.error(new DataNotFoundException(id + "로 등록된 데이터가 없습니다.")));
    }
}
