package LeetCodeEasy;

public class LeetCode1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3) return false;
        int a = 0;
        int b = 1;
        int c = 2;
        while(c<arr.length){
            if(arr[a]%2!=0 && arr[b]%2!=0 && arr[c]%2!=0) return true;
            a++;
            b++;
            c++;
        }
        return false;
    }

}
