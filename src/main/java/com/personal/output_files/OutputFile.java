package com.personal.output_files;

import com.personal.fields.AbstractRecordLine;
import com.personal.helpers.FileWriterHelper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.LinkedList;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public abstract class OutputFile {

    private final LinkedList<String> contentList = new LinkedList<>();

    protected Consumer<String> putContentLine() {
        return contentList::add;
    }

    public File getFile(String filename) {
        return FileWriterHelper.generateFile(filename, contentList);
    }

    public abstract void setHeaderFile();
    public abstract void setTrailerFile();
    public abstract void setHeaderLote();
    public abstract void setTrailerLote();
    public abstract void setSegmentsBlock();

    protected void setHeaderFile(AbstractRecordLine headerFile) {
        putContentLine().accept(headerFile.getLine().get());
    }

    protected void setTrailerFile(AbstractRecordLine trailerFile) {
        putContentLine().accept(trailerFile.getLine().get());
    }

    protected void setHeaderLote(AbstractRecordLine headerLote) {
        putContentLine().accept(headerLote.getLine().get());
    }

    protected void setTrailerLote(AbstractRecordLine trailerLote) {
        putContentLine().accept(trailerLote.getLine().get());
    }

}
