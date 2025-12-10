package org.example.maturalast.persistence.converter;

import org.example.maturalast.domain.CustomerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerTypeConverterTest {

    private static CustomerTypeConverter converter = new CustomerTypeConverter();

    @ParameterizedTest
    @MethodSource("entityData")
     void can_convert_to_database(CustomerType ct, Character c) {
        assertThat(converter.convertToDatabaseColumn(ct)).isEqualTo(c);
    }

    public static Stream<Arguments> entityData() {
        return Stream.of(
          Arguments.of(CustomerType.B2B,'B'),
          Arguments.of(CustomerType.B2C,'C')
        );
    }

    @ParameterizedTest
    @MethodSource("dbData")
     void can_convert_to_entity(CustomerType ct, Character c) {
        assertThat(converter.convertToEntityAttribute(c)).isEqualTo(ct);
    }

    public static Stream<Arguments> dbData() {
        return Stream.of(
                Arguments.of(CustomerType.B2B,'B'),
                Arguments.of(CustomerType.B2C,'C')
        );
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