package org.example.maturalast.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name = "invoices")
        //uniqueConstraints = {@UniqueConstraint(columnNames = {"A", "B"})} todo
public class Invoice {
    @EmbeddedId
    private InvoiceId invoiceId;

    @NotNull
    private Integer number;
    @NotNull
    private LocalDateTime date;
    @NotNull
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(foreignKey = @ForeignKey(name = "customer_2_employee"))
    private Customer customer;
    @NotNull
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "invoice_2_employee"))
    private Employee employee;

    @NotNull
    @OneToMany(mappedBy = "invoice", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private List<InvoiceItem> invoiceItems;
    public record InvoiceId(@GeneratedValue @NotNull Long invoiceId){}
}
