package LeetCodeMedium;

public class LeetCode38_Recursion {

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        rec(sb,n-1);
        return new String(sb);
    }

    public void rec(StringBuilder sb, int n){
        if(n!=0){
            int p1 = 0;
            StringBuilder sb1 = new StringBuilder();
            int l = sb.length();
            char c = sb.charAt(p1++);
            int count = 1;
            while(p1<l){
                char temp = sb.charAt(p1);
                if(temp==c){
                    p1+=1;
                    count+=1;
                }
                else{
                    sb1.append(count);
                    sb1.append(c);
                    c = temp;
                    count = 1;
                    p1+=1;
                }
            }
            sb1.append(count);
            sb1.append(c);
            sb = sb.replace(0,sb.length(),new String(sb1));
            rec(sb,n-1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        LeetCode38_Recursion obj = new LeetCode38_Recursion();
        System.out.println("Count and Say -> "+obj.countAndSay(n));
    }

}
