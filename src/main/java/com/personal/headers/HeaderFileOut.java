package com.personal.headers;

import com.personal.fields.AbstractRecordLine;
import com.personal.fields.IField;

import java.util.ArrayList;
import java.util.List;

public class HeaderFileOut extends AbstractRecordLine {

    public HeaderFileOut(List<IField<?>> lineFieldsList) {
        super(new ArrayList<>(lineFieldsList));
    }

}
