package DesighPatterns.ChainOfResponsibility;

public abstract class Handler {
    protected Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    abstract void handleRequest(String request);
}
