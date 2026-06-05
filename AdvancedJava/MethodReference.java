package AdvancedJava;

import java.util.List;

public class MethodReference {

    public static void squareAndPrint(int s){
        System.out.println(s*s);
    }

    public void cubeAndPrint(int s){
        System.out.println(s*s*s);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        list.forEach(MethodReference::squareAndPrint);
        MethodReference obj = new MethodReference();
        list.forEach(obj::cubeAndPrint);
    }
}
