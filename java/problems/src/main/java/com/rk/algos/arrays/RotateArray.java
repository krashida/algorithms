package com.rk.algos.arrays;

import java.util.*;

class GFG {

    public void reverse(int[] arr, int start, int end) {
        for (int i = start, j = end; i < j; ++i, --j) {
            int xx = arr[i];
            arr[i] = arr[j];
            arr[j] = xx;
        }
    }

    public void rotate(int[] arr, int K) {
        if (arr == null || arr.length == 0 || K < 1) {
            return;
        }
        // if (K > arr.length) {
        // K -= arr.length;
        // }
        reverse(arr, 0, K - 1);
        reverse(arr, K, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        GFG gfg = new GFG();

        // Scanner ins = new Scanner(System.in);
        // int tcCount = ins.nextInt();
        // for (int i = 0; i < tcCount; ++i) {
        // int arrLen = ins.nextInt();
        // int K = ins.nextInt();
        // ArrayList<Integer> arr = new ArrayList<>();
        // for (int j = 0; j < arrLen; ++j) {
        // arr.add(ins.nextInt());
        // }
        // gfg.rotate(arr, K);
        // }
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int[] arr = new int[] { 1, 2, 3, 4 };
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.print("=> ");
        gfg.rotate(arr, 2);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}