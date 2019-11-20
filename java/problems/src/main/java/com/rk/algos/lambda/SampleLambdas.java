package com.rk.algos.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

/**
 * Hello world!
 *
 */
public class SampleLambdas {
    // () -> {}
    public static void main(String[] args) {

        // Predicate<T>: T -> boolean
        // Takes an input of type T and returns boolean value based on test() performed.
        Predicate<String> slen = (s) -> s.length() > 10;
        System.out.println("String \"Hello World!!\" is larger than 10 chars: " + slen.test("Hello World!!"));
        System.out.println("String \"Hello!!\" is larger than 10 chars: " + slen.test("Hello!!"));

        IntPredicate evenCheck = (int x) -> x % 2 == 0;
        System.out.println("5 is even: " + evenCheck.test(5));
        System.out.println("10 is even: " + evenCheck.test(10));

        // BiPredicate<L, R>: (L, R) -> boolean
        // Takes two inputs of types L and R and returns boolean value based on test()
        // performed.

        BiPredicate<String, Integer> hugeSize = (s, sz) -> s.length() > sz;
        System.out.println("String \"hello\" is larger than 5 chars: " + hugeSize.test("hello", 5));
        System.out.println("String \"Netherlands\" is larger than 5 chars: " + hugeSize.test("Netherlands", 5));

        // Consumer<T>: T -> void
        // Takes an input of type T and accept()/consumes it. Consumer does not return
        // anything.
        IntConsumer printSquare = (x) -> System.out.println(x + " => " + x * x);
        printSquare.accept(5);
        printSquare.accept(10);

        Consumer<String> printLower = (s) -> System.out.println(s.toLowerCase());
        printLower.accept("Hello World");
        printLower.accept("ABCDEFGHIJK");

        // BiConsumer<T, U>: (T, U) -> void
        // Takes inputs of type T and U and accept()/consumes those. BiConsumer does not
        // return anything.

        BiConsumer<String, Integer> printSubstr = (s, beginIndex) -> System.out.println(s.substring(beginIndex));
        printSubstr.accept("Netherlands", 6);
        printSubstr.accept("Hello World", 3);

        ObjDoubleConsumer<Integer> printAddition = (a, b) -> System.out.println(a + " + " + b + " = " + (a + b));
        printAddition.accept(5, 25.0);

        // Function<T, R>: T -> R
        // Takes an input of type T and apply()/applies some function on it to return
        // ouput of type R.
        Function<Integer, String> itoa = (num) -> Integer.toString(num);
        System.out.println("Length of 1024: " + itoa.apply(1024).length());

        Function<String, Integer> atoi = (str) -> Integer.parseInt(str);
        System.out.println("15 * 9 = " + atoi.apply("15") * atoi.apply("9"));

        ToIntFunction<String> atoi2 = (str) -> Integer.parseInt(str);
        System.out.println("1024 / 4 = " + atoi2.applyAsInt("1024") / atoi2.applyAsInt("4"));

        // BiFunction<T, U, T>: (T, U) -> R
        // Takes inputs of type T and U and apply()/applies some function on it to
        // return output of type R.

        BiFunction<String, Integer, String> substr = (s, i) -> s.substring(i);
        System.out.println(substr.apply("abcdefghijklmn", 5));
        System.out.println(substr.apply("abcdefghijklmn", 12));

        ToIntBiFunction<String, String> totalLength = (s1, s2) -> (s1 + s2).length();
        System.out.println(totalLength.applyAsInt("hello", "world"));
        System.out.println(totalLength.applyAsInt("log", "out"));

        // Supplier<T> : () -> T
        // Takes no input and get()/supplies output of type T.
        Supplier<String> s = () -> "Testing supplier";
        System.out.println(s.get());

        IntSupplier minToSec = () -> 60;
        System.out.println("1 min = " + minToSec.getAsInt() + " seconds");

        // UnaryOperator<T>: T -> T
        // Takes an input of type T and apply()/applies some unary-operation on it to
        // return same type object.
        UnaryOperator<String> toUpper = (ss) -> ss.toUpperCase();
        System.out.println(toUpper.apply("Hello World"));

        IntUnaryOperator toggleSign = (num) -> (num * -1);
        System.out.println(toggleSign.applyAsInt(5));
        System.out.println(toggleSign.applyAsInt(-5));

        // BinaryOperator<T>: (T, T) -> T
        // Takes two inputs of type T and apply()/applies some binary-operation on it to
        // return same type object.
        BinaryOperator<String> join = (s1, s2) -> s1 + s2;
        System.out.println(join.apply("Happy", "Birthday"));

        IntBinaryOperator multiply = (n1, n2) -> n1 * n2;
        System.out.println("12 * 5 = " + multiply.applyAsInt(12, 5));
    }
}
