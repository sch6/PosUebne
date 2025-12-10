package org.example.maturalast.persistence;

import org.example.maturalast.FixtureFactory;
import org.example.maturalast.domain.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository repository;
    private Article article = FixtureFactory.testArticle();
    private boolean initialised;

    @BeforeEach
    void set_up() {
        if(!initialised) {
            repository.saveAndFlush(article);
            initialised =true;
        }
    }

    @Test
    void can_save() {
        assertThat(repository.findArticleByNumber(article.getNumber()).isPresent());
    }

}