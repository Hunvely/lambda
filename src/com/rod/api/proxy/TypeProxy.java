package com.rod.api.proxy;

import java.util.function.Function;

public class TypeProxy {

    public static Function<?,String> string = String :: valueOf; // valueof는 숫자(mutable)로 문자열(immutable)로 변환.

    public static Function<String, Integer> integer = Integer::valueOf;

    public static Function<String, Double> doubleof = Double::valueOf;


}
