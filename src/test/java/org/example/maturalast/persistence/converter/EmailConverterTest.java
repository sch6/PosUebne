package org.example.maturalast.persistence.converter;

import org.example.maturalast.domain.Email;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmailConverterTest {

    private EmailConverter converter = new EmailConverter();
    private Email mail= new Email("haha");
    private String s = "haha";

    @Test
    void can_convert_to_db() {
        assertThat(s).isEqualTo(converter.convertToDatabaseColumn(mail));
    }
    @Test
    void can_convert_to_entity() {
        assertThat(mail).isEqualTo(converter.convertToEntityAttribute(s));
    }

    @Test
    void cant_convert_null_to_entity() {
        assertThatThrownBy(()->converter.convertToEntityAttribute(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }
    @Test
    void cant_convert_null_to_db() {
        assertThatThrownBy(()->converter.convertToDatabaseColumn(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }
}