package LeetCodeHard;

import java.util.Arrays;

public class LeetCode2454 {

    int[] heapNum;
    int[] heapIndex;
    int lastIndex;
    int[] result;
    int[] insertions;

    public int[] secondGreaterElement(int[] nums) {

        heapNum = new int[nums.length+1];
        heapIndex = new int[nums.length+1];
        lastIndex = 1;
        result = new int[nums.length];
        insertions = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            result[i] = -1;
            insert(nums[i], i);
        }

        return result;
    }

    private void insert(int n, int index){
        heapNum[lastIndex] = n;
        heapIndex[lastIndex] = index;
        int idx = lastIndex++;

        while(idx/2!=0){
            int ldx = idx/2;
            if(heapNum[ldx]<heapNum[idx]) { swap(ldx, idx); idx = ldx; }
            else break;
        }

        if(idx/2!=0){
            int cIdx = idx/2;
            if(cIdx*2!=idx) compute(heapNum[idx], cIdx*2);
            else compute(heapNum[idx], cIdx*2+1);
        }
        compute(heapNum[idx], idx*2);
    }

    private void compute(int nextLarge, int smallestIdx){

        for(int i=smallestIdx;i<=smallestIdx+1;i++) {
            boolean flag1 = true;
            while (flag1) {
                if (i < lastIndex && insertions[heapIndex[i]] == 0) {
                    insertions[heapIndex[i]] += 1;
                    flag1 = false;
                } else if (i < lastIndex && insertions[heapIndex[i]] == 1) {
                    insertions[heapIndex[i]] += 1;
                    result[heapIndex[i]] = nextLarge;
                    delete(i);
                } else flag1 = false;
            }

            if(i*2 < lastIndex) compute(nextLarge, i * 2);
        }

    }

    private void delete(int index){
        swap(lastIndex, index);
        lastIndex-=1;
        while(index*2<lastIndex){
            int smallestIdx = index*2;
            if(smallestIdx+1<lastIndex && heapNum[smallestIdx]>heapNum[smallestIdx+1]) smallestIdx+=1;
            if(heapNum[smallestIdx]>heapNum[index]){
                swap(smallestIdx, index);
                index = smallestIdx;
            }
        }
    }


    private void swap(int p1, int p2){

        int temp1 = heapNum[p1];
        int temp2 = heapIndex[p1];

        heapNum[p1] = heapNum[p2];
        heapIndex[p1] = heapIndex[p2];

        heapNum[p2] = temp1;
        heapIndex[p2] = temp2;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode2454().secondGreaterElement(new int[]{2,4,0,9,6})));
    }
}
