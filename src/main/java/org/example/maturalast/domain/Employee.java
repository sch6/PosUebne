package org.example.maturalast.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name = "employees")
public class Employee extends User {

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "employee_2_company"))
    private Company company;
}
