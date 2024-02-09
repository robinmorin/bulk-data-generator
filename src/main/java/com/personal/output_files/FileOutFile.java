package com.personal.output_files;

import com.personal.config.FieldNameDefinition;
import com.personal.config.FieldsLineBlockDefinitions;
import com.personal.fields.FieldNumberAutoIncrementable;
import com.personal.headers.HeaderLote;
import com.personal.headers.HeaderFileOut;
import com.personal.segments.SegmentP;
import com.personal.segments.SegmentQ;
import com.personal.trailers.TrailerFile;
import com.personal.trailers.TrailerLote;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileOutFile extends OutputFile {

    private HeaderFileOut headerFileOut;
    private HeaderLote headerFileOutLote;
    private TrailerLote trailerLoteFileOut;
    private TrailerFile trailerFileFileOut;
    private final SegmentP segmentP;
    private final SegmentQ segmentQ;

    public FileOutFile(SegmentP segmentP, SegmentQ segmentQ) {
        super();
        this.segmentP = segmentP;
        this.segmentQ = segmentQ;
        initContext();
    }

    public void setHeaderLote(){
        setHeaderLote(headerFileOutLote);
    }
    public void setTrailerLote(){
        setTrailerLote(trailerLoteFileOut);
    }

    public void setHeaderFile() {
        log.info("Putting header FileOut");
        setHeaderFile(headerFileOut);
    }

    public void setTrailerFile(){
        log.info("Putting trailer RETORNO");
        setTrailerFile(trailerFileFileOut);
    }

    public void setSegmentsBlock() {
        putContentLine().accept(segmentP.getLine().get());
        putContentLine().accept(segmentQ.getLine().get());
    }

    private void initContext() {
        headerFileOut = new HeaderFileOut(FieldsLineBlockDefinitions.getIFieldByHeaderFileOut());
        headerFileOutLote = new HeaderLote(FieldsLineBlockDefinitions.getIFieldBySectionLote());
        var fieldSeqByLoteSegP = segmentP.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_REGISTRO_LOTE);
        var fieldSeqByLoteSegQ = segmentQ.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_REGISTRO_LOTE);
        var fieldSeqLoteFileOut = headerFileOutLote.getFieldByDefinition(FieldNameDefinition.LOTE_SERVICO);
        ((FieldNumberAutoIncrementable)fieldSeqLoteFileOut).setDependences(fieldSeqByLoteSegP, fieldSeqByLoteSegQ);
        trailerLoteFileOut = new TrailerLote(FieldsLineBlockDefinitions.getIFieldByTrailerLote());
        trailerFileFileOut = new TrailerFile(FieldsLineBlockDefinitions.getIFieldByTrailerFile());

        // Propagating value sequencial of lote to SegmentP e SegmentQ
        headerFileOutLote.addDataDependentField(fieldSeqLoteFileOut,
                                                segmentP.getFieldByDefinition(FieldNameDefinition.LOTE_SERVICO),
                                                segmentQ.getFieldByDefinition(FieldNameDefinition.LOTE_SERVICO),
                                                trailerFileFileOut.getFieldByDefinition(FieldNameDefinition.QTA_LOTES_ARQUIVO));

        // Using value sequencial of lote to set value of Quantity records of lote
        segmentP.addDataDependentField(segmentP.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_REGISTRO_LOTE),
                                       trailerLoteFileOut.getFieldByDefinition(FieldNameDefinition.QTA_REGISTROS_LOTE));

        // Using value sequencial of name payer counter to set value of Quantity records of File
        segmentQ.addDataDependentField(segmentQ.getFieldByDefinition(FieldNameDefinition.SEQUENCIAL_NOME_PAGADOR),
                                       trailerFileFileOut.getFieldByDefinition(FieldNameDefinition.QTA_REGISTROS_ARQUIVO));

    }
}
