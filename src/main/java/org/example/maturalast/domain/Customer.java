package org.example.maturalast.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.maturalast.persistence.converter.CustomerTypeConverter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Data
@Entity
@Table(name = "customer")
public class Customer extends User {

    @NotNull
    @ElementCollection
    @JoinTable(name = "addresses", foreignKey = @ForeignKey(name = "FK_address_2_customer"))
    private List<Address> addresses;
    @NotNull
    @Column(columnDefinition = CustomerTypeConverter.COLUMN_DEFINITION)
    private CustomerType customerType;
    private String note;
}
