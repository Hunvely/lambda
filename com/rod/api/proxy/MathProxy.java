package com.rod.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {

    // 절대값 구하는 proxy
    public static Function<Integer, Integer> absInt = Math::abs;
    public static Function<Double, Double> absDouble = Math::abs;

    // 큰 값 찾기 proxy
    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Double, Double, Double> maxDouble = Math::max;

    // 작은 값 찾기 proxy
    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
    public static BiFunction<Double, Double, Double> minDouble = Math::min;

    // 랜덤 값 뽑는 proxy
    public static BiFunction<Integer, Integer, Integer> radomInt = (a, b) -> (int) (Math.random() * (b - a) + a);
    public static Supplier<Double> ramdomDouble = Math::random;

    // Math.ceil
    public static Function<Double,Double> ceilDouble = Math::ceil;

    // Math.floor
    public static Function<Double,Double> floorDouble = Math::floor;

    // Math.round
   // public static Function<Double,Integer> roundNum = Math::round;

    // 문자열 숫자로 변환 proxy
    public static Function<String, Integer> parseInt = Integer::parseInt;
    public static Function<String, Double> parseDouble = Double::parseDouble;

}
