package com.study.webflux.web.service.impl;

import com.study.webflux.api.domain.Employee;
import com.study.webflux.web.service.EmployeeWebService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeWebServiceImpl implements EmployeeWebService {

    @Value("${api.url}")
    private String API_BASE_URL;

    private final WebClient webClient;

    public EmployeeWebServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Employee> findEmployees() {

        return webClient.mutate()
                        .baseUrl(API_BASE_URL)
                        .build()
                        .get()
                        .uri("/api/employee")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .onStatus(httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError()
                                , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                        .onStatus(httpStatus -> httpStatus.is5xxServerError()
                                , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                        .bodyToFlux(Employee.class);

    }

    @Override
    public Mono<Employee> findByEmployee(String id) {

        return webClient.mutate()
                .baseUrl(API_BASE_URL)
                .build()
                .get()
                .uri("/api/employee/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError()
                        , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                .onStatus(httpStatus -> httpStatus.is5xxServerError()
                        , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                .bodyToMono(Employee.class);
    }
}
