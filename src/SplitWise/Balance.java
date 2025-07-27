package SplitWise;

public class Balance {
    private double owe;
    private double get;

    public Balance(double owe, double get) {
        this.owe = owe;
        this.get = get;
    }

    public double getOwe() {
        return owe;
    }

    public void setOwe(double owe) {
        this.owe = owe;
    }

    public double getGet() {
        return get;
    }

    public void setGet(double get) {
        this.get = get;
    }
}
