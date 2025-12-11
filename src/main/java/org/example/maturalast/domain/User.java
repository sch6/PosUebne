package org.example.maturalast.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "users")
public abstract class User {

    @EmbeddedId
    protected UserId userId;

    @NotNull
    protected String firstname;
    @NotNull
    protected String lastname;

    @Embedded
    @jakarta.validation.constraints.NotNull
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    protected Email email;

    public record UserId(@GeneratedValue @NotNull Long userId){}
}

