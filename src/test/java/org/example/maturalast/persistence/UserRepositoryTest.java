package org.example.maturalast.persistence;

import org.example.maturalast.FixtureFactory;
import org.example.maturalast.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    private User user;
    private User user2;
    private boolean initialised;

    @BeforeEach
    void set_up() {
        if(!initialised) {
            user = FixtureFactory.testEmployee();
            user2 = FixtureFactory.testCustomer();
            repository.save(user2);
            repository.saveAndFlush(user);
        }
    }

    @Test
    void can_save() {
        assertThat(repository.findAll().size()).isEqualTo(2);
    }
}