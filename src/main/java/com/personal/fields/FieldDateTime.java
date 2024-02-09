package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Pattern;

@Getter
public final class FieldDateTime extends AbstractField implements IField<String> {

    private final String patternDate;
    private final DateTimeFormatter dateFormatter;
    private LocalDateTime defaultValue;
    Pattern patterDuration = Pattern.compile("^([+-])?(P[0-9]+[D]|PT[0-9]+[HMS])$");

    // Representação String de Duration para definir o intervalo de tempo partindo da data de hoje.
    // Exemplo: P2D (2 dias), PT2H (2 horas), PT2M (2 minutos), etc. Primeiro digito vazio ou (+) define que devera somar, e (-) define se deve Restar o intervalo
    private String calculateFromValue;

    public FieldDateTime(FieldNameDefinition fieldName, int positionStart, int positionEnd, String patternDate) {
        super(fieldName, positionStart, positionEnd);
        this.patternDate = patternDate;
        this.dateFormatter = DateTimeFormatter.ofPattern(patternDate);
    }

    public FieldDateTime(FieldNameDefinition fieldName, int positionStart, int positionEnd, String patternDate, LocalDateTime defaultValue) {
        this(fieldName, positionStart, positionEnd, patternDate);
        this.defaultValue = defaultValue;
    }

    public FieldDateTime(FieldNameDefinition fieldName, int positionStart, int positionEnd, String patternDate, String calculateFromValue) {
        this(fieldName, positionStart, positionEnd, patternDate);
        validatePatternDuration(calculateFromValue);
        this.calculateFromValue = calculateFromValue;
    }

    private void validatePatternDuration(String calculateFromValue) {
        if(!patterDuration.matcher(calculateFromValue).matches()){
            throw new IllegalArgumentException("Given value for field 'calculateFromValue' = %s is not valid!".formatted(calculateFromValue));
        }
    }

    public String getValue() {
        if(Objects.nonNull(defaultValue)){
            return dateFormatter.format(defaultValue);
        } else if(Objects.nonNull(calculateFromValue)){
            return dateFormatter.format(Objects.requireNonNull(calculateDate(LocalDateTime.now(), calculateFromValue)));
        } else {
            return dateFormatter.format(LocalDateTime.now());
        }
    }

    private LocalDateTime calculateDate(LocalDateTime datePoint, String calculateFromValue) {
        return datePoint.plus(Duration.parse(calculateFromValue));
    }

}
