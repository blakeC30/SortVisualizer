package sort.algorithms;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSort {
    protected List<Integer> list;
    protected List<Integer> listForTime;
    private boolean completed;
    protected boolean sleep;


    public AbstractSort(List<Integer> list) {
        this.sleep = true;
        this.list = list;
        this.listForTime = new ArrayList<>(list);
        completed = false;
    }

    public void sort() {
        if(!completed) {
            sortImplementation();
            List<Integer> temp = list;
            this.list = listForTime;
            this.sleep = false;
            long startTime = System.nanoTime();
            sortImplementation();
            long endTime = System.nanoTime();
            System.out.println("Time elapsed: " + ((double)(endTime - startTime) / 1000000.0) + " ms");
            this.list = temp;
            this.sleep = true;
            completed = true;
        }

    }

    protected void sleepFor(double milliseconds) {
        long nanoseconds = (long) (milliseconds * 1000000);
        long timeElapsed;
        final long startTime = System.nanoTime();
        do {
            timeElapsed = System.nanoTime() - startTime;
        } while(timeElapsed < nanoseconds);
    }

    public abstract void sortImplementation();

    public boolean sorted() {
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }
}
