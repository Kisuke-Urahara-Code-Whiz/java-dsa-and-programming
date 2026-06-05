package AdvancedJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        //Collections -> Stream
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        //PrimitiveStream
        int[] arr = new int[]{12,3,3,4,5};
        IntStream stream1 = Arrays.stream(arr);

        //ObjectStream
        Integer[] arr1 = new Integer[]{1,2,3,45};
        Stream<Integer> stream3 = Arrays.stream(arr1);

        //CustomStream
        Stream<String> stream2 = Stream.of("Hello","Hi");

        //Stream.iterate() - static method , used to create custom streams, unary operator used to creating the next value
        //seed is the starting value
        Stream<Integer> newStream = Stream.iterate(0, n->n+2).limit(100);

        //Stream.generate() - static method, used to create custom streams, supplier return value is stored as an item in the stream
        Stream<String> newStream1 = Stream.generate(() -> "Hello").limit(5);

        //returns a stream only
        Stream<Integer> filterStream = stream.filter(x -> x<=3); //filter each element and returns a stream of true elements

        //A stream is consumed only once, to reuse create a new stream
        List<Integer> finalResult = filterStream.toList();
        List<Integer> finalResult2 = list.stream().filter(x -> x<=3).toList();

        List<Integer> finalResult3 = list.stream().map(x->x*2).toList();

        //distinct - makes sure there are only distinct elements in the stream
        //sorted - makes sure elements are sorted, we can make custom sorting too, using a comparator in the sorted
        //limit in a finite stream means collecting the first n elements of the stream only where n is the limit
        //skip in a finite stream means skipping the first n elements of the stream where n is the number of elements to be skipped
        //peek -> write a consumer function or a non returning function with a single input for the elements of the stream
        //min -> uses a comparator function to sort elements based on the comparator function and return the first value in stream
        //max -> does the same as min but returns last element of stream
        //min max returns an Optional<T> object
        //use Optional<T> functions to return certain values like here .Else() -> if value not present in the Optional object return 0
        //.count() -> returns a long giving the length of the stream
        List<Integer> newList = List.of(-5,-4,-3,-2,-1,0,1,2,3,4,5);
        Integer newListResult = newList.stream()
                .map(x->x/2)
                .distinct()
                .sorted()
                .limit(4)
                .skip(1)
                .peek(System.out::println)
                .min((a,b) -> a-b)
                .orElse(0);
    }

    //there are many more unexplored methods one of which is forEach, reduce learn it on the go
}
