package com.study.webflux.web.controller;

import com.study.webflux.api.domain.Book;
import com.study.webflux.web.service.BookWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/web/book")
@AllArgsConstructor
public class BookController {

    private final BookWebService bookWebService;

    @GetMapping({"", "/"})
    private Flux<Book> getAllBooks() {

        return bookWebService.findBooks();
    }

    @GetMapping("/{id}")
    private Mono<Book> getBookById(@PathVariable int id) {

        return bookWebService.findByBook(id);
    }

}
