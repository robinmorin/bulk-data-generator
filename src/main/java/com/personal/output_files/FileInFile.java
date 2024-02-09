package com.personal.output_files;

import com.personal.config.FieldNameDefinition;
import com.personal.config.FieldsLineBlockDefinitions;
import com.personal.fields.FieldNumberAutoIncrementable;
import com.personal.headers.HeaderLote;
import com.personal.headers.HeaderFileIn;
import com.personal.segments.SegmentT;
import com.personal.segments.SegmentU;
import com.personal.trailers.TrailerFile;
import com.personal.trailers.TrailerLote;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileInFile extends OutputFile {

    private HeaderFileIn headerFileIn;
    private HeaderLote headerFileInLote;
    private TrailerLote trailerFileInLote;
    private TrailerFile trailerFileInFile;
    private final SegmentT segmentT;
    private final SegmentU segmentU;

    public FileInFile(SegmentT segmentT, SegmentU segmentU) {
        super();
        this.segmentT = segmentT;
        this.segmentU = segmentU;
        initContext();
    }

    public void setHeaderLote(){
        setHeaderLote(headerFileInLote);
    }
    public void setTrailerLote(){
        setTrailerLote(trailerFileInLote);
    }

    public void setHeaderFile() {
        log.info("Putting header RETORNO");
        setHeaderFile(headerFileIn);
    }

    public void setTrailerFile(){
        log.info("Putting trailer file RETORNO");
        setTrailerFile(trailerFileInFile);
    }

    public void setSegmentsBlock() {
        putContentLine().accept(segmentT.getLine().get());
        putContentLine().accept(segmentU.getLine().get());
    }

    private void initContext() {
        headerFileIn = new HeaderFileIn(FieldsLineBlockDefinitions.getIFieldByHeaderFileIn());
        headerFileInLote = new HeaderLote(FieldsLineBlockDefinitions.getIFieldBySectionLote());
        var fieldSeqByLoteSegT = segmentT.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_REGISTRO_LOTE);
        var fieldSeqByLoteSegU = segmentU.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_REGISTRO_LOTE);
        var fieldSeqLoteFileIn = headerFileInLote.getFieldByDefinition(FieldNameDefinition.LOTE_SERVICO);
        ((FieldNumberAutoIncrementable)fieldSeqLoteFileIn).setDependences(fieldSeqByLoteSegT, fieldSeqByLoteSegU);
        trailerFileInLote = new TrailerLote(FieldsLineBlockDefinitions.getIFieldByTrailerLote());
        trailerFileInFile = new TrailerFile(FieldsLineBlockDefinitions.getIFieldByTrailerFile());

        // Propagating value sequencial of lote to SegmentT e SegmentU
        headerFileInLote.addDataDependentField(fieldSeqLoteFileIn,
                                                segmentT.getFieldByDefinition(FieldNameDefinition.LOTE_SERVICO),
                                                segmentU.getFieldByDefinition(FieldNameDefinition.LOTE_SERVICO),
                                                trailerFileInFile.getFieldByDefinition(FieldNameDefinition.QTA_LOTES_ARQUIVO));

        // Using value sequencial of lote to set value of Quantity records of lote
        segmentT.addDataDependentField(segmentT.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_REGISTRO_LOTE),
                                       trailerFileInLote.getFieldByDefinition(FieldNameDefinition.QTA_REGISTROS_LOTE));

        // Using value sequencial of name payer counter to set value of Quantity records of File
        segmentT.addDataDependentField(segmentT.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_NOME_PAGADOR),
                                       trailerFileInFile.getFieldByDefinition(FieldNameDefinition.QTA_REGISTROS_ARQUIVO));
    }
}
