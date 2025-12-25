package DesighPatterns.ChainOfResponsibility.Logger;

public class ErrorLogger extends Logger {
    public int level;

    public ErrorLogger(int level) {
        super(level);
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error: "+message);
    }
}
