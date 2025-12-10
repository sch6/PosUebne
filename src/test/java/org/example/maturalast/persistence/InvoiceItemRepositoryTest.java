package org.example.maturalast.persistence;

import jakarta.persistence.Table;
import org.example.maturalast.FixtureFactory;
import org.example.maturalast.domain.InvoiceItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InvoiceItemRepositoryTest {
    @Autowired
    private InvoiceItemRepository repository;
    private InvoiceItem invoiceItem = FixtureFactory.testInvoiceItem();
    private boolean initialised;

    @BeforeEach
    void set_up(){
        if(!initialised) {
            repository.saveAndFlush(invoiceItem);
            initialised = true;
        }
    }

    @Test
    void can_save() {
        assertThat(repository.findInvoiceItemByInvoiceId_InvoiceItemId(invoiceItem.getInvoiceId().invoiceItemId()).isPresent());
    }

    @Test
    void find_projected_articles_in_time_span() {
        assertThat(repository.findArticlesInTimeRange(invoiceItem.getInvoice().getDate().minusDays(10), invoiceItem.getInvoice().getDate().plusDays(10)).size())
                .isGreaterThan(0);
    }
}