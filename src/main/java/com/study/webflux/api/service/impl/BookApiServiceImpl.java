package com.study.webflux.api.service.impl;

import com.study.webflux.api.domain.Book;
import com.study.webflux.api.repository.BookRepository;
import com.study.webflux.api.service.BookApiService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookApiServiceImpl implements BookApiService {

    private final BookRepository bookRepository;

    public BookApiServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Flux<Book> findBooks() {
        return bookRepository.findBooks();
    }

    @Override
    public Mono<Book> findByBook(int id) {
        return bookRepository.findByBook(id);
    }
}
