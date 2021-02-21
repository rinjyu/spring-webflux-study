package com.study.webflux.web.service;

import com.study.webflux.api.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookWebService {

    Flux<Book> findBooks();

    Mono<Book> findByBook(int id);
}
