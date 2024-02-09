package com.personal.fields;


import com.personal.config.FieldNameDefinition;
import com.personal.fields.behavior.AutoIncrementableBehavior;
import lombok.Getter;

import java.util.Arrays;

@Getter
public final class FieldNumberAutoIncrementable extends AbstractField implements IField<Long> {

    private final AutoIncrementableBehavior autoIncrementableBehavior;

    /***
     * Constructor
     * @param fieldName   Name of field
     * @param positionStart Position start of field in line of file
     * @param positionEnd   Position end of field in line of file
     * @param initialAutoIncrement Initial value for autoincrement
     * @param maximumAutoIncrement Maximum value for autoincrement
     */
    public FieldNumberAutoIncrementable(FieldNameDefinition fieldName, int positionStart, int positionEnd, Long initialAutoIncrement, Long maximumAutoIncrement) {
        super(fieldName, positionStart, positionEnd);
        autoIncrementableBehavior = new AutoIncrementableBehavior(initialAutoIncrement, maximumAutoIncrement);
    }

    public Long getValue() {
        return autoIncrementableBehavior.getValueAutoincremented();
    }

    @Override
    public Long getActualValue() {
        return autoIncrementableBehavior.getActualValue();
    }

    /***
     * Set the fields that will be reset when the value of this field is incremented
     * @param dependences
     */
    public void setDependences(IField<?>...dependences) {
        autoIncrementableBehavior.setDependentAutoIncrementableField(Arrays.asList(dependences));
    }

    @Override
    public AutoIncrementableBehavior asAutoIncrementableField() {
        return autoIncrementableBehavior;
    }
}
