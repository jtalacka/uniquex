package com.uniquex.studentsorting.Sorting;

import java.util.List;

public interface ISort {

    public <T extends Comparable<T>> List<T> sort(List<T> list);
}
