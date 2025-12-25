package DesighPatterns.Chain;

import LoggingSystem.enums.LogLevel;

public class InfoHandler extends LogHandler{
    // we need to trigger some how to filer




    @Override
    protected boolean canHandle(LogLevel level) {
        if(level == LogLevel.INFO){
            return true;
        }else if(next != null){
            next.canHandle(level);
        }
        return true;
    }

    @Override
    protected void handle(LogMessage logMessage) {

    }
}
