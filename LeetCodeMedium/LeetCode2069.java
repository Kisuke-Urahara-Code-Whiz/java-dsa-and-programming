package LeetCodeMedium;

public class LeetCode2069 {

    class Robot {

        int x;
        int y;
        int xBoundary;
        int yBoundary;
        String cursor;
        String[] cursorDir;
        int cursorCounter;

        public Robot(int width, int height) {
            this.x = 0;
            this.y = 0;
            this.xBoundary = width-1;
            this.yBoundary = height-1;
            this.cursorDir = new String[]{"North","West","South","East"};
            this.cursorCounter = cursorDir.length-1;
            this.cursor = cursorDir[cursorCounter];
        }

        public void step(int num) {
            int remainingSteps = num;
            while(remainingSteps>0){
                int newX, newY;
                switch(cursorCounter){

                    case 0: newY = remainingSteps+this.y;
                            if(newY>yBoundary) {
                                remainingSteps = newY - this.yBoundary;
                                this.y = yBoundary;
                                cursorCounter = (cursorCounter + 1) % cursorDir.length;
                                cursor = cursorDir[cursorCounter];
                            } else {
                                this.y = newY;
                                remainingSteps = 0;
                            }
                            break;

                    case 1: newX = this.x-remainingSteps;
                            if(newX<0){
                                remainingSteps = -newX;
                                this.x = 0;
                                cursorCounter = (cursorCounter+1)%cursorDir.length;
                                cursor = cursorDir[cursorCounter];
                            } else {
                                this.x = newX;
                                remainingSteps = 0;
                            }
                            break;

                    case 2: newY = this.y-remainingSteps;
                            if(newY<0){
                                remainingSteps = -newY;
                                this.y = 0;
                                cursorCounter = (cursorCounter+1)%cursorDir.length;
                                cursor = cursorDir[cursorCounter];
                            } else {
                                this.y = newY;
                                remainingSteps = 0;
                            }
                            break;

                    case 3: newX = remainingSteps+this.x;
                            if(newX>xBoundary) {
                                remainingSteps = newX - this.xBoundary;
                                this.x = xBoundary;
                                cursorCounter = (cursorCounter + 1) % cursorDir.length;
                                cursor = cursorDir[cursorCounter];
                            } else {
                                this.x = newX;
                                remainingSteps = 0;
                            }
                            break;
                }
            }
        }

        public int[] getPos() {
            return new int[]{this.x, this.y};
        }

        public String getDir() {
            return cursor;
        }

    }

}
