package com.aimprosoft;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TxtReaderService extends AbstractReaderService<String> {
    private String content;

    @Override
    public void read() {

        String filePath = getFilePath();
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void printContent() {
        System.out.println(content);
    }

    @Override
    public String getContent() {

        return content;
    }
}

