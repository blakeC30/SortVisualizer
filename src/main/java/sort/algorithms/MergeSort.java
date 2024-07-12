package sort.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort extends AbstractSort{

    public MergeSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sortImplementation() {
        mergeSortHelper(0, list.size());
    }

    private void mergeSortHelper(int startIdx, int endIdx) {
        int size = endIdx - startIdx;
        if(size == 1)
            return;
        int middle = startIdx + (size / 2);
        mergeSortHelper(startIdx, middle);
        mergeSortHelper(middle, endIdx);
        merge(startIdx, middle, endIdx);

    }

    private void merge(int startIdx, int middle, int endIdx) {
        int idx1 = startIdx;
        int idx2 = middle;
        List<Integer> result = new ArrayList<>();
        while(idx1 < middle || idx2 < endIdx) {
            if(idx1 == middle) {
                result.add(list.get(idx2));
                idx2++;
            }
            else if (idx2 == endIdx) {
                result.add(list.get(idx1));
                idx1++;
            }
            else if(list.get(idx1) < list.get(idx2)){
                result.add(list.get(idx1));
                idx1++;
            }
            else {
                result.add(list.get(idx2));
                idx2++;
            }
        }

        for(int i = startIdx; i < endIdx; i++) {
            list.set(i, result.get(i - startIdx));
        }
        sleepFor(10);
    }
}
