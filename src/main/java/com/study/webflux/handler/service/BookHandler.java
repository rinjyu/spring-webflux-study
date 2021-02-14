package com.study.webflux.handler.service;

import com.study.webflux.domain.Book;
import com.study.webflux.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class BookHandler {

    private final BookService bookService;

    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Mono<ServerResponse> findBooks(ServerRequest request) {

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookService.findBooks(), Book.class);
    }

    public Mono<ServerResponse> findByBook(ServerRequest request) {

        int id = Integer.valueOf(request.pathVariable("id"));

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookService.findByBook(id), Book.class);
    }
}
