package AdvancedJava;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

    //Same as streams only, parallelStream allow to operate streaming using multiple threads only used for stream processing
    //Faster for Large Streams
    //Slower for Small Streams due to chunking
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);
        Stream<Integer> stream= list.parallelStream();
    }
}
