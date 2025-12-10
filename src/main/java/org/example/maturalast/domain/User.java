package org.example.maturalast.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

@Data

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "users")
public abstract class User {

    @EmbeddedId
    protected UserId userId;

    @jakarta.validation.constraints.NotNull
    protected String firstname;
    @jakarta.validation.constraints.NotNull
    protected String lastname;

    @Embedded
    @jakarta.validation.constraints.NotNull
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    protected Email email;

    public record UserId(@GeneratedValue @NotNull Long userId){}
}

