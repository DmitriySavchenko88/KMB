package com.aimprosoft;


import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class JsonReaderService extends AbstractReaderService<JSONObject> {
    private JSONObject content;

    @Override
    public void read() throws IOException {
        String fileName = getFilePath();
        String fileContent = Files.lines(Paths.get(fileName)).collect(Collectors.joining(System.lineSeparator()));
        content = new JSONObject(fileContent);
    }

    @Override
    public void printContent() {
        System.out.println(content);

    }

    private JSONObject createJSONObject(String jsonString){
        return new JSONObject(jsonString);
    }

    @Override
    JSONObject getContent() {

        return content;
    }
}
