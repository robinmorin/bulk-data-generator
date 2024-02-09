package com.personal.segments;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.AbstractRecordLine;
import com.personal.fields.IField;

import java.util.Arrays;
import java.util.List;

public class SegmentQ extends AbstractRecordLine {

    public SegmentQ(List<IField<?>> lineFieldsList) {
        super(lineFieldsList);
    }

    @Override
    public void initDataDependentField(AbstractRecordLine... abstractRecordLine) {
        super.initDataDependentField(abstractRecordLine);
        Arrays.stream(abstractRecordLine)
                .filter(SegmentT.class::isInstance)
                .findAny()
                .ifPresent(segment -> {
                    var nroInscricao = getFieldByDefinition(FieldNameDefinition.NRO_INSCRICAO_PAGADOR);
                    var nroInscricaoSegmentT  = segment.getFieldByDefinition(FieldNameDefinition.NRO_INSCRICAO_PAGADOR);
                    addDataDependentField(nroInscricao, nroInscricaoSegmentT);
                });
    }

}
