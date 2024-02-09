package com.personal.output_files;

import com.personal.config.FieldsLineBlockDefinitions;
import com.personal.helpers.FileWriterHelper;
import com.personal.helpers.RequestContextHolderHelper;
import com.personal.segments.SegmentP;
import com.personal.segments.SegmentQ;
import com.personal.segments.SegmentT;
import com.personal.segments.SegmentU;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessHandler {

    private FileOutFile fileOutFile;
    private FileInFile fileInFile;
    private SegmentP segmentP;
    private SegmentQ segmentQ;
    private SegmentT segmentT;
    private SegmentU segmentU;

    public File generateFiles(String patternFileName) throws IOException {
        log.info("Starting process to generate data for files of fileOut and FileIn");
        initContext();
        fileOutFile = new FileOutFile(segmentP, segmentQ);
        fileInFile = new FileInFile(segmentT, segmentU);
        var fileOutFileName = "%s_fileOut.txt".formatted(patternFileName);
        var retornoFileName = "%s_retorno.txt".formatted(patternFileName);
        putHeadersInContents();
        var qtaRecords = (Integer) RequestContextHolderHelper.getAttribute("qtaRecords");
        var qtaRecordsByLotes = (Integer) RequestContextHolderHelper.getAttribute("qtaRecordsLote");

        Integer countRecords = 0;
        log.info("Generating records for FileOut and FileIn files.........");
        while (countRecords < qtaRecords){
            putHeadersLoteInContents();
            var topeLote = (qtaRecords - countRecords) < qtaRecordsByLotes ? (qtaRecords - countRecords) : qtaRecordsByLotes;
            for (int j = 0; j < topeLote; j++) {
                putSegmentsContent();
                countRecords++;
            }
            putTrailersLote();
        }
        putTrailersFile();

        log.info("Finishing process to generate data for files of FileOut and FileIn");
        return FileWriterHelper.zipFiles(Arrays.asList(fileOutFile.getFile(fileOutFileName), fileInFile.getFile(retornoFileName)), patternFileName);
    }

    private void initContext() {
        segmentP = new SegmentP(FieldsLineBlockDefinitions.getSegmentP());
        segmentT = new SegmentT(FieldsLineBlockDefinitions.getSegmentT());
        segmentU = new SegmentU(FieldsLineBlockDefinitions.getSegmentU());
        segmentQ = new SegmentQ(FieldsLineBlockDefinitions.getSegmentQ());

        // Setting dependencies between segments
        segmentP.initDataDependentField(segmentU, segmentT);
        segmentQ.initDataDependentField(segmentT);
        segmentT.initDataDependentField(segmentU);

    }

    private void putHeadersInContents() {
        log.info("Putting Header Files in Content");
        fileOutFile.setHeaderFile();
        fileInFile.setHeaderFile();
    }

    private void putHeadersLoteInContents() {
//        log.info("Putting Header Lotes in Content");
        fileOutFile.setHeaderLote();
        fileInFile.setHeaderLote();
    }

    private void putSegmentsContent() {
        fileOutFile.setSegmentsBlock();
        fileInFile.setSegmentsBlock();
    }

    private void putTrailersLote() {
//        log.info("Putting Trailers Lotes in Content");
        fileOutFile.setTrailerLote();
        fileInFile.setTrailerLote();
    }

    private void putTrailersFile() {
        log.info("Putting Trailers Files in Content");
        fileOutFile.setTrailerFile();
        fileInFile.setTrailerFile();
    }

}
