package com.study.webflux.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Book {

    @Column(name = "id", length = 15, nullable = false)
    private String id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "author", length = 30, nullable = false)
    private String author;

    @Column(name = "publisher", length = 30, nullable = false)
    private String publisher;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "registrationDate", length = 15, nullable = false)
    private String registrationDate;

    @Column(name = "totalPage", nullable = false)
    private int totalPage;

    @Builder
    public Book(String id, String name, int price, String author, String publisher, String description, String registrationDate, int totalPage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.registrationDate = registrationDate;
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
