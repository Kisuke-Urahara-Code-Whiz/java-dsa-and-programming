package LeetCodeMedium;

//Look Back required

public class LeetCode2211 {

    public int countCollisions(String directions) {
        if(directions.length() == 1) return 0;
        char[] str = directions.toCharArray();
        int result = 0;
        int p1 = 0;
        int p2 = 1;
        int waiting = 0;
        int l = directions.length();

        while(p2 < l){
            if(str[p1] == 'S' && str[p2] == 'L') {
                str[p2] = 'S';
                result += 1;
            }
            else if(str[p1] == 'R'){
                if(str[p2] == 'L' || str[p2] == 'S'){
                    result += (str[p2] == 'L') ? 2 : 1;
                    result += waiting;
                    str[p2] = 'S';
                    str[p1] = 'S';
                    waiting = 0;
                } else {
                    waiting += 1;
                }
            }
            p1++;
            p2++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode2211().countCollisions("RLRSLL"));
    }

}
