package org.example.maturalast.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public record Email(@jakarta.validation.constraints.Email @NotNull String value) {
}
