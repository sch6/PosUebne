package org.example.maturalast.dto;

import org.example.maturalast.domain.Customer;
import org.example.maturalast.domain.Employee;
import org.example.maturalast.domain.Invoice;
import org.example.maturalast.domain.InvoiceItem;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SalesDto {
    Integer number;
    LocalDateTime date;
    BigDecimal wholePrice;
    String firstname;
    String lastname;
    SalesDto(String firstname,  String lastname, Invoice i) {
            number = i.getNumber();
            date = i.getDate();
        wholePrice= i.getInvoiceItems().stream()
                 .map((s) -> s.getPrice().multiply(BigDecimal.valueOf(s.getQuantity())))
                 .reduce(BigDecimal.ZERO, BigDecimal::add);
            this.firstname = firstname;
            this.lastname = lastname;
    }
}
