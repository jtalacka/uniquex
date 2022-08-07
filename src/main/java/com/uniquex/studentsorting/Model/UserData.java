package com.uniquex.studentsorting.Model;

import java.util.Comparator;

public class UserData implements Comparable<UserData> {
    private String name;
    private double data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    @Override
    public int compareTo(UserData userData) {
        return Double.compare(this.data, userData.getData());
    }
    public String toString()
    {
        return name+","+data;
    }
}
