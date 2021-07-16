package org.zb.springmvcdemo;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunction {
    @Test
    public void test1(){
        Function<Integer,String> func1=i->"你输入的数字是"+i;
        System.out.println(func1.apply(15));
    }
    @Test
    public void test2(){
        Predicate<Integer>  pred = i->i>=0?true:false;
        System.out.println(pred.test(-1));
    }
    @Test
    public void test3(){
        Consumer<String> consumer = s-> System.out.println("你输入的文字是"+s);
        consumer.accept("hello function");
    }
    @Test
    public void test4(){
        Random random = new Random();
        Supplier<String> supplier = ()->"随机产生的0-10数字是"+random.nextInt(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(supplier.get());
        }
    }



}
