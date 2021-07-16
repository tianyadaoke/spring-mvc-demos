package org.zb.springmvcdemo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.*;

public class TestLambda {
    @Test
    public void test1(){
        //Function<Integer,String> func =a->String.valueOf(a);
        Function<Integer,String> func =String::valueOf;
        String s = func.apply(90);
        System.out.println("s="+s);

        Consumer<String> consumer =  System.out::println;
        consumer.accept("HELLO");

        BiFunction<Integer,Integer,Double> biFunc = Math::pow;
        Double result = biFunc.apply(3,4);
        System.out.println("result="+result);

        Random random = new Random();
        //IntUnaryOperator publisher = i -> random.nextInt(i);
        IntUnaryOperator publisher=random::nextInt;
        Integer r = publisher.applyAsInt(10);
        System.out.println("r = " + r);

        String[] strArray = {"你","好","呀"};
        //Arrays.sort(strArray,String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(strArray,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(strArray));

        Supplier<Cat> supplier=()->new Cat();
        Cat cat = supplier.get();

        Supplier<Cat> supplier1 = Cat::new;
        Cat cat1 = supplier1.get();

        IntFunction<int[]> function = i->new int[i];
        int[] arr = function.apply(10);
        System.out.println("arr.length = " + arr.length);

        Consumer<String> consumer1 = s1-> System.out.println(s1+s);
        consumer1.accept("hello +++++");

        Function<Integer,Function<Integer,IntFunction<Integer>>> function1 = x->y->z->x+y+z;
        Integer i = function1.apply(3).apply(40).apply(5);
        System.out.println("i="+i);

    }

    private class Cat {

    }
}
