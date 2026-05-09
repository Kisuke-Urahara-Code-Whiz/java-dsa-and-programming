package LeetCodeMedium;

public class LeetCode1631 {

    public class LC1631_MinHeap {

        int[][] indexes;
        int[][] coordinateHeap;
        int[] differenceHeap;
        int index;
        int length;

        public LC1631_MinHeap(int m, int n) {

            length = m * n;
            indexes = new int[m][n];
            coordinateHeap = new int[length + 1][2];
            differenceHeap = new int[length + 1];
            index = 0;

        }

        public boolean isEmpty() {
            return index == 0;
        }

        private void swap(int p1, int p2) {

            int[] tempArr = coordinateHeap[p1];
            coordinateHeap[p1] = coordinateHeap[p2];
            coordinateHeap[p2] = tempArr;

            int temp = differenceHeap[p1];
            differenceHeap[p1] = differenceHeap[p2];
            differenceHeap[p2] = temp;

            indexes[coordinateHeap[p1][0]][coordinateHeap[p1][1]] = p1;
            indexes[coordinateHeap[p2][0]][coordinateHeap[p2][1]] = p2;
        }

        private void goUp(int currentIndex) {

            while (currentIndex > 1 && differenceHeap[currentIndex] < differenceHeap[currentIndex / 2]) {
                swap(currentIndex, currentIndex / 2);
                currentIndex = currentIndex / 2;
            }

        }

        private void goDown() {

            int tempIndex = 1;
            while ((tempIndex * 2) <= index) {
                int leftChild = tempIndex * 2;
                int rightChild = leftChild + 1;
                int smallerChild = leftChild;
                if (rightChild <= index && differenceHeap[rightChild] < differenceHeap[leftChild]) smallerChild = rightChild;

                if (differenceHeap[smallerChild] < differenceHeap[tempIndex]) {
                    swap(smallerChild, tempIndex);
                    tempIndex = smallerChild;
                } else break;
            }
        }

        public LC1631_HeapResult delete() {

            int[] resultCoordinate = coordinateHeap[1];
            int resultDifference = differenceHeap[1];

            swap(1, index);
            indexes[resultCoordinate[0]][resultCoordinate[1]] = 0;
            index--;

            goDown();

            return new LC1631_HeapResult(
                    resultCoordinate,
                    resultDifference
            );

        }

        public void insert(int diff, int x, int y) {

            if (indexes[x][y] == 0) {
                int[] coordinateArr = new int[]{x, y};
                index++;
                coordinateHeap[index] = coordinateArr;
                differenceHeap[index] = diff;
                indexes[x][y] = index;
                goUp(index);
            }

            else if (differenceHeap[indexes[x][y]] > diff) {
                differenceHeap[indexes[x][y]] = diff;
                goUp(indexes[x][y]);
            }

        }
    }

    public class LC1631_HeapResult {
        int[] coordinates;
        int difference;
        public LC1631_HeapResult(int[] arr, int diff) {
            this.coordinates = arr;
            this.difference = diff;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        if (m == 1 && n == 1) return 0;

        int[][] movements = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean[][] visited = new boolean[m][n];
        LC1631_MinHeap heap = new LC1631_MinHeap(m, n);
        heap.insert(0, 0, 0);

        while (!heap.isEmpty()) {

            LC1631_HeapResult heapVal = heap.delete();

            int i = heapVal.coordinates[0];
            int j = heapVal.coordinates[1];
            int currentEffort = heapVal.difference;

            if (visited[i][j]) continue;
            visited[i][j] = true;

            if (i == m - 1 && j == n - 1) return currentEffort;


            for (int[] move : movements) {

                int tempX = i + move[0];
                int tempY = j + move[1];

                if (tempX >= 0 && tempY >= 0 && tempX < m && tempY < n && !visited[tempX][tempY]) {

                    int edgeDifference = Math.abs(heights[tempX][tempY] - heights[i][j]);
                    int newEffort = Math.max(
                            currentEffort,
                            edgeDifference
                    );

                    heap.insert(newEffort, tempX, tempY);
                }
            }
        }

        return 0;
    }

}