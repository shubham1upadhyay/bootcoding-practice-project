package com.bootcoding.ipl.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UtilityClass
@Slf4j
public class FileUtility {

    public String inputFile(){
        return new File(Objects.requireNonNull(FileUtility.class.getResource("/data/ipl_matches.csv")).getFile()).getPath();
    }

    @SneakyThrows
    public List<String> readLines(String filePath) {
        Path path = Paths.get(filePath);
        String line = null;
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            log.error("Failed to read file, cause: {}", e.getMessage(), e);
        }
        return lines;
    }
}
