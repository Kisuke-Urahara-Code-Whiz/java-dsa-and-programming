package LeetCodeMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode874 {

    public int robotSim(int[] commands, int[][] obstacles) {

        HashMap<Integer, Set<Integer>> obs = new HashMap<>();
        for(int i=0;i<obstacles.length;i++){
            Set<Integer> set = obs.get(obstacles[i][0]);
            if(set==null){
                set = new HashSet<>();
                obs.put(obstacles[i][0], set);
            }
            set.add(obstacles[i][1]);
        }

        int max = 0;

        char[] dir = new char[]{'U','R','D','L'};

        int x = 0;
        int y = 0;

        int cursorDir = 0;
        char cursor = dir[cursorDir];

        for(int i=0;i<commands.length;i++){
            if(commands[i]==-1) {
                cursorDir = (cursorDir + 1) % dir.length;
                cursor = dir[cursorDir];
            } else if(commands[i]==-2){
                cursorDir = (cursorDir-1+dir.length)%dir.length;
                cursor = dir[cursorDir];
            } else {
                for(int j=1;j<=commands[i];j++){
                    int newX = x;
                    int newY = y;
                    switch(cursor){
                        case 'U': newY+=1; break;
                        case 'D': newY-=1; break;
                        case 'L': newX-=1; break;
                        case 'R': newX+=1; break;
                    }
                    if(obs.containsKey(newX) && obs.get(newX).contains(newY)) break;
                    else{
                        x = newX;
                        y = newY;
                    }
                }
                max = Math.max(max, x*x+y*y);
            }

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode874().robotSim(
                new int[]{6,-1,-1,6},
                new int[][]{{0,0}}
                ));
    }

}
