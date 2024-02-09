package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.behavior.RandomPositionalValueBehavior;
import lombok.Getter;

import java.util.List;

@Getter
public final class FieldRandomPositional<T> extends AbstractField implements IField<T> {
    private final RandomPositionalValueBehavior<T> randomPositionalValueBehavior;
    private final List<T> value;

    public FieldRandomPositional(FieldNameDefinition fieldName, int positionStart, int positionEnd, List<T> value) {
        super(fieldName, positionStart, positionEnd);
        randomPositionalValueBehavior = new RandomPositionalValueBehavior<>(value);
        this.value = value;
    }

    public T getValue() {
        return randomPositionalValueBehavior.getRandomValue();
    }

    @Override
    public T getActualValue() {
        return randomPositionalValueBehavior.getActualValue();
    }

}
