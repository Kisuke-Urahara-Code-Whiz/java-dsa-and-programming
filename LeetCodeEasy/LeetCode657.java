package LeetCodeEasy;

public class LeetCode657 {

    public boolean judgeCircle(String moves) {
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            switch(c){
                case 'U' :  u++;
                            break;

                case 'D':   d++;
                            break;

                case 'L': l++;
                            break;

                case 'R': r++;
                          break;

            }
        }
        if(u==d && l==r) return true;
        else return false;
    }

}
