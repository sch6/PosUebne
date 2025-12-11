package org.example.maturalast.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name = "invoice_items")
public class InvoiceItem {
    @EmbeddedId
    private InvoiceItemId invoiceId;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn( foreignKey = @ForeignKey(name = "invoiceItem_2_invoice"))
    private Invoice invoice;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(foreignKey = @ForeignKey(name = "invoiceItem_2_article"))
    private Article article;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;

    public record InvoiceItemId(@GeneratedValue @NotNull Long invoiceItemId){}
}
