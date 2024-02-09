package com.personal.helpers;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@UtilityClass
public class FileWriterHelper {

    public static File generateFile(String fileName, List<String> content) {
        log.info("Generating file: {}", fileName);
        File newFile = new File(fileName);
        try(FileOutputStream fos = new FileOutputStream(newFile)) {
            content.stream().forEach(line -> {
                try {
                    fos.write(line.getBytes());
                    fos.write("\n".getBytes());
                } catch (Exception e) {
                    log.error("Error writing line: {}", line, e);
                }
            });
            fos.flush();
        } catch (Exception e) {
            log.error("Error generating file: {}", fileName, e);
        } finally {
            log.info("Finished generating file: {}", fileName);
        }
        return new File(fileName);
    }
    public static File zipFiles(List<File> files, String patternFileName) throws IOException {
        String zipFileName = "%s.zip".formatted(patternFileName);
        log.info("Generating zip file: {}", zipFileName);
        File zipFile = new File(zipFileName);

        try (
                FileOutputStream outputStream = new FileOutputStream(zipFile);
                ZipOutputStream zipOut = new ZipOutputStream(outputStream)
        ){
            for (File fileToZip : files) {
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                try (FileInputStream inputStream = new FileInputStream(fileToZip)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, bytesRead);
                    }
                }
                zipOut.closeEntry();
            }
        } catch (Exception e) {
            log.error("Error generating zip file: {}", zipFileName, e);
        } finally {
            log.info("Finished generating zip file: {}", zipFileName);
        }
        return zipFile;
    }
}
