package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import lombok.Getter;

@Getter
public final class FieldConstant<T> extends AbstractField implements IField<T> {

    private final T value;

    public FieldConstant(FieldNameDefinition fieldName, int positionStart, int positionEnd, T value) {
        super(fieldName, positionStart, positionEnd);
        this.value = value;
    }
}
