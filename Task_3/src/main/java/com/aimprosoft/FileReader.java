package com.aimprosoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the path of the file");
        String path = reader.readLine();
        String extension = Utils.getFileExtension(path);

        ReaderService readerService = null;
        if ("txt".equals(extension)) {
            readerService = new TxtReaderService();
        } else if ("json".equals(extension)) {
            readerService = new JsonReaderService();
        }

        if (readerService != null) {
            readerService.setFilePath(path);
            readerService.read();
            readerService.printContent();
        } else {
            System.out.println("Unknown extension");
        }

    }
}
