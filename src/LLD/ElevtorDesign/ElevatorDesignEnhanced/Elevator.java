package LLD.ElevtorDesign.ElevatorDesignEnhanced;

import LLD.ElevtorDesign.Direction;
import LLD.ElevtorDesign.Request;
import LLD.ElevtorDesign.Status;

import java.util.List;

public class Elevator {
    private String id;
    private int floor;
    private Direction direction;
    private long weight;
    private int maxPerson;
    private Display display;
    private boolean isOdd;
    private boolean isFixed = false;
    private Pair pair;
    private int maxFloor = 10;


//    private List<Request> requests; removed and kept this as dumb object
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public boolean isOdd() {
        return isOdd;
    }

    public void setOdd(boolean odd) {
        isOdd = odd;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }
}
class Pair{
    int start;
    int last;

    public Pair(int start, int last) {
        this.start = start;
        this.last = last;
    }
}