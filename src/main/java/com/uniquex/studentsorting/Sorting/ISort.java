package com.uniquex.studentsorting.Sorting;

import com.uniquex.studentsorting.Model.UserData;

import java.util.List;

public interface ISort{

    public <T extends Comparable<T>> List<T> sort(List<T> list);
}
