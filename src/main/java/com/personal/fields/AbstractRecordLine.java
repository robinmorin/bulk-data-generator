package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractRecordLine {

    private final List<IField<?>> lineFieldsList;

    private HashMap<IField<?>, List<IField<?>>> mapDataDependent = new HashMap<>();

    protected AbstractRecordLine(List<IField<?>> lineFieldsList) {
        this.lineFieldsList = lineFieldsList;
        initDataDependentField();
    }

    public Supplier<String> getLine() {
        return () -> {
            StringBuilder line = new StringBuilder();
            lineFieldsList.forEach(field -> line.append(propagateValue(field)));
            return line.toString();
        };
    }

    private String propagateValue(IField<?> field) {
        var fieldValue = field.getCheckedValue();
        if (!ObjectUtils.isEmpty(mapDataDependent) && mapDataDependent.containsKey(field)) {
            mapDataDependent.get(field).forEach(dependentField -> dependentField.setWrappedValue(field.getActualValue()));
        }
        return fieldValue;
    }


    // If necessary, change the return type to List<IField<?>> in case of multiple fields with the same name
    public IField<?> getFieldByDefinition(FieldNameDefinition definition) {
        return lineFieldsList.stream()
                .filter(field -> field.getFieldName().equals(definition))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Field not found"));
    }


    /***
     * Add dependent fields to the field
     * - The dependence is formed by the field that have a original value (as key of Map)
     *   and the fields that will receive the same value (as value of Map)
     * @param field Field that have a original value
     * @param dependentFields Fields that will receive the same value
     */
    public void addDataDependentField(IField<?> field, IField<?>...dependentFields) {
        if(mapDataDependent.containsKey(field))
            mapDataDependent.get(field).addAll(Arrays.stream(dependentFields).toList());
        else
            mapDataDependent.put(field, Arrays.stream(dependentFields).toList());
    }

    protected void initDataDependentField() {
        mapDataDependent = new HashMap<>();
    }

    protected void initDataDependentField(AbstractRecordLine...abstractRecordLine) {
        if(ObjectUtils.isEmpty(abstractRecordLine)) {
            throw new IllegalArgumentException("Must AbstractRecordLine not null");
        }
    }

}
