package org.zb.springmvcdemo;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {

    @Test
    public void test1(){
        int[] arr = {1,2,3,4,5,6,7,8};
        double asDouble = IntStream.of(arr).average().getAsDouble();
        System.out.println("asDouble = " + asDouble);

        int sum=IntStream.of(arr).sum();
        System.out.println("sum = " + sum);

        double[] arr2 = {1,2,3,4,5,6,7,8};
        double sum1 = DoubleStream.of(arr2).map(i -> Math.pow(i, 2)).sum();
        System.out.println("sum1 = " + sum1);

    }
    @Test
    public void test2(){
        Random random = new Random();
        Supplier<Integer> supplier=()->random.nextInt(100);
        Stream<Integer> stream=Stream.generate(supplier).limit(5);
        System.out.println(stream.collect(Collectors.toList()));
    }

    @Test
    public void test3(){
        Stream<Integer> s = Stream.of(new Integer[]{1, 2, 3},
                new Integer[]{4, 5, 6}, new Integer[]{7, 8, 9}).flatMap( i -> Arrays.stream(i));
        s.forEach(System.out::println);
    }

    @Test
    public void test4(){
        IntStream.of(1,2,3,4,5,6,7).filter(i->i>=3).peek(String::valueOf).forEach(s-> System.out.println(s));
    }
    @Test
    public void test5(){
        Optional<String> s = Stream.of("www.20minutos.com".split("")).reduce((i, j) -> i + "." + j);
        System.out.println(s.orElse(""));
    }

}
