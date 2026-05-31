package LeetCodeEasy;

public class LeetCode796 {

    public boolean rotateString(String s, String goal) {

//        if(s.length() != goal.length()) return false;
//        s= s+s;
//        if(s.indexOf(goal) != -1) return true;
//        return false;

        if(s.length()==goal.length()) {
            char[] target = goal.toCharArray();
            char[] str = (s + s).toCharArray();
            int index = 0;
            int finalIndex = str.length - s.length();
            while (index <= finalIndex) {
                boolean flag = true;
                int tempIndex = index;
                for (char c : target) {
                    if (c == str[tempIndex]) tempIndex += 1;
                    else {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
                else index += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode796().rotateString("abcde", "cdeab"));
    }
}
