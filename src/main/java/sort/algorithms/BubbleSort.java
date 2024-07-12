package sort.algorithms;

import java.util.List;

public class BubbleSort extends AbstractSort {

    public BubbleSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sortImplementation() {
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for(int i = 0; i < list.size() - 1; i++){
                if(list.get(i) > list.get(i + 1)) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
        if(sleep)
            sleepFor(0.005);
    }
}
