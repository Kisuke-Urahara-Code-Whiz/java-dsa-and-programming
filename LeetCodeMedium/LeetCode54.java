package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    List<Integer> elements = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] arr) {
        boolean flag = true;
        char dir = 'r';
        int r1 = 0;
        int r2 = arr.length-1;
        int c1 = 0;
        int c2 = arr[0].length-1;
        while(flag){
            if(dir=='r'){
                for(int i=c1;i<=c2;i++){
                    if(arr[r1][i]!=101) {
                        elements.add(arr[r1][i]);
                        arr[r1][i] = 101;
                    } else {
                        flag = false;
                        break;
                    }
                }
                r1+=1;
                dir = 'd';
            }
            else if(dir=='d'){
                for(int i=r1;i<=r2;i++){
                    if(arr[i][c2]!=101) {
                        elements.add(arr[i][c2]);
                        arr[i][c2] = 101;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                c2-=1;
                dir = 'l';
            } else if(dir=='l'){
                for(int i=c2;i>=c1;i--){
                    if(arr[r2][i]!=101) {
                        elements.add(arr[r2][i]);
                        arr[r2][i] = 101;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                r2-=1;
                dir = 'u';
            } else{
                for(int i=r2;i>=r1;i--){
                    if(arr[i][c1]!=101) {
                        elements.add(arr[i][c1]);
                        arr[i][c1] = 101;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                c1+=1;
                dir = 'r';
            }
            if(r1>r2 && c1>c2){
                flag = false;
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        LeetCode54 obj = new LeetCode54();
        List<Integer> ele = obj.spiralOrder(matrix);
        System.out.println(ele);
    }
}
