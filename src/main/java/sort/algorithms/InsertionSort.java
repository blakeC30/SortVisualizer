package sort.algorithms;

import java.util.List;

public class InsertionSort extends AbstractSort{

    public InsertionSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sortImplementation() {
        for(int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            int idx = i - 1;
            boolean added = false;
            while(idx >= 0 && !added) {
                if(num >= list.get(idx)) {
                    list.remove(i);
                    list.add(idx + 1, num);
                    added = true;
                    if(sleep)
                        sleepFor(15);
                }
                idx--;
            }
            if(!added) {
                list.remove(i);
                list.addFirst(num);
                if(sleep)
                    sleepFor(15);
            }
        }
    }
}
