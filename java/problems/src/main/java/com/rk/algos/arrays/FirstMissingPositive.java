package com.rk.algos.arrays;

/*
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4. Given A = [−1, −3], the
 * function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 */
// cyclic_sort/eio_pc2_find_smallest_missing_positive_number.cpp
// Leetcode H41. First Missing Positive

class FirstMissingPositiveNumber {
    protected void swap(int[] A, int x, int y) {
        int zz = A[x];
        A[x] = A[y];
        A[y] = zz;
    }

    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        for (int i = 0; i < A.length;) {
            int x = A[i] - 1;
            if (A[i] > 0 && x < A.length && A[i] != A[x]) {
                swap(A, i, x);
            } else {
                ++i;
            }
        }

        for (int i = 0; i < A.length; ++i) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A[A.length - 1] + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositiveNumber s = new FirstMissingPositiveNumber();
        int[] a = { 1, 3, 6, 4, 1, 2 };
        System.out.println(s.solution(a));
        int[] a2 = { 1, 2, 3 };
        System.out.println(s.solution(a2));
        int[] a3 = { -1, -3 };
        System.out.println(s.solution(a3));
        return;
    }
}