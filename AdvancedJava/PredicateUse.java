package AdvancedJava;

import java.util.function.Predicate;

public class PredicateUse {

    public static void main(String[] args) {
        Predicate<Integer> greaterthanminus10 = x -> x>-10;
        Predicate<Integer> lessthan10 = x->x<10;
        Predicate<Integer> validPositive = x->x>0;
        Predicate<Integer> validNegative = x->x<0;
        Predicate<Integer> isZero = x -> x==0;
        Predicate<Integer> result = validPositive.and(greaterthanminus10).and(lessthan10);
        Predicate<Integer> negate = result.negate();
        System.out.println(negate.test(9));
    }
}
