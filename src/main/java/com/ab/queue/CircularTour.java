package com.ab.queue;

import com.ab.queue.impl.CircularQueue;

/**
 * @author Arpit Bhardwaj
 */
public class CircularTour {
    static class PetrolPump{
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "PetrolPump{" +
                    "petrol=" + petrol +
                    ", distance=" + distance +
                    '}';
        }
    }
    public static void main(String[] args) {
        PetrolPump[] petrolPumpArr = {  new PetrolPump(6, 4),
                                        new PetrolPump(3, 6),
                                        new PetrolPump(7, 3)
        };

        int startPoint = getTourStartPoint(petrolPumpArr);
        System.out.println(startPoint == -1 ? "No Solution" : startPoint);
    }

    private static int getTourStartPoint(PetrolPump[] petrolPumpArr) {
        CircularQueue<PetrolPump> queue = new CircularQueue<>();

        if(petrolPumpArr.length < 0){
            throw new IllegalArgumentException("Empty Tour");
        }
        int currPetrol = petrolPumpArr[0].petrol - petrolPumpArr[0].distance;
        queue.enQueue(petrolPumpArr[0]);
        int j = 1;
        for (; j < petrolPumpArr.length; j++) {
            while (currPetrol < 0){
                PetrolPump petrolPump = queue.deQueue();
                currPetrol -= petrolPump.petrol - petrolPump.distance;
                System.out.println("Dequeue");

            }
            currPetrol += petrolPumpArr[j].petrol - petrolPumpArr[j].distance;
            queue.enQueue(petrolPumpArr[j]);
            System.out.println("Equeue");
        }
        queue.printCircularQueue();
        if (queue.front.data == petrolPumpArr[0]){
            return -1;
        }
        return --j;
    }
}
