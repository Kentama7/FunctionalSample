package com.github.kentama.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {

    static final List<Person> people = Arrays.asList(new Person("John", 20), new Person("Sara", 21),
            new Person("Jane", 21), new Person("Greg", 35));

    public static void main(String[] args) {
        compare();
        reuse();
        multisort();
    }

    static void compare() {
        // @formatter:off
        List<Person> ascendingAge = people
            .stream()
//            .sorted((person1, person2) -> person1.ageDifference(person2))
            // 最初のインスタンスをageDifferenceのターゲットとし、もう一つをその引数とする
            .sorted(Person::ageDifference)
            .collect(Collectors.toList());
         // @formatter:on
        printPeople("Sorted in ascending order by age: ", ascendingAge);
    }

    static void reuse() {
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        printPeople("Sorted in ascending order by age: ",
                people.stream().sorted(compareAscending).collect(Collectors.toList()));

        printPeople("Sorted in descending order by age: ",
                people.stream().sorted(compareDescending).collect(Collectors.toList()));
    }

    static void multisort() {
        final Function<Person, Integer> byAge = person -> person.getAge();
        final Function<Person, String> byTheirName = person -> person.getName();

        printPeople("Sorted in ascending order by age and name: ", people.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byTheirName)).collect(Collectors.toList()));
    }

    static void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

}
