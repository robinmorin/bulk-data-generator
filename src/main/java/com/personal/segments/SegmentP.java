package com.personal.segments;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.AbstractRecordLine;
import com.personal.fields.IField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SegmentP extends AbstractRecordLine {

    public SegmentP(List<IField<?>> lineFieldsList) {
        super(lineFieldsList);
    }

    @Override
    public void initDataDependentField(AbstractRecordLine... abstractRecordLine) {
        super.initDataDependentField(abstractRecordLine);

        var valorTitulo = getFieldByDefinition(FieldNameDefinition.VALOR_NOMINAL_TITULO);
        var dependents = new ArrayList<>();
        dependents.add(getFieldByDefinition(FieldNameDefinition.VALOR_ABATIMENTO));

        Arrays.stream(abstractRecordLine)
                .forEach(recordLine -> {
                    switch (recordLine.getClass().getSimpleName()){
                        case "SegmentT" -> dependents.add(recordLine.getFieldByDefinition(FieldNameDefinition.VALOR_NOMINAL_TITULO));
                        case "SegmentU" -> dependents.add(recordLine.getFieldByDefinition(FieldNameDefinition.VALOR_PAGO_PELO_SACADO));
                        default -> throw new IllegalStateException("Unexpected Class: " + recordLine.getClass().getSimpleName());
                    }
                });
        addDataDependentField(valorTitulo, dependents.toArray(IField<?>[]::new));
    }

}
