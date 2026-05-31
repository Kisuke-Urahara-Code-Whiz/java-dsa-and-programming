package LeetCodeEasy;

public class LeetCode231 {

//    public boolean isPowerOfTwo(int n) {
//        return (Math.log(n)/Math.log(2))%1==0.0;
//    }
//
//    Computers struggle to represent decimal numbers perfectly.
//    The calculation Math.log(n) / Math.log(2) relies on double precision arithmetic.
//    Because of tiny rounding errors deep in the decimals, a valid power of two might output a result like 3.0000000000000004.
//    If that happens, % 1 will not be exactly 0.0, and your code will return false even though it should be true

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
