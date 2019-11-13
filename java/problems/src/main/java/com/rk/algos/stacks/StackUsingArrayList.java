package com.rk.algos.stacks;

import java.util.ArrayList;

// This is just for practise, better to use Stack based on an ArrayDeque
class StackUsingArrayList {
    private ArrayList<Integer> items;

    public StackUsingArrayList() {
        items = new ArrayList<Integer>(); // resizes increase in 50% next time, starting with default 10, then 15, 22,
                                          // so on.
    }

    public void push(int val) {
        items.add(val);
    }

    public int top() {
        if (items.isEmpty()) {
            return 0;
        }
        return items.get(items.size() - 1);
    }

    public void pop() {
        if (items.isEmpty()) {
            return;
        }
        items.remove(items.size() - 1);
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