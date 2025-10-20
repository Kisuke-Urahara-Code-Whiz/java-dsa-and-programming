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

        StringBuilder sb = new StringBuilder();
        int a = 1;
        while (num != 0) {
            int d = (num % 10) * a;
            if (a == 1) {
                if (d < 5 && d >= 1) {
                    if (d + 1 == 5)
                        sb.append(fixedMap.get(5)).append(fixedMap.get(1));
                    else {
                        insertSingle(d, sb);
                    }
                } else {
                    if (d + 1 == 10)
                        sb.append(fixedMap.get(10)).append(fixedMap.get(1));
                    else {
                        d -= 5;
                        insertSingle(d, sb);
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
                        d -= 50;
                        insertDouble(d, sb);
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
                        d -= 500;
                        insertTriple(d, sb);
                        sb.append(fixedMap.get(500));
                    }
                }
            }
            if (a == 1000) {
                insertQuad(d, sb);
            }
            a = a * 10;
            num = num / 10;
        }
        return new String(sb.reverse());
    }

    public void insertSingle(int d, StringBuilder sb) {
        while (d != 0) {
            sb.append(fixedMap.get(1));
            d -= 1;
        }
    }

    public void insertDouble(int d, StringBuilder sb) {
        while (d != 0) {
            sb.append(fixedMap.get(10));
            d -= 10;
        }
    }

    public void insertTriple(int d, StringBuilder sb) {
        while (d != 0) {
            sb.append(fixedMap.get(100));
            d -= 100;
        }
    }

    public void insertQuad(int d, StringBuilder sb) {
        while (d != 0) {
            sb.append(fixedMap.get(1000));
            d -= 1000;
        }
    }

}
