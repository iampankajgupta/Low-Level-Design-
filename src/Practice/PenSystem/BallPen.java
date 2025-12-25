package Practice.PenSystem;

public class BallPen extends Pen{
    public BallPen(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void write() {
        System.out.println("Writing smoothly with Ball Pen");
    }
}
