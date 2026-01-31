package LeetCodeEasy;

public class LeetCode560 {

    public String[] findRelativeRanks(int[] score) {
        int[] heap = new int[score.length+1];
        String[] result = new String[score.length];
        for(int i=0;i< score.length;i++){
            insert(heap, score, i+1, i);
        }
        int counter = score.length;
        int index = heap.length-1;
        while(counter!=0){
            if(counter== score.length) result[delete(heap, score, index)] = "Gold Medal";
            else if(counter == score.length-1) result[delete(heap, score, index)] = "Silver Medal";
            else if(counter == score.length-2) result[delete(heap, score, index)] = "Bronze Medal";
            else result[delete(heap, score, index)] = String.valueOf((score.length-counter)+1);
            counter-=1;
            index-=1;
        }
        return result;
    }

    private void swap(int p1, int p2, int[] heap){
        int temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    private void insert(int[] heap, int[] score, int index, int ele){
        heap[index] = ele;
        while(index/2!=0 && score[heap[index/2]]<score[heap[index]]){
            swap(index, index/2, heap);
            index = index/2;
        }
    }

    private int delete(int[] heap, int[] score, int index){
        int top = heap[1];
        swap(index, 1, heap);
        int i = 1;
        while(2*i<=index-1){
            int l =2*i;
            int r = 2*i+1;
            int ldx = l;
            if(r<=index-1 && score[heap[r]]>score[heap[l]]) ldx=r;
            if(score[heap[ldx]]>score[heap[i]]){
                swap(ldx, i, heap);
                i = ldx;
            } else break;
        }
        return top;
    }

}
