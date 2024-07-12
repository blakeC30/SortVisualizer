package sort.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class QuickSort extends AbstractSort {

    public QuickSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sortImplementation() {
        quickSortHelper(0, list.size());
    }

    private void quickSortHelper(int startIdx, int endIdx) {
        if(startIdx >= endIdx)
            return;
        int pivotIdx = pickPivot(startIdx, endIdx);
        int pivotNum = list.get(pivotIdx);
        swap(pivotIdx, endIdx - 1);

        boolean stop = false;
        while(!stop) {
            int itemFromLeftIdx = getItemFromLeft(startIdx, endIdx, pivotNum);
            int itemFromRightIdx = getItemFromRight(startIdx, endIdx, pivotNum);

            if(itemFromLeftIdx > itemFromRightIdx) {
                stop = true;
                swap(endIdx - 1, itemFromLeftIdx);
                pivotIdx = itemFromLeftIdx;
            }
            else
                swap(itemFromLeftIdx, itemFromRightIdx);
        }

        quickSortHelper(startIdx, pivotIdx);
        quickSortHelper(pivotIdx + 1, endIdx);

    }

    private int getItemFromLeft(int startIdx, int endIdx, int pivotNum) {
        for(int i = startIdx; i < endIdx - 1; i++) {
            if(list.get(i) >= pivotNum) {
                return i;
            }
        }
        return endIdx - 1;
    }

    private int getItemFromRight(int startIdx, int endIdx, int pivotNum) {
        for(int i = endIdx - 1; i >= startIdx; i--) {
            if(list.get(i) < pivotNum) {
                return i;
            }
        }
        return startIdx - 1;
    }

    private int pickPivot(int startIdx, int endIdx) {
        if(endIdx - startIdx >= 3){
            int pivotIdx = ((endIdx - startIdx) / 2) + startIdx;
            Integer middle = list.get(pivotIdx);
            List<Integer> lst = List.of(list.get(startIdx), middle, list.get(endIdx - 1));
            Integer min = Collections.min(lst);
            Integer max = Collections.max(lst);
            Integer mid = -1;
            for(int i = 0; i < 3; i++) {
                if(!Objects.equals(lst.get(i), min) && !Objects.equals(lst.get(i), max))
                    mid = lst.get(i);
            }

            list.set(startIdx, min);
            list.set(pivotIdx, mid);
            list.set(endIdx - 1, max);
            return pivotIdx;
        }
        else {
            int size = endIdx - startIdx;
            return ((int) (Math.random() * size)) + startIdx;
        }
    }

    private void swap(int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
        sleepFor(1);
    }
}
