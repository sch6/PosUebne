package org.example.maturalast.persistence.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.maturalast.domain.Email;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email email) {
        if(email== null || email.value() == null ||email.value().isEmpty())
            throw new IllegalArgumentException("Email cant be null"); //Dataquality no time
        return email.value();
    }

    @Override
    public Email convertToEntityAttribute(String s) {
        if(s==null ||s.isEmpty())
            throw new IllegalArgumentException("Email cant be null");
        return new Email(s);
    }
}
