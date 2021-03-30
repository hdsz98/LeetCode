package com.array;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        for (Integer i : arrayList) {
            System.out.println(i);
            arrayList.add(2);
        }
    }
}
