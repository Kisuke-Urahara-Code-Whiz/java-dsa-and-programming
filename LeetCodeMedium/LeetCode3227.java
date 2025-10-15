package LeetCodeMedium;

public class LeetCode3227 {
    public boolean doesAliceWin(String s) {
        char[] ch = s.toCharArray();
        for(char c:ch){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                return true;
        }
        return false;
    }
}
