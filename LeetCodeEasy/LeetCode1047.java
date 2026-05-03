package LeetCodeEasy;

public class LeetCode1047 {

    int top = -1;

    public String removeDuplicates(String s) {
        char[] arr = new char[s.length()];
        for(char i:s.toCharArray()){
            insert(arr, i);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<=top){
            sb.append(arr[i]);
            i+=1;
        }
        return new String(sb);
    }

    private void insert(char[] arr, char c){
        if(top!=-1 && arr[top] == c) pop();
        else arr[++top] = c;
    }

    private void pop(){
        top-=1;
    }
}
