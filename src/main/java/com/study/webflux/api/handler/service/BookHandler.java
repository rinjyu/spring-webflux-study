package com.study.webflux.api.handler.service;

import com.study.webflux.api.domain.Book;
import com.study.webflux.api.service.BookApiService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class BookHandler {

    private final BookApiService bookApiService;

    public BookHandler(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    public Mono<ServerResponse> findBooks(ServerRequest request) {

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookApiService.findBooks(), Book.class);
    }

    public Mono<ServerResponse> findByBook(ServerRequest request) {

        int id = Integer.valueOf(request.pathVariable("id"));

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookApiService.findByBook(id), Book.class);
    }
}
