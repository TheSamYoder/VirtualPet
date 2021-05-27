package virtual_pet;

import java.util.Comparator;

public class StatSorter implements Comparator<Stats> {
    @Override
    public int compare(Stats o1, Stats o2) {
        if (o2.compareVal > o1.compareVal) {
            return -1;
        } else {
            return 1;
        }
    }


}

