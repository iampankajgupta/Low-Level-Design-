package DesighPatterns.ChainOfResponsibility;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        Handler authHandler = new AuthHandler(new LogHandler(new ErrorHandler(null)));
        authHandler.handleRequest("log");
    }

}
