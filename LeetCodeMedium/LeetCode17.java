package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCode17 {

    Map<Character, String> employeeMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        char[] sb = new char[digits.length()];
        List<String> result = new ArrayList<>();
        backtrack(result, digits, sb, 0, digits.length());
        return result;
    }

    private void backtrack(
            List<String> result, String digits, char[] sb, int ptr, int length
    ){
        if(ptr==length) result.add(new String(sb));
        else{
            char[] str = employeeMap.get(digits.charAt(ptr)).toCharArray();
            for(char c: str){
                sb[ptr] = c;
                backtrack(result, digits, sb, ptr+1, length);
            }
        }
    }

}
