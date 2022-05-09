package com.aimprosoft;

import java.io.IOException;

public interface ReaderService {
    void read() throws IOException;
    void printContent();
    void setFilePath(String filePath);
}
