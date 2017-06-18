package com.github.kentama.compare;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Person {
    private final String name;
    private final int age;

    public int ageDifference(final Person other) {
        return age - other.getAge();
    }
}
