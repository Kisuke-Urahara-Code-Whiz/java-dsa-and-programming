package Multithreading;

import java.util.function.Predicate;

@FunctionalInterface
interface FuncInt{
    public int add(int a, int b);
}

public class LamdaTest {

    public static void main(String[] args) {
        Predicate<String> filter = (name) -> name.equals("Sougata");
        System.out.println(filter.test("Souga"));
    }

}
