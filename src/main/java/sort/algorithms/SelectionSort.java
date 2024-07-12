package sort.algorithms;

import java.util.List;

public class SelectionSort extends AbstractSort {

    public SelectionSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sortImplementation() {
        for(int i = 0; i < list.size(); i++) {
            int min = list.get(i);
            int minIdx = i;
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(j) < min) {
                    min = list.get(j);
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }
    }

    private void swap(int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
        if(sleep)
            sleepFor(15);
    }
}
