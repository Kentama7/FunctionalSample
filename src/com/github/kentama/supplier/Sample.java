package com.github.kentama.supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class Sample {

    public static void main(String[] args) {
        // sample
        supplier();
        booleanSupplier();
        intSupplier();
        longSupplier();
        doubleSupplier();
    }

    static void supplier() {
        Supplier<String> s = () -> "supplier";
        System.out.println(s.get());
    }

    static void booleanSupplier() {
        BooleanSupplier s = () -> true;
        if (s.getAsBoolean()) {
            System.out.println("booleanSupplier");
        }
    }

    static void intSupplier() {
        IntSupplier s = () -> 1;
        System.out.println(s.getAsInt());
    }

    static void longSupplier() {
        LongSupplier s = () -> 10L;
        System.out.println(s.getAsLong());
    }

    static void doubleSupplier() {
        DoubleSupplier s = () -> 1.0;
        System.out.println(s.getAsDouble());
    }

}
