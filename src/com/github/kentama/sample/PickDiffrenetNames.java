package com.github.kentama.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDiffrenetNames {
    final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        PickDiffrenetNames p = new PickDiffrenetNames();
        p.usePredicate();
        p.useStaticPredicate();
        p.useFunction();
    }

    void usePredicate() {
        final Predicate<String> startWithN = name -> name.startsWith("N");
        final Predicate<String> startWithB = name -> name.startsWith("B");

        final long countFriendsStartN = friends.stream().filter(startWithN).count();
        final long countFriendsStartB = friends.stream().filter(startWithB).count();

        System.out.println("Start N: " + countFriendsStartN);
        System.out.println("Start B: " + countFriendsStartB);
    }

    static Predicate<String> checkIfStartsWith(String letter) {
        return name -> name.startsWith(letter);
    }

    void useStaticPredicate() {
        final long countFriendsStartN = friends.stream().filter(checkIfStartsWith("N")).count();
        final long countFriendsStartB = friends.stream().filter(checkIfStartsWith("B")).count();

        System.out.println("Start N: " + countFriendsStartN);
        System.out.println("Start B: " + countFriendsStartB);
    }

    final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

    void useFunction() {
        final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
        final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

        System.out.println("Start N: " + countFriendsStartN);
        System.out.println("Start B: " + countFriendsStartB);
    }
}
