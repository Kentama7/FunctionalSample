package com.github.kentama.consumer;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class Sample {

    public static void main(String[] args) {
        consumer();
        intConsumer();
        longConsumer();
        doubleConsumer();
        objIntConsumer();
        objLongConsumer();
        objDoubleConsumer();
    }

    static void consumer() {
        Consumer<String> c1 = System.out::println;
        c1.accept("consumer1");

        Consumer<String> c2 = (a) -> System.out.println(a);
        c2.accept("consumer2");
    }

    static void intConsumer() {
        IntConsumer c = i -> System.out.println(i + 1);
        c.accept(2);
    }

    static void longConsumer() {
        LongConsumer c = l -> System.out.println(l + 1);
        c.accept(10L);
    }

    static void doubleConsumer() {
        DoubleConsumer c = d -> System.out.println(d + 1);
        c.accept(10.0);
    }

    static void objIntConsumer() {
        ObjIntConsumer<String> c = (o, i) -> System.out.println(o + i);
        c.accept("Int_", 100);
    }

    static void objLongConsumer() {
        ObjLongConsumer<String> c = (o, l) -> System.out.println(o + l);
        c.accept("Long_", 1000L);
    }

    static void objDoubleConsumer() {
        ObjDoubleConsumer<String> c = (o, d) -> System.out.println(o + d);
        c.accept("Double_", 10.1);
    }

}
