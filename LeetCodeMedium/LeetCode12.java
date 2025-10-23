package LeetCodeMedium;

import java.util.Map;

public class LeetCode12 {

    Map<Integer, Character> fixedMap = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            1000, 'M'
    );

    public String intToRoman(int num) {

        if(num==1 || num==5 || num==10 || num==50 || num==100 || num==500 || num==1000){
            return fixedMap.get(num).toString();
        }
        StringBuilder sb = new StringBuilder();
        int a = 1;
        int c = 0;
        while (num != 0) {
            int d = (num % 10) * a;
            if (a == 1) {
                if (d < 5 && d >= 0) {
                    if (d + 1 == 5)
                        sb.append(fixedMap.get(5)).append(fixedMap.get(1));
                    else {
                        insertSingle(d, sb);
                    }
                } else {
                    if (d + 1 == 10)
                        sb.append(fixedMap.get(10)).append(fixedMap.get(1));
                    else {
                        if(d==5)
                            c = 1;
                        d -= 5;
                        insertSingle(d, sb);
                        if(d>0 || c==1)
                            sb.append(fixedMap.get(5));
                    }
                }
            }
            if (a == 10) {
                if (d < 50 && d >= 10) {
                    if (d + 10 == 50)
                        sb.append(fixedMap.get(50)).append(fixedMap.get(10));
                    else {
                        insertDouble(d, sb);
                    }
                } else {
                    if (d + 10 == 100)
                        sb.append(fixedMap.get(100)).append(fixedMap.get(10));
                    else {
                        if(d==50)
                            c=1;
                        d -= 50;
                        insertDouble(d, sb);
                        if(d>0 || c==1)
                            sb.append(fixedMap.get(50));
                    }
                }
            }
            if (a == 100) {
                if (d < 500 && d >= 100) {
                    if (d + 100 == 500)
                        sb.append(fixedMap.get(500)).append(fixedMap.get(100));
                    else {
                        insertTriple(d, sb);
                    }
                } else {
                    if (d + 100 == 1000)
                        sb.append(fixedMap.get(1000)).append(fixedMap.get(100));
                    else {
                        if(d==500)
                            c=1;
                        d -= 500;
                        insertTriple(d, sb);
                        if(d>0 || c==1)
                            sb.append(fixedMap.get(500));
                    }
                }
            }
            if (a == 1000) {
                insertQuad(d, sb);
            }
            c = 0;
            a = a * 10;
            num = num / 10;
        }
        return new String(sb.reverse());
    }

    public void insertSingle(int d, StringBuilder sb) {
        while (d > 0) {
            sb.append(fixedMap.get(1));
            d -= 1;
        }
    }

    public void insertDouble(int d, StringBuilder sb) {
        while (d > 0) {
            sb.append(fixedMap.get(10));
            d -= 10;
        }
    }

    public void insertTriple(int d, StringBuilder sb) {
        while (d > 0) {
            sb.append(fixedMap.get(100));
            d -= 100;
        }
    }

    public void insertQuad(int d, StringBuilder sb) {
        while (d > 0) {
            sb.append(fixedMap.get(1000));
            d -= 1000;
        }
    }

    public static void main(String[] args) {
        LeetCode12 obj = new LeetCode12();
        System.out.println(obj.intToRoman(508));
        for(int i=0;i<=3999;i++){
            System.out.println(i+" -> "+obj.intToRoman(i));
        }
    }

}
