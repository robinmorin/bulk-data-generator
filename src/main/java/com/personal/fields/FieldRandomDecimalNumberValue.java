package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.behavior.RandomValueBehavior;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public final class FieldRandomDecimalNumberValue extends AbstractField implements IField<BigDecimal> {
    private final RandomValueBehavior<BigDecimal> randomValueBehavior;
    private final BigDecimal minValue;
    private final BigDecimal maxValue;

    public FieldRandomDecimalNumberValue(FieldNameDefinition fieldName, int positionStart, int positionEnd, BigDecimal minValue, BigDecimal maxValue) {
        super(fieldName, positionStart, positionEnd);
        randomValueBehavior = new RandomValueBehavior<>(minValue, maxValue);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public BigDecimal getValue() {
        return randomValueBehavior.getRandomNumber();
    }

    @Override
    public BigDecimal getActualValue() {
        return randomValueBehavior.getLastValue();
    }

}
