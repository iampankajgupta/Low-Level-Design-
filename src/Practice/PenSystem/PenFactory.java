package Practice.PenSystem;

public class PenFactory {
    public static Pen createPen(PenType penType, String brand, String color) {
        // can also use switch
        if(penType.equals(PenType.GEL_PEN)) {
            return new GelPen(brand, color);
        }else if(penType.equals(PenType.BALL_PEN)) {
            return new BallPen(brand, color);
        }
        // return null; avoid returning null throw exception good practice
        throw new IllegalArgumentException("Invalid pen type");
    }
}
