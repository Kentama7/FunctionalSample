package com.github.kentama.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PickElementsMultipleCollection {

    final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
    final List<String> comrades = Arrays.asList("Kate", "ken", "Nikc", "Paula", "Zach");

    public static void main(String[] args) {
        PickElementsMultipleCollection p = new PickElementsMultipleCollection();
        p.simpleFileter();
        p.usePredicate();
    }

    void simpleFileter() {
        final long countFriendsStartN = friends.stream().filter(name -> name.startsWith("N")).count();
        final long countEditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();
        final long countComradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();

        System.out.println("Friends: " + countFriendsStartN);
        System.out.println("Editors: " + countEditorsStartN);
        System.out.println("Comrades: " + countComradesStartN);
    }

    void usePredicate() {
        final Predicate<String> startWithN = name -> name.startsWith("N");

        final long countFriendsStartN = friends.stream().filter(startWithN).count();
        final long countEditorsStartN = editors.stream().filter(startWithN).count();
        final long countComradesStartN = comrades.stream().filter(startWithN).count();

        System.out.println("Friends: " + countFriendsStartN);
        System.out.println("Editors: " + countEditorsStartN);
        System.out.println("Comrades: " + countComradesStartN);
    }

}
