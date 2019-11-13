//Same as cyclic_sort/eio_find_the_missing_number.cpp
/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. 
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2
Example 2:


Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
*/

// Same as Leetcode E268. Missing Number

package com.rk.algos.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMissingNumber {
    static void swap(int[] arr, int xx, int yy) {
        int zz = arr[xx];
        arr[xx] = arr[yy];
        arr[yy] = zz;
    }

    static int findMissingNumber(int[] arr) {
        for (int i = 0; i < arr.length;) {
            int x = arr[i];
            if (x < arr.length && arr[i] != arr[x]) {
                swap(arr, i, x);
            } else {
                ++i;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != i) {
                return i;
            }
        }
        return arr.length;
    }

    static int findMissingNumber2(int[] arr) {
        int sum = IntStream.of(arr).sum();
        int nsum = arr.length * (arr.length + 1) / 2;
        return nsum - sum;
    }

    static int findMissingNumber3(int[] arr) {
        int res = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            res = res ^ i;
            res = res ^ arr[i];
        }
        return res;
    }

    static void testrun(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.print("=> ");
        System.out.print(FindMissingNumber.findMissingNumber(arr) + ", ");
        System.out.print(FindMissingNumber.findMissingNumber2(arr) + ", ");
        System.out.println(FindMissingNumber.findMissingNumber3(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 0, 3, 1 };
        testrun(arr);

        arr = new int[] { 8, 3, 5, 2, 4, 6, 0, 1 };
        testrun(arr);

        arr = new int[] { 3, 0, 1 };
        testrun(arr);

        arr = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        testrun(arr);

        arr = new int[] { 0 };
        testrun(arr);

        arr = new int[] {};
        testrun(arr);
    }
}
