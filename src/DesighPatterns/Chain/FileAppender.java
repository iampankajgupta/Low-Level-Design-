package DesighPatterns.Chain;

public class FileAppender implements Appender{

    private String filePath;
    private String fileName;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println("Writing a log into a file: "+filePath);
    }
}
