package org.example.maturalast.persistence.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.maturalast.domain.CustomerType;

@Converter(autoApply = true)
public class CustomerTypeConverter implements AttributeConverter<CustomerType,Character> {

    public static final String VALID_VALUES = "'B','C'";
    public static final String COLUMN_DEFINITION = "char(1) check(customer_type in ("+ VALID_VALUES +"))"; //todo

    @Override
    public Character convertToDatabaseColumn(CustomerType customerType) {
        switch (customerType) {
            case B2C -> {
                return CustomerType.B2C.name().charAt(2);
            }
            case B2B -> {
                return CustomerType.B2B.name().charAt(2);
            }
            case null -> {
                throw new IllegalArgumentException("Customer Type cant be null"); //Dataqualtity
            }
        }
    }

    @Override
    public CustomerType convertToEntityAttribute(Character character) {
        if(character == null ||character.equals(' '))
            throw new IllegalArgumentException("Customer Type cant be null"); //Dataquality
        switch (Character.toUpperCase(character)) {
            case 'B' -> {
                return CustomerType.B2B;
            }
            case 'C' -> {
                return CustomerType.B2C;
            }
            default -> throw new IllegalArgumentException("Customer type (%s) does not exist".formatted(character));
        }
    }
}
