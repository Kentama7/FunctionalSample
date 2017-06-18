package com.github.kentama.sample;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountFunction {

    final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"),
            new BigDecimal("12"));

    public static void main(String[] args) {
        DiscountFunction discountFunction = new DiscountFunction();
        discountFunction.calc();
    }

    void calc() {
        // @formatter:off
        final BigDecimal totalOfDiscountedPrices = prices.stream()
                // 価格が20以上
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                // -10%
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                // 合計値
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // @formatter:on
        System.out.println(totalOfDiscountedPrices);
    }
}
