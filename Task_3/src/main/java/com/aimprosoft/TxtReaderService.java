package com.aimprosoft;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TxtReaderService extends AbstractReaderService<String> {
    private String content;

    @Override
    public void read() throws IOException {
        String fileName = getFilePath();
        content = Files.lines(Paths.get(fileName)).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public void printContent() {
        System.out.println(content);
    }

    @Override
    String getContent() {

        return content ;
    }
}

