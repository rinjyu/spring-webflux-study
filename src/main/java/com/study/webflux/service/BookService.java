package com.study.webflux.service;

import com.study.webflux.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Flux<Book> findBooks();

    Mono<Book> findByBook(int id);
}
