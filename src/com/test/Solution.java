package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private static List<Integer> list = new ArrayList<>();

    /*
     *  外部会调用这个函数，希望插入list，且保证list里面的内容有序且唯一
     *  如插入 3，1，1，2，希望list里面为：1，2，3
     *  要求：可使用 List 接口里除 sort 外的所有接口
     */
    public static int binaryFind (int target) {
        if (list.size() == 0)
            return 0;
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid =  (left + right) / 2;
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
    public static void addElement(int element) {
        // todo
        if (list.contains(element))
            return;
        list.add(binaryFind(element), element);
    }

    public static void p () {
        for (Integer i : list)
            System.out.print(i + " ");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        addElement(1);
        addElement(2);
        addElement(99);
        p();
        addElement(4);
        p();
        addElement(78);
        p();
    }
}