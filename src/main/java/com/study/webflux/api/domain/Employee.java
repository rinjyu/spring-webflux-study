package com.study.webflux.api.domain;


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
public class Employee {

    @Column(name = "id", length = 15, nullable = false)
    private String id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @Builder
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
