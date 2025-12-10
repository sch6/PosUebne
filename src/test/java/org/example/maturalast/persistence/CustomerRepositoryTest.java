package org.example.maturalast.persistence;

import org.example.maturalast.FixtureFactory;
import org.example.maturalast.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;
    private Customer customer = FixtureFactory.testCustomer();
    private boolean initialised;

    @BeforeEach
    void set_up() {
        if(!initialised) {
            repository.saveAndFlush(customer);
            initialised = true;
        }
    }

    @Test
    void can_save() {
        assertThat(repository.findCustomerByUserId_UserId(customer.getUserId().userId()).isPresent());
    }
}