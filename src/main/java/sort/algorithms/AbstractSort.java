package sort.algorithms;

import java.util.List;

public abstract class AbstractSort {
    public List<Integer> list;
    private boolean inProgress;

    public AbstractSort(List<Integer> list) {
        this.list = list;
        inProgress = false;
    }

    public void sort() {
        if(!inProgress) {
            inProgress = true;
            sortImplementation();
            inProgress = false;
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
