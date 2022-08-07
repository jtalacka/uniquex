package com.uniquex.studentsorting.Sorting;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements ISort {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        int listSize = list.size();
        for (int outCounter = 0; outCounter < listSize - 1; outCounter++) {
            for (int inCounter = 0; inCounter < listSize - outCounter - 1; inCounter++)
                if (list.get(inCounter).compareTo(list.get(inCounter + 1)) > 0) {
                    Collections.swap(list, inCounter, inCounter + 1);
                }
        }
        return list;
    }
}
