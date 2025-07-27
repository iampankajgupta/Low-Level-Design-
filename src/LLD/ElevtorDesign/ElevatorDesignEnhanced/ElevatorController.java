package LLD.ElevtorDesign.ElevatorDesignEnhanced;

import LLD.ElevtorDesign.Direction;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorController {

    private Elevator elevator;
    // Implementing the LOOK Algorithm Using Two Priority Queue
    // Main idee

    // while moving upward direction it will keep the all the element and fulfill the request
    private PriorityQueue<Integer> minHeap = new PriorityQueue();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());


    public void submitRequest(int floor, Direction direction) {
        if(direction.equals(Direction.UP)) {
            minHeap.add(floor);
        }else {
            maxHeap.add(floor);
        }
        

    }

    public void controlCar() throws InterruptedException {
        if(!elevator.isFixed()) {
            if (!minHeap.isEmpty() && minHeap.peek() == elevator.getFloor() || maxHeap.peek().equals(elevator.getFloor())) {
                System.out.println("Fullfilling request of floor number" + minHeap.peek());
                minHeap.poll();
                Thread.sleep(1000);
                elevator.setFloor(elevator.getFloor() + 2);
            }else if(!maxHeap.isEmpty() && maxHeap.peek() == elevator.getFloor()) {
                System.out.println("Fullfilling request of floor number" + minHeap.peek());
                maxHeap.poll();
                Thread.sleep(1000);
                elevator.setFloor(elevator.getFloor() + 2);
            }
        }else {
            if (!minHeap.isEmpty() && minHeap.peek() == elevator.getFloor() || maxHeap.peek().equals(elevator.getFloor())) {
                System.out.println("Fullfilling request of floor number" + maxHeap.peek());
                minHeap.poll();
                Thread.sleep(1000);
            }else if(!maxHeap.isEmpty() && maxHeap.peek() == elevator.getFloor()) {
                System.out.println("Fullfilling request of floor number" + maxHeap.peek());
                maxHeap.poll();
                Thread.sleep(1000);
            }
            elevator.setFloor(elevator.getFloor() + 1);
        }
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public PriorityQueue getMinHeap() {
        return minHeap;
    }

    public void setMinHeap(PriorityQueue minHeap) {
        this.minHeap = minHeap;
    }

    public PriorityQueue getMaxHeap() {
        return maxHeap;
    }

    public void setMaxHeap(PriorityQueue maxHeap) {
        this.maxHeap = maxHeap;
    }
}
