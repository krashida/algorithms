//Same as cyclic_sort/eio_find_duplicate_number.cpp
/*
We are given an unsorted array containing ‘n+1’ numbers taken from the range 1
to ‘n’. The array has only one duplicate but it can be repeated multiple times.
Find that duplicate number without using any extra space.
**You are, however, allowed to modify the input array.**

Example 1:
Input: [1, 4, 4, 3, 2]
Output: 4

Example 2:
Input: [2, 1, 3, 3, 5, 4]
Output: 3

Example 3:
Input: [2, 4, 1, 4, 4]
Output: 4
*/

// Same as Leetcode M287 Find the Duplicate Number
/*Given an array nums containing n + 1 integers where each integer is between 1
  and n (inclusive), prove that at least one duplicate number must exist. Assume
  that there is only one duplicate number, find the duplicate one.

  Example 1:
  Input: [1,3,4,2,2]
  Output: 2

  Example 2:
  Input: [3,1,3,4,2]
  Output: 3
  Note:

  You must not modify the array (assume the array is read only).
  You must use only constant, O(1) extra space.
  Your runtime complexity should be less than O(n2).
  There is only one duplicate number in the array, but it could be repeated more
  than once.
 */

package com.rk.algos.arrays;

import java.util.Arrays;
import java.util.TreeMap;

public class FindDuplicateNumber {
    static void swap(int[] arr, int xx, int yy) {
        int zz = arr[xx];
        arr[xx] = arr[yy];
        arr[yy] = zz;
    }

    static int findNumber(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }

        if (arr.length == 2) {
            return (arr[0] == arr[1] ? arr[0] : -1);
        }

        for (int i = 0; i < arr.length;) {
            if (arr[i] != i + 1) {
                int x = arr[i] - 1;
                if (x < arr.length && arr[i] != arr[x]) {
                    swap(arr, i, x);
                } else {
                    return arr[i];
                }
            } else {
                ++i;
            }
        }
        return -1;
    }

    static int findNumber2(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        if (arr.length == 2) {
            return (arr[0] == arr[1] ? arr[0] : -1);
        }

        int slow = 0, fast = 0;
        do {
            if (arr[slow] < arr.length && arr[fast] < arr.length) {
                slow = arr[slow];
                fast = arr[arr[fast]];
            } else {
                return -1; // no duplicates
            }
        } while (slow != fast);

        int current = slow;
        do {
            current = arr[current];
        } while (current != slow && current < arr.length);

        if (current >= arr.length) {
            return -1; // no duplicates
        }
        current = arr[current];
        slow = arr[0];
        while (slow != current) {
            current = arr[current];
            slow = arr[slow];
        }
        return current;
    }

    /*
     * Given an array a that contains only numbers in the range from 1 to a.length,
     * find the first duplicate number for which the second occurrence has the
     * minimal index. In other words, if there are more than 1 duplicated numbers,
     * return the number for which the second occurrence has a smaller index than
     * the second occurrence of the other number does. If there are no such
     * elements, return -1.
     * 
     * Example For a = [2, 1, 3, 5, 3, 2], the output should be firstDuplicate(a) =
     * 3. There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a
     * smaller index than the second occurrence of 2 does, so the answer is 3.
     * 
     * For a = [2, 2], the output should be firstDuplicate(a) = 2; For a = [2, 4, 3,
     * 5, 1], the output should be firstDuplicate(a) = -1.
     * 
     * Input/Output [execution time limit] 0.5 seconds (cpp) [input] array.integer a
     * Guaranteed constraints: 1 ≤ a.length ≤ 105, 1 ≤ a[i] ≤ a.length.
     * 
     * [output] integer
     * 
     * The element in a that occurs in the array more than once and has the minimal
     * index for its second occurrence. If there are no such elements, return -1.
     */
    static int firstDuplicate(int[] arr) {
        TreeMap<Integer, Integer> dupIndex = new TreeMap<>();

        for (int i = 0; i < arr.length; ++i) {
            int x = Math.abs(arr[i]) - 1;
            if (arr[x] < 0) {
                dupIndex.put(i, x + 1);
            } else {
                arr[x] = -1 * arr[x];
            }
        }
        if (dupIndex.isEmpty()) {
            return -1;
        }
        return dupIndex.firstEntry().getValue();
    }

    static void testrun(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.print("=> ");
        System.out.print(FindDuplicateNumber.findNumber2(arr) + ", ");// keep this first as other approach modifies
                                                                      // array
        System.out.print(FindDuplicateNumber.findNumber(arr) + ", ");
        System.out.println(FindDuplicateNumber.firstDuplicate(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 4, 3, 2 };
        testrun(arr);

        arr = new int[] { 2, 1, 3, 3, 5, 4 };
        testrun(arr);

        arr = new int[] { 2, 1, 3, 5, 3, 2 };
        testrun(arr);

        arr = new int[] { 2, 1, 2, 2, 4, 4, 2, 2 };
        testrun(arr);

        arr = new int[] { 2, 1, 4, 2, 4, 4, 2, 2 };
        testrun(arr);

        arr = new int[] { 2, 4, 1, 4, 4 };
        testrun(arr);

        arr = new int[] { 2, 1 };
        testrun(arr);

        arr = new int[] { 2, 1, 3 };
        testrun(arr);

        arr = new int[] { 2, 1, 4, 3 };
        testrun(arr);

        arr = new int[] { 1 };
        testrun(arr);

        arr = new int[] {};
        testrun(arr);
    }
}
