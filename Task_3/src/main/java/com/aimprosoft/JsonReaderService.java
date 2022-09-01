package com.aimprosoft;

import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class JsonReaderService extends AbstractReaderService<JSONObject> {
    private JSONObject content;

    @Override
    public void read() {
        String filePath = getFilePath();
        String fileContent = null;
        try {
            fileContent = Files.lines(Paths.get(filePath)).collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        content = new JSONObject(fileContent);
    }

    @Override
    public void printContent() {
        System.out.println(content);

    }

    private JSONObject createJSONObject(String jsonString) {
        return new JSONObject(jsonString);
    }

    @Override
    public JSONObject getContent() {

        return content;
    }
}
