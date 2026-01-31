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

    int index = 0;

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        char[] charArray = digits.toCharArray();
        permute(result, temp, charArray, 0);
        return result;
    }

    public void permute(
            List<String> result,
            StringBuilder temp,
            char[] charArray,
            int ind
    ){
        if(ind==charArray.length) result.add(new String(temp));
        else {
            String letters = employeeMap.get(charArray[ind]);
            for(int i=0;i<letters.length();i++){
                permute(result, temp.append(letters.charAt(i)), charArray, ind+1);
                temp.deleteCharAt(ind);
            }
        }
    }

    public static void main(String[] args) {
        String s = "223";
        LeetCode17 obj = new LeetCode17();
        System.out.println("The Number Called -> "+s);
        System.out.println("Letter Combinations ->\n"+obj.letterCombinations(s));
    }

}
