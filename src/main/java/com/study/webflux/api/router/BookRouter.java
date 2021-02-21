package com.study.webflux.api.router;

import com.study.webflux.api.handler.service.BookHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> routeByBook(BookHandler handler) {

        return route()
                .path("/api/book", book1 -> book1
                        .nest(accept(APPLICATION_JSON), book2 -> book2
                                .GET("/{id}", handler::findByBook)
                                .GET("", handler::findBooks)))
//                                .POST("/", handler::create)
//                                .PUT("/", handler::modify)
//                                .DELETE("/{id}", handler::remove))
                .build();
    }
}
