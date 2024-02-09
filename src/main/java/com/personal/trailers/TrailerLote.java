package com.personal.trailers;

import com.personal.fields.AbstractRecordLine;
import com.personal.fields.IField;

import java.util.ArrayList;
import java.util.List;

public class TrailerLote extends AbstractRecordLine {
    public TrailerLote(List<IField<?>> lineFieldsList) {
        super(new ArrayList<>(lineFieldsList));
    }

}
