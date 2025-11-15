package LeetCodeMedium;

import java.util.HashSet;
import java.util.Set;

public class LeetCode264 {

//    Set<Integer> set = new HashSet<>();
//
//    public int nthUglyNumber(int n) {
//        for(int i=1;i<=6;i++){
//            if(i==n)
//                return i;
//        }
//        int x = 6;
//        int a = 6;
//        while(x!=n){
//            a = a+1;
//            boolean flag = false;
//            boolean ugly = true;
//            for(int i=2;i<=(a/2);i++){
//                if(i>=6 && set.contains(i) && a%i==0 && ugly){
//                    ugly = false;
//                    flag = true;
//                    break;
//                } else if(!flag && a%i==0) {
//                    flag = true;
//                }
//            }
//            if(!flag) {
//                set.add(a);
//                ugly = false;
//            }
//            if(ugly){
//                x+=1;
//            }
//        }
//        return a;
//    }

    public int nthUglyNumber(int n) {
        for(int i=1;i<=6;i++){
            if(i==n)
                return i;
        }
        int c = 6;
        int x = 6;

        while(x!=n){
            c+=1;
            int a=c;
            while (a % 2 == 0) a /= 2;
            while (a % 3 == 0) a /= 3;
            while (a % 5 == 0) a /= 5;
            if(a==1)
                x+=1;
        }
        return c;
    }

    public static void main(String[] args) {
        LeetCode264 obj = new LeetCode264();
        for(int i=1;i<=100;i++){
            System.out.println("Ugly Number "+i+" = "+obj.nthUglyNumber(i));
        }
//        System.out.println("400th ugly number -> "+obj.nthUglyNumber(400));
    }
}
