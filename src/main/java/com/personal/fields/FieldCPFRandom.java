package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import com.personal.utils.CpfGenerator;
import lombok.Getter;

@Getter
public final class FieldCPFRandom extends AbstractField implements IField<String> {

    private String actualValue;
    public FieldCPFRandom(FieldNameDefinition fieldName, int positionStart,
                          int positionEnd) {
        super(fieldName, positionStart, positionEnd);
    }

    public String getValue() {
        actualValue = getFormattedLeadingZeros(Long.parseLong(CpfGenerator.generateRandomCPF()));
        return actualValue;
    }

}
