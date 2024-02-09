package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public final class FieldDecimal extends AbstractField implements IField<BigDecimal> {
    @Setter
    private BigDecimal value;

    public FieldDecimal(FieldNameDefinition fieldName, int positionStart, int positionEnd, BigDecimal value) {
        super(fieldName, positionStart, positionEnd);
        this.value = value;
    }
}
