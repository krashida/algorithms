//Same as cyclic_sort/eio_cyclic_sort.cpp
/*
We are given an array containing ‘n’ objects. Each object, when created, was
assigned a unique number from 1 to ‘n’ based on their creation sequence. This
means that the object with sequence number ‘3’ was created just before the
object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number
in O(n)O(n) and without any extra space. For simplicity, let’s assume we are
passed an integer array containing only the sequence numbers, though each number
is actually an object.

Example 1:
Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]

Example 2:
Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]
*/

package com.rk.algos.arrays;

import java.util.Arrays;

public class CyclicSort {
    static void swap(int[] arr, int xx, int yy) {
        int zz = arr[xx];
        arr[xx] = arr[yy];
        arr[yy] = zz;
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length;) {
            int x = arr[i] - 1;
            if (x < arr.length && arr[i] != arr[x]) {
                swap(arr, i, x);
            } else {
                ++i;
            }
        }
    }

    static void testrun(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.print("=> ");
        CyclicSort.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        testrun(arr);

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        testrun(arr);

        arr = new int[] { 2 };
        testrun(arr);

        arr = new int[] {};
        testrun(arr);
    }
}
