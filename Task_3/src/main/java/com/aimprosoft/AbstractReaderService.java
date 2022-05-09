package com.aimprosoft;


public abstract class AbstractReaderService<T> implements ReaderService {


    private String filePath;

    abstract T getContent();

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

}

