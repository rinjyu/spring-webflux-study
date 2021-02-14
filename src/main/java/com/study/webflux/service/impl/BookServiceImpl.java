package com.study.webflux.service.impl;

import com.study.webflux.domain.Book;
import com.study.webflux.repository.BookRepository;
import com.study.webflux.service.BookService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
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
