//Same as cyclic_sort/eio_find_all_duplicate_numbers.cpp
/*
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. 
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:
Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

Example 2:
Input: [2, 4, 1, 2]
Output: 3

Example 3:
Input: [2, 3, 2, 1]
Output: 4
*/

// Same as Leetcode M442. Find All Duplicates in an Array
/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

package com.rk.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicateNumbers {
    static void swap(int[] arr, int xx, int yy) {
        int zz = arr[xx];
        arr[xx] = arr[yy];
        arr[yy] = zz;
    }

    static List<Integer> findNumbers(int[] arr) {
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        for (int i = 0; i < arr.length;) {
            int x = arr[i] - 1;
            if (x > 0 && x < arr.length && arr[i] != arr[x]) {
                swap(arr, i, x);
            } else {
                ++i;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != i + 1) {
                duplicateNumbers.add(arr[i]);
            }
        }
        return duplicateNumbers;
    }

    static List<Integer> findNumbers2(int[] arr) {
        int[] count = new int[arr.length];
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            int x = arr[i] - 1;
            if (x > 0 && x < arr.length) {
                count[x] += 1;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (count[i] > 1) {
                duplicateNumbers.add(i + 1);
            }
        }
        return duplicateNumbers;
    }

    static void testrun(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.print(" => ");
        FindAllDuplicateNumbers.findNumbers2(arr).forEach(i -> System.out.print(i + " "));
        System.out.print("|");// keep this first as other approach modifies array
        FindAllDuplicateNumbers.findNumbers(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 4, 4, 5, 5 };
        testrun(arr);

        arr = new int[] { 5, 4, 7, 2, 3, 5, 3 };
        testrun(arr);

        arr = new int[] { 2, 3, 1, 8, 2, 3, 5, 1 };
        testrun(arr);

        arr = new int[] { 2, 4, 1, 2 };
        testrun(arr);

        arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        testrun(arr);

        arr = new int[] { 0 };
        testrun(arr);

        arr = new int[] {};
        testrun(arr);
    }
}
