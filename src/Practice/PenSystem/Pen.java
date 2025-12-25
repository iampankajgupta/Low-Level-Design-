package Practice.PenSystem;

public abstract class Pen {
    protected String brand;
    protected String color;

    public Pen(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public abstract void write();

}
