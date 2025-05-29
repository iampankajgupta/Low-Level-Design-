package LoggingSystem.enums;

import java.io.PipedReader;

public enum LogLevel {
    DEBUG(3),INFO(2), ERROR(1);

    public final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Method to compare log levels based on severity
    public boolean isGreaterOrEqual(LogLevel other) {
        return this.value >= other.value;
    }
}

/*

*
* */

/*
* Log
* timestamp
* level
* message
*
* processLog(config, message)
*
*
* Chain of responsibility
* LogHandler - handleRequest(Config, String mesagg)
* InfoHandler
* ErrorHandler
* FatalHandler
* DebugHandler
*
* Enum
* DataSource
* Log
* Csv
* console
* database
*
* Config
* String logLevel;
* String outDestination
*
*
*
*
*
*
*
*
*
*
*
*
*
* */