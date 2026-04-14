package LeetCodeMedium;

public class LeetCode2069 {

    static class Robot {
        int width, height, perimeter;
        int index = 0;
        boolean moved = false;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.perimeter = 2 * (width + height - 2);
        }

        public void step(int num) {
            moved = true;
            index = (index + num) % perimeter;
        }

        public int[] getPos() {
            if (index >= 0 && index < width) {
                return new int[]{index, 0};
            }

            else if (index < width + height - 1) {
                return new int[]{width - 1, index - (width - 1)};
            }

            else if (index < 2 * width + height - 2) {
                return new int[]{width - 1 - (index - (width + height - 2)), height - 1};
            }

            else {
                return new int[]{0, perimeter - index};
            }
        }

        public String getDir() {

            if (moved && index == 0) return "South";


            if (index > 0 && index < width) return "East";
            if (index >= width && index < width + height - 1) return "North";
            if (index >= width + height - 1 && index < 2 * width + height - 2) return "West";
            if (index >= 2 * width + height - 2) return "South";

            return "East";
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]
                {"step","step","getPos","getDir","step","step","step","getPos","getDir"};
        int[][] steps = new int[][]
                {{7},{7},{},{},{2},{1},{4},{},{}};
        Robot object = new Robot(6,3);
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("step")){
                object.step(steps[i][0]);
            }
            else if(arr[i].equals("getDir")){
                System.out.println(object.getDir());
            } else {
                int[] pos = object.getPos();
                System.out.println("x = "+pos[0]);
                System.out.println("y = "+pos[1]);
            }
        }
    }

}
