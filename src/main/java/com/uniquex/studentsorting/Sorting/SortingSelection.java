package com.uniquex.studentsorting.Sorting;

public enum SortingSelection {
    BubbleSort
            {
                @Override
                public ISort selectSort()
                {
                    return new BubbleSort();
                }
            },
    HeapSort
            {
                @Override
                public ISort selectSort()
                {
                    return new MergeSort();
                }
            },
    MergeSort
            {
                @Override
                public ISort selectSort()
                {
                    return new HeapSort();
                }
            };

    public abstract ISort selectSort();
}
