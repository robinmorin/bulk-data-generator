package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import lombok.Getter;
import lombok.Setter;

@Getter
public final class FieldString extends AbstractField implements IField<String> {
    @Setter
    private String value;

    public FieldString(FieldNameDefinition fieldName, int positionStart, int positionEnd, String value) {
        super(fieldName, positionStart, positionEnd);
        this.value = value;
    }
}
