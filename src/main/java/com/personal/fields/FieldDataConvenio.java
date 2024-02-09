package com.personal.fields;

import com.personal.config.BankDataExternalDefinition;
import com.personal.config.FieldNameDefinition;
import com.personal.helpers.RequestContextHolderHelper;
import lombok.Getter;

import java.util.Optional;

@Getter
public final class FieldDataConvenio<T> extends AbstractField implements IField<T> {

    private final String convenioFieldName;

    public FieldDataConvenio(FieldNameDefinition fieldName, int positionStart, int positionEnd, String convenioFieldName) {
        super(fieldName, positionStart, positionEnd);
        this.convenioFieldName = convenioFieldName;
    }

    public T getValue() {
        BankDataExternalDefinition.Convenio convenio = RequestContextHolderHelper.getAttribute("convenio");
        return (T) Optional.ofNullable(convenio).map(conv -> convenio.getValueByFieldName(convenioFieldName)).orElseThrow();
    }

}
