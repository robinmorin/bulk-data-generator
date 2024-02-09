package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.behavior.AutoIncrementableBehavior;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public interface IField<T> {
    default int getSize() {
        return getPositionEnd() - getPositionStart() + 1;
    }
    T getValue();
    default void setValue(T value){
        throw new UnsupportedOperationException("This field is self-generated or is constant, it is not possible to set a value");
    }
    FieldNameDefinition getFieldName();
    int getPositionStart();
    int getPositionEnd();

    // Aplica só para campos autoincrementáveis, outros tipos de campo retornaram uma excepção
    default AutoIncrementableBehavior asAutoIncrementableField(){
        throw new UnsupportedOperationException("This field is not autoincrementable");
    }

    default String getFormattedLeadingZeros(Object fieldValue) {
        return ("%0" + getSize() + "d").formatted(fieldValue);
    }

    default String getFormattedLeadingSpace(Object fieldValue) {
        return ("%-" + getSize() + "s").formatted(fieldValue);
    }

    default String getFormattedDecimalWithoutSeparator(BigDecimal fieldValue) {
        BigDecimal value = fieldValue.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat decimalFormat = new DecimalFormat("0".repeat(getSize()-3)+".00");
        return decimalFormat.format(value).replaceAll("[.,]", "");
    }

    default String getCheckedValue() {
        String resultValue = "";
        var fieldValue = getValue();
        resultValue = switch (fieldValue.getClass().getSimpleName()) {
                                case "String" -> getFormattedLeadingSpace(fieldValue);
                                case "Integer", "Long" -> getFormattedLeadingZeros(fieldValue);
                                case "BigDecimal" -> getFormattedDecimalWithoutSeparator((BigDecimal) fieldValue);
                                default -> getFormattedLeadingSpace(fieldValue.toString());
                            };

        if(resultValue.length() > getSize()) {
            resultValue = resultValue.substring(0, getSize());
        }
        return resultValue;
    }

    default void setWrappedValue(Object value) {
        setValue((T) value);
    }

    default T getActualValue() {
        return getValue();
    }
}
