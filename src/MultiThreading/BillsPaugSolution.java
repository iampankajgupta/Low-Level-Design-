package MultiThreading;

public class BillsPaugSolution {

    private static class Holder{
        private static final BillsPaugSolution INSTANCE = new BillsPaugSolution();
    }

    public static BillsPaugSolution getInstance() {
        return Holder.INSTANCE;
    }
}
