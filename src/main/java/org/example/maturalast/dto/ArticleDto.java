package org.example.maturalast.dto;

import org.example.maturalast.domain.Article;

import java.time.LocalDateTime;

public class ArticleDto {
    private Integer number;
    private String name;
    private LocalDateTime date;
    private String firstname;
    private String lastname;

    public ArticleDto(Integer number, String name, LocalDateTime date, String firstname, String lastname) {
        this.number = number;
        this.name = name;
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
