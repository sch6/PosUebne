package org.example.maturalast.dto;

import org.example.maturalast.domain.Article;

public class ArticleDto {
    private Integer number;

    public ArticleDto(Article a) {
        number = a.getNumber();
    }
}
