package com.github.kentama.predicate;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class Sample {

    public static void main(String[] args) {
        predicate();
        intPredicate();
        longPredicate();
        doublePredicate();
        biPredicate();
    }

    static void predicate() {
        Predicate<String> p = s -> "Hoge".equals(s);
        System.out.println(p.test("Foo"));
        System.out.println(p.test("Hoge"));
    }

    static void intPredicate() {
        IntPredicate p = i -> i > 0;
        System.out.println(p.test(1));
        System.out.println(p.test(-1));
    }

    static void longPredicate() {
        LongPredicate p = l -> l < 0;
        System.out.println(p.test(1));
        System.out.println(p.test(-1));
    }

    static void doublePredicate() {
        DoublePredicate p = d -> d == 1.0;
        System.out.println(p.test(1));
        System.out.println(p.test(1.0));
    }

    static void biPredicate() {
        BiPredicate<String, Integer> p = (s, i) -> s.equals(i.toString());
        System.out.println(p.test("0", 0));
        System.out.println(p.test("01", 1));
    }

}
