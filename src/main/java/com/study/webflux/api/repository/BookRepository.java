package com.study.webflux.api.repository;

import com.study.webflux.api.domain.Book;
import com.study.webflux.api.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    private final Map<Integer, Book> bookData = new HashMap<>();

    public BookRepository() {
        bookData.put(1, new Book("1", "인텔리제이 IDEA", 28000, "야마모토 유스케", "에이콘출판사"
                                , "기본 사용법부터 고급 기능까지 마스터하기"
                                , "2018년 12월 20일", 300));
        bookData.put(2, new Book("2", "클린 코더 The Clean Coder", 22500, "로버트 마틴", "에이콘출판사"
                , "단순 기술자에서 진정한 소프트웨어 장인이 되기까지"
                , "2016년 07월 20일", 276));
        bookData.put(3, new Book("3", "Clean Code 클린 코드", 29700, "로버트 C. 마틴", "인사이트"
                , "애자일 소프트웨어 장인 정신"
                , "2013년 12월 24일", 584));
        bookData.put(4, new Book("4", "클린 아키텍처", 22500, "로버트 C. 마틴", "인사이트"
                , "소프트웨어 구조와 설계의 원칙"
                , "2019년 08월 20일", 432));
        bookData.put(5, new Book("5", "클린 소프트웨어", 34200, "로버트 C. 마틴", "제이펍"
                , "애자일 원칙과 패턴, 그리고 실천 방법[개정판]"
                , "2017년 05월 15일", 724));
    }

    public Flux<Book> findBooks() {
        return Flux.fromIterable(bookData.values())
                .switchIfEmpty(Flux.error(new DataNotFoundException("등록된 데이터가 없습니다.")));
    }

    public Mono<Book> findByBook(int id) {
        return Mono.justOrEmpty(bookData.get(id))
                .switchIfEmpty(Mono.error(new DataNotFoundException(id + "로 등록된 데이터가 없습니다.")));
    }
}
