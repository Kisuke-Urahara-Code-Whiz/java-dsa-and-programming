package Others;

public class FractionalKnapsack {

    private void quickSort(
            double[] greedy,
            int[] val,
            int[] wt,
            int l,
            int r
            ){

        if(l>=r) return;

        int mid = l+(r-l)/2;
        double pivot = greedy[mid];
        int s = l;
        int e = r;

        while(s<=e){

            while(greedy[s]<pivot){ s++; }
            while(greedy[e]>pivot){ e--; }

            if(s<=e){
                swap(greedy, val, wt, s, e);
                s++;
                e--;
            }

        }

        quickSort(greedy, val, wt, l, e);
        quickSort(greedy, val, wt, s, r);

    }

    private void swap(
            double[] greedy,
            int[] val,
            int[] wt,
            int p1,
            int p2
    ){

        double temp = greedy[p1];
        greedy[p1] = greedy[p2];
        greedy[p2] = temp;

        int tempInt = val[p1];
        val[p1] = val[p2];
        val[p2] = tempInt;

        tempInt = wt[p1];
        wt[p1] = wt[p2];
        wt[p2] = tempInt;
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double[] greedy = new double[val.length];
        for(int i=0;i< val.length;i++){
            greedy[i] = (double) val[i] /wt[i];
        }
        quickSort(greedy, val, wt, 0, greedy.length-1);

        double result = 0;
        for(int i = val.length-1;i>=0;i--){
            if(wt[i]<capacity){
                result+=val[i];
                capacity-=wt[i];
            } else {
                result+=(greedy[i]*capacity);
                break;
            }
        }

        return result;
    }
}
