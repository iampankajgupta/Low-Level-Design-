package Practice.PenSystem;

public class client {
    public static void main(String[] args) {
        Pen gelPen = PenFactory.createPen(PenType.GEL_PEN, "Reynolds", "gel");
        gelPen.write();
        Pen ballPen = PenFactory.createPen(PenType.BALL_PEN, "Reynolds", "ball");
        ballPen.write();
    }
}
