package com.study.webflux.api.service;

import com.study.webflux.api.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookApiService {

    Flux<Book> findBooks();

    Mono<Book> findByBook(int id);
}
