package DesighPatterns.ChainOfResponsibility;

public class LogHandler extends Handler{

    public LogHandler(Handler next) {
        super(next);
    }

    @Override
    void handleRequest(String request) {
        if (request.equals("log")) {
            System.out.println("Handled by Log Handler");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
