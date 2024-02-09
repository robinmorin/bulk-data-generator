package com.personal.segments;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.AbstractRecordLine;
import com.personal.fields.IField;

import java.util.Arrays;
import java.util.List;

public class SegmentT extends AbstractRecordLine {

    public SegmentT(List<IField<?>> lineFieldsList) {
        super(lineFieldsList);
    }

    @Override
    public void initDataDependentField(AbstractRecordLine... abstractRecordLine) {
        super.initDataDependentField(abstractRecordLine);

        Arrays.stream(abstractRecordLine)
                .filter(SegmentU.class::isInstance)
                .findAny()
                .ifPresent(recordLine ->
                    addDataDependentField(getFieldByDefinition(FieldNameDefinition.CODIGO_MOVIMENTO_RETORNO), recordLine.getFieldByDefinition(FieldNameDefinition.CODIGO_MOVIMENTO_RETORNO))
                );

    }

}
