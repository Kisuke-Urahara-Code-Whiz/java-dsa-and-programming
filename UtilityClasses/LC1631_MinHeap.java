package UtilityClasses;

public class LC1631_MinHeap {

    int[][] indexes;
    int[][] coordinateHeap;
    int[] differenceHeap;
    int index;
    int length;

    MinHeap(int m, int n){
        length = (m*n);
        indexes = new int[m][n];
        coordinateHeap = new int[length][2];
        differenceHeap = new int[length];
        index = 0;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    private void swap(int p1, int p2){

        int[] tempArr = coordinateHeap[p1];
        coordinateHeap[p1] = coordinateHeap[p2];
        coordinateHeap[p2] = tempArr;

        int temp = differenceHeap[p1];
        differenceHeap[p1] = differenceHeap[p2];
        differenceHeap[p2] = temp;

        indexes[coordinateHeap[p1][0]][coordinateHeap[p1][1]] = p1;
        indexes[coordinateHeap[p2][0]][coordinateHeap[p2][1]] = p2;

    }

    private void goUp(int index){
        while(index!=1 && differenceHeap[index]<differenceHeap[index/2]){
            swap(index, index/2);
            index = index/2;
        }
    }

    private void goDown(){
        int tempIndex = 1;
        while((tempIndex*2)<=index){
            int lIndex = tempIndex*2;
            if((lIndex+1)<=index && differenceHeap[lIndex+1]<differenceHeap[lIndex]) lIndex+=1;
            if(differenceHeap[lIndex]<differenceHeap[tempIndex]){
                swap(lIndex, tempIndex);
                tempIndex = lIndex;
            } else break;
        }
    }

    LC1631_ResultHeap delete(){

        int[] resultCoordinate = coordinateHeap[index];
        int resultDifference = differenceHeap[index];

        swap(1, index);
        indexes[resultCoordinate[0]][resultCoordinate[1]] = 0;
        index = index-1;

        goDown();

        return new LC1631_ResultHeap(resultCoordinate, resultDifference);

    }

    public void insert(int diff, int x, int y){
        if(indexes[x][y]==0){
            int[] coordinateArr = new int[]{x,y};
            index+=1;
            coordinateHeap[index] = coordinateArr;
            differenceHeap[index] = diff;
            indexes[x][y] = index;
            goUp(index);
        } else if(differenceHeap[indexes[x][y]]>diff){
            differenceHeap[indexes[x][y]] = diff;
            goUp(indexes[x][y]);
        }
    }

}
