package DesighPatterns.Chain;

public class ConsoleAppender implements Appender {
    @Override
    public void append(LogMessage logMessage) {
        System.out.println("Writing a message in a console: "+logMessage);
    }
}
