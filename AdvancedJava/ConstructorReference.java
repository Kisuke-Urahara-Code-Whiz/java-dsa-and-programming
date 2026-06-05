package AdvancedJava;

import java.util.List;

public class ConstructorReference {

    public static class Demo{
        int a;

        Demo(int a){
            this.a = a;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        list.forEach(Demo::new);
    }
}
