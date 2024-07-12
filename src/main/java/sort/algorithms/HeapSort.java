package sort.algorithms;

import java.util.List;

public class HeapSort extends AbstractSort{

    public HeapSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sortImplementation() {

        int lastIdx = list.size() - 1;
        while(lastIdx != 0) {
            buildMaxHeap(lastIdx);
            swap(0, lastIdx);
            lastIdx -= 1;
        }
    }

    private void buildMaxHeap(int lastIdx) {
        for(int i = 1; i <= lastIdx; i++) {
            swapWithParent(i);
        }
    }

    private void swapWithParent(int i) {
        if(i != 0) {
            int parentIdx = getParentIdx(i);
            if (list.get(i) > list.get(parentIdx)) {
                swap(i, parentIdx);
                swapWithParent(parentIdx);
            }
        }
    }

    private int getParentIdx(int idx) {
        if(idx == 0)
            return 0;
        return (idx - 1) / 2;
    }

    private int numCellsBeforeRow(int row) {
        if(row == 0) {
            return 0;
        }
        if(row == 1) {
            return 1;
        }

        return numCellsBeforeRow(row - 1) + (int)Math.pow(2, row - 1);
    }

    private void swap(int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
        if(sleep)
            sleepFor(0.01);
    }

}
