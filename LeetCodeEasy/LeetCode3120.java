package LeetCodeEasy;

public class LeetCode3120 {

    public int numberOfSpecialChars(String word) {
        if(word.length()==1) return 0;
        int[] arr = new int[26];
        char[] c = word.toCharArray();
        int result = 0;
        for(char ch: c){
            boolean flag = ch<=90;
            int a = flag? ch-65: ch-97;
            if(arr[a] == 0) arr[a] = flag? 1 : 2;
            else if((arr[a] == 1 && !flag) || (arr[a] == 2 && flag)) {
                arr[a] = -1;
                result += 1;
            }
        }
        return result;
    }

}

