package Programs;

public class Random_Pattern_Symbol {
    public static void main(String[] args) {
        int rows = 8;
        int cols = 11;
        String[][] symbol = new String[rows][cols];
        for(int i=0;i<=(rows-1)/2;i++){
            for(int j=0;j<cols;j++){
                if(j==(cols/4)+i || j==(cols/4)-i || j==cols-1-(cols/4)-i || j==cols-1-(cols/4)+i){
                    symbol[i][j] = "*";
                }
            }
        }
        int reset = 1;
        for(int i=((rows-1)/2);i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j==reset || j==cols-1-reset)
                    symbol[i][j] = "*";
            }
            reset+=1;
        }

        System.out.println("Symbol -> ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(symbol[i][j]!=null)
                    System.out.print(symbol[i][j]+" ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
