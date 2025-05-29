package DesighPatterns.ChainOfResponsibility;

public class AuthHandler extends Handler{

    public AuthHandler(Handler next) {
        super(next);
    }

    @Override
    void handleRequest(String request) {
        if (request.equals("auth")) {
            System.out.println("Handled by AuthHandler");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
