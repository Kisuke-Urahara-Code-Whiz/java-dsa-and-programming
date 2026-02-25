package Multithreading;

import java.util.function.*;

@FunctionalInterface
interface FuncInt{
    public int add(int a, int b);
}

@FunctionalInterface
interface GenericFuncInt<T>{
    public void add(T param1, T param2, T param3);
}

public class LamdaTest {

    public static void main(String[] args) {
        Predicate<String> filter = (name) -> name.equals("Sougata");
        System.out.println(filter.test("Souga"));

        GenericFuncInt<String> random = (str1, str2, str3) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(str1).append(str2).append(str3);
            System.out.println(new String(sb));
        };

        random.add("Sougata"," is a Pro ","Coder");

        Consumer<Integer> consumerExample = (a) -> System.out.println(a);
        BiConsumer<Integer, Integer> biConsumerExample = (a,b) -> System.out.println(a+b);
        BinaryOperator<Integer> binaryOperatorExample = (a,b) -> a+b;
        Function<Integer, String> functionExample = (a) -> a.toString();
        BiFunction<Integer, Integer, String> biFunctionExample = (a,b) -> Integer.toString(a+b);
        UnaryOperator<Integer> unaryOperatorExample = (a) -> a;
        Supplier<String> supplierExample = ()->"Sougata";

        consumerExample.accept(100);
        biConsumerExample.accept(200,200);
        System.out.println(binaryOperatorExample.apply(1000,2000));
        System.out.println(unaryOperatorExample.apply(10000));
        System.out.println(supplierExample.get());
        System.out.println(functionExample.apply(500));
        System.out.println(biFunctionExample.apply(500,1500));
    }

}
