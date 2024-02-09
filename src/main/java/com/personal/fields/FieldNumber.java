package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import lombok.Getter;
import lombok.Setter;

@Getter
public final class FieldNumber extends AbstractField implements IField<Long> {
    @Setter
    private Long value;

    public FieldNumber(FieldNameDefinition fieldName, int positionStart, int positionEnd, Long value) {
        super(fieldName, positionStart, positionEnd);
        this.value = value;
    }
}
