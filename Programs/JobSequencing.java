package Programs;

import java.util.ArrayList;

public class JobSequencing {

    private void quickSort(int[] profit, int[] deadline, int l, int r){
        if(l>=r) return;

        int mid = l+(r-l)/2;
        int pivot = profit[mid];
        int s = l;
        int e = r;

        while(s<=e){
            while(profit[s]<pivot) { s++; }
            while(profit[e]>pivot) { e--; }

            if(s<=e){
                swap(profit, deadline, s, e);
                s++;
                e--;
            }
        }

        quickSort(profit, deadline, l, e);
        quickSort(profit, deadline, s, r);
    }

    private void swap(int[] profit, int[] deadline, int p1, int p2){
        int temp;

        temp = profit[p1];
        profit[p1] = profit[p2];
        profit[p2] = temp;

        temp = deadline[p1];
        deadline[p1] = deadline[p2];
        deadline[p2] = temp;
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int maxProfit = 0;
        int maxJobs = 0;
        ArrayList<Integer> result = new ArrayList<>();
        quickSort(profit, deadline, 0, profit.length-1);
        boolean[] slotBooked = new boolean[deadline.length];

        for(int i=profit.length-1; i>=0; i--){
            int availableSlot = deadline[i]-1;
            while(availableSlot>=0){
                if(!slotBooked[availableSlot]){
                    maxJobs++;
                    maxProfit+=profit[i];
                    slotBooked[availableSlot] = true;
                    break;
                } else availableSlot--;
            }
        }

        result.add(maxJobs);
        result.add(maxProfit);
        return result;
    }
}
