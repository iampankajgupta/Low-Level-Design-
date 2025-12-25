package Practice.PenSystem;

public class GelPen extends Pen{

    public GelPen(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void write() {
        System.out.println("Writing softly with Gel Pen");
    }
}
