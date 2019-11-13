package com.rk.algos.stacks;

import java.util.ArrayDeque;

class StackUsingArrayDeque {
    private ArrayDeque<Integer> items;

    public StackUsingArrayDeque() {
        items = new ArrayDeque<Integer>(); // resizes increase in power-of-2 everytime next time, starting with default
                                           // 16, then 32, 64, so on.
                                           // Whereas ArrayList increases 50% each time, starting with default 10, then
                                           // 15, 22, 33 so on.
                                           // Hence ArrayDeque is a better option, plus it gives readymade pop,peek
                                           // functions for stack.
                                           // https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html recommens
                                           // ArrayDeque over Vector based Stack.
    }

    public void push(int val) {
        items.push(val);
    }

    public int top() {
        if (items.isEmpty()) {
            return 0;
        }
        return items.peek();
    }

    public void pop() {
        if (items.isEmpty()) {
            return;
        }
        items.pop();
    }

    public boolean empty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public static void main(String[] args) {
        StackUsingArrayList st = new StackUsingArrayList();

        st.push(5);
        st.push(15);
        st.push(4);

        System.out.println("Top: " + st.top() + ", Size: " + st.size()); // 4, 3
        // assert st.top() == 4 : "false";
        st.pop();

        System.out.println("Top: " + st.top() + ", Size: " + st.size()); // 15, 2
        // assert st.top() == 15 : false;
        st.pop();

        System.out.println("Top: " + st.top() + ", Size: " + st.size()); // 5, 1
        // assert st.top() == 5 : false;
        st.pop();

        System.out.println("Top: " + st.top() + ", Size: " + st.size()); // 0, 0
        // assert st.top() == 0 : false;
        st.pop(); // does nothing
    }
}