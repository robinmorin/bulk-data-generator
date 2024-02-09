package com.personal.api;

import com.personal.config.BankDataExternalDefinition;
import com.personal.config.PropertiesExternalConfigurations;
import com.personal.helpers.RequestContextHolderHelper;
import com.personal.output_files.ProcessHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Slf4j
@RestController
@Tag(name = "Output", description = "Output file generation")
@RequiredArgsConstructor
public class OutputController {

    private final ProcessHandler handler;
    private final PropertiesExternalConfigurations.Manager manager;

    @Operation(summary = "Get fileOut/fileIn file", responses = @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/octet-stream")))
    @GetMapping(value ="/generator/{identification}/{patternFilename}")
    @Parameter(name = "identification", description = "Identification of bank (CNPJ) only numbers")
    @Parameter(name = "patternFilename", description = "Pattern filename to generate fileOut/fileIn file")
    @Parameter(name = "qtaRecords", description = "Quantity of records to generate")
    @Parameter(name = "qtaRecordsLote", description = "Quantity of records by lote to generate")
    public ResponseEntity<byte[]> generateFilesCNAB(@PathVariable("identification") String identification,
                                                    @PathVariable("patternFilename") String patternFilename,
                                                    @RequestParam(value = "qtaRecords", defaultValue = "100000") Integer qtaRecords,
                                                    @RequestParam(value = "qtaRecordsLote", defaultValue = "9999") Integer qtaRecordsLote) throws IOException {
        log.info("Received parameters: patternFilename: {}, identification: {}, qtaRecords: {}, qtaRecordsLote: {}", patternFilename, identification, qtaRecords, qtaRecordsLote);
        BankDataExternalDefinition.Convenio convenio = Optional.of(identification)
                                                                    .map(manager::getBankDataExternalDefinition)
                                                                    .orElseThrow(()-> new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Identification value not exists or BankDataExternalDefinition is empty!!"));
        if(qtaRecordsLote > 9999){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Quantity of records by lote is greater than allowed!!");
        }
        RequestContextHolderHelper.setAttribute("convenio", convenio);
        RequestContextHolderHelper.setAttribute("qtaRecords", qtaRecords);
        RequestContextHolderHelper.setAttribute("qtaRecordsLote", qtaRecordsLote);

        File fileZip = handler.generateFiles(patternFilename);

        long contentLength = fileZip.length();

        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        respHeaders.setContentLength(contentLength);
        respHeaders.setContentDispositionFormData("attachment", fileZip.getName());

        byte[] content = Files.readAllBytes(fileZip.toPath());

        log.info("Returning file: {}. Ready to download", fileZip.getName());
        return new ResponseEntity<>(content, respHeaders, HttpStatus.OK);
    }
}
