package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        permute(result, sb, arr, 0);
        return result;
    }

    public char reverseCase(int c) {
        if(65<=c && c<=90) return (char)(c+32);
        return (char)(c-32);
    }

    public void permute(
            List<String> result,
            StringBuilder sb,
            char[] arr,
            int index
    ){
        if(sb.length()==arr.length) result.add(new String(sb));
        else {
            permute(result, sb.append(arr[index]), arr, index+1);
            if(Character.isLetter(arr[index]))
                permute(result, sb.deleteCharAt(index).append(reverseCase(arr[index])), arr, index+1 );
            sb.deleteCharAt(index);
        }
    }

    static void main() {
        System.out.println(new LeetCode784().letterCasePermutation("a12B"));
    }
}
