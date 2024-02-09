package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AbstractField {
    private final FieldNameDefinition fieldName;
    private final int positionStart;
    private final int positionEnd;

}
