package org.example.maturalast;

import org.example.maturalast.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FixtureFactory {

    public static Employee testEmployee() {
        Employee e =  new Employee();
        e.setCompany(testCompany());
        e.setFirstname("FName");
        e.setLastname("LName");
        e.setEmail(testEmail());
        return e;
    }

    public static Company testCompany() {
        return Company.builder()
                .name("Timmi")
                .address(testAddress())
                .build();
    }

    public static Address testAddress() {
        return  new Address("A","B","C");
    }

    public static Email testEmail() {
        return new Email("ahah");
    }

    public static Customer testCustomer() {
        Customer c = new Customer();
        c.setAddresses(new ArrayList<>());
        c.setNote("Cool guy ig");
        c.setEmail(testEmail());
        c.setFirstname("FName");
        c.setLastname("LName");
        c.setCustomerType(CustomerType.B2B);
        c.getAddresses().add(testAddress());
        return c;
    }

    public static Article testArticle() {
        return Article.builder()
                .price(BigDecimal.valueOf(1000))
                .name("Good Article")
                .number(1)
                .build();
    }

    public static InvoiceItem testInvoiceItem() {
        return InvoiceItem.builder()
                .invoice(testInvoice())
                .price(BigDecimal.valueOf(1000))
                .article(testArticle())
                .quantity(2)
                .build();
    }
    public static Invoice testInvoice() {
        return Invoice.builder()
                .number(1)
                .date(LocalDateTime.now())
                //.invoiceItems(new ArrayList<>())
                .customer(testCustomer())
                .employee(testEmployee())
                .build();
    }
}
