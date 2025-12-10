package org.example.maturalast.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "company")
public class Company {
    @EmbeddedId
    private CompanyId companyId;
    @NotNull
    private String name;
    @NotNull
    private Address address;

    public record CompanyId(@GeneratedValue @NotNull Long companyId){}
}
