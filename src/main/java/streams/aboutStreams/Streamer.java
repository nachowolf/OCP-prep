package streams.aboutStreams;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streamer {

    static Predicate<Integer> checkIfGreaterThan4(){
       return p -> p > 4;
    }

    public static void main(String[] args) {
        Integer[] myNums = {1, 2,3,4,5,6,7};

        Stream<Integer> myStream = Arrays.stream(myNums);

        myStream.forEach(System.out::println);
        myStream.forEach(System.out::println);

//        Supplier<Stream<Integer>> streamSupplier = () -> myStream;
//        () -> Stream.of(myNums);
//        () -> myStream;

//
//        streamSupplier.get().forEach(System.out::println);
//
//        long val = streamSupplier.get().filter(i -> i >= 3).count();
//        System.out.println(val);
//int[] array = {1,23,4,4};
//        Stream<Integer> nums = Arrays.stream(array).boxed();
//        nums.



//        myStream.filter(checkIfGreaterThan4()).forEach(System.out::println);

    }
}

/*
####################| STREAM NOTES |####################
########################################################

#> A stream is a sequence of elements that can be processed with operations.
#> Streams are not a data structure.
#> Streams are single case use, meaning once its been acted on it becomes closed off and will throw and error.
#> To be able to reuse a stream you could use a Supplier. Format for Supplier is
#>                 Supplier<Stream<T>> streamSupplier = () -> Stream.of(array) or if you created a Stream instance you can use () -> streamName
#>

*/