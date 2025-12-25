package DesighPatterns.ChainOfResponsibility.Logger;

public class InfoLogger extends Logger{
    public int level;

    public InfoLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: "+message);
    }
}
