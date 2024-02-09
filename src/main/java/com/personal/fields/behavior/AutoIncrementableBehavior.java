package com.personal.fields.behavior;

import com.personal.fields.IField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
public final class AutoIncrementableBehavior {

    // Pra fazer reset dos campos autoincrementáveis que dependam do valor de esse campo
    @Setter
    private List<IField<?>> dependentAutoIncrementableField = null;

    private Long value;
    private final Long initial;
    private final Long maximum;

    public AutoIncrementableBehavior(Long initial, Long maximum) {
        this.initial = initial;
        this.maximum = maximum;
        this.value = initial;
    }
    public Long getValueAutoincremented() {
        resetDependentAutoIncrementableFields();
        if(value > maximum) {
            throw new RuntimeException("Maximum value exceeded");
        }
        return value++;
    }

    public Long getActualValue() {
        return value-1;
    }

    public void resetValue() {
        this.value = this.initial;
    }

    /***
     * Command para fazer reset dos campos autoincrementáveis que dependam do valor de esse campo
     */
    private void resetDependentAutoIncrementableFields() {
        if(Objects.isNull(dependentAutoIncrementableField)) return;
        dependentAutoIncrementableField.stream()
                .filter(Objects::nonNull)
                .map(IField::asAutoIncrementableField)
                .forEach(AutoIncrementableBehavior::resetValue);
    }

}
