package com.study.webflux.web.service.impl;

import com.study.webflux.api.domain.Book;
import com.study.webflux.web.service.BookWebService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookWebServiceImpl implements BookWebService {

    @Value("${api.url}")
    private String API_BASE_URL;

    private final WebClient webClient;

    public BookWebServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Book> findBooks() {

        return webClient.mutate()
                .baseUrl(API_BASE_URL)
                .build()
                .get()
                .uri("/api/book")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError()
                        , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                .onStatus(httpStatus -> httpStatus.is5xxServerError()
                        , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                .bodyToFlux(Book.class);
    }

    @Override
    public Mono<Book> findByBook(int id) {

        return webClient.mutate()
                .baseUrl(API_BASE_URL)
                .build()
                .get()
                .uri("/api/book/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError()
                        , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                .onStatus(httpStatus -> httpStatus.is5xxServerError()
                        , clientResponse -> clientResponse.bodyToMono(String.class).map(body -> new RuntimeException(body)))
                .bodyToMono(Book.class);
    }
}
