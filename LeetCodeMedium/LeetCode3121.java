package LeetCodeMedium;

public class LeetCode3121 {

    public int numberOfSpecialChars(String word){
        if(word.length()==1) return 0;
        int[] letters = new int[26];
        int result = 0;
        for(int i: word.toCharArray()){
            if(i>=97){
                if(letters[i-97]==-1){ letters[i-97] = -2; result-=1; }
                if(letters[i-97]==0) letters[i-97] = 1;
            }
            else{
                if(letters[i-65]==0) letters[i-65] = -2;
                if(letters[i-65]==1){ letters[i-65] = -1; result+=1; }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3121().numberOfSpecialChars("AbBCab"));
    }

}
