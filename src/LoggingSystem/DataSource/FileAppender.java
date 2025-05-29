package LoggingSystem.DataSource;

import LoggingSystem.LogMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAppender implements IDataSource {

//    private List<LogMessage> logMessageList = new ArrayList<>();
    List<LogMessage> logMessageList = new ArrayList<>();
    private final String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean processLog(LogMessage logMessage) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage.toString() + "n"); // Write log to file
        } catch (IOException e) {
            e.printStackTrace(); // Print error if file writing fails
        }

        logMessageList.add(logMessage);
        return false;
    }

    @Override
    public List<LogMessage> exportLogs() {
        return logMessageList;
    }

    @Override
    public boolean clear() {
        try {
            logMessageList.clear();
        }catch (Exception e) {
            throw new RuntimeException();
        }
        return true;
    }
}
