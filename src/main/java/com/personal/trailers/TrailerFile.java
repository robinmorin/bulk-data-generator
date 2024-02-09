package com.personal.trailers;

import com.personal.fields.AbstractRecordLine;
import com.personal.fields.IField;

import java.util.ArrayList;
import java.util.List;

public class TrailerFile extends AbstractRecordLine {
    public TrailerFile(List<IField<?>> lineFieldsList) {
        super(new ArrayList<>(lineFieldsList));
    }
}
