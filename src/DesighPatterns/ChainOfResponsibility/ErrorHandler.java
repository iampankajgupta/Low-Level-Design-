package DesighPatterns.ChainOfResponsibility;

public class ErrorHandler extends Handler{

    public ErrorHandler(Handler next) {
        super(next);
    }

    @Override
    void handleRequest(String request) {
        next.handleRequest(request);
    }
}
