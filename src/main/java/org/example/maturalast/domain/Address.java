package org.example.maturalast.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;


@Embeddable
public record Address(@NotNull String street,@NotNull String zip,@NotNull String city) {

}
