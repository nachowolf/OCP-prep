package streams.dual;


import java.util.Arrays;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DualStreamer {
    public static void main(String[] args) {

//        public class Kata {
//            public static int[] invert(int[] array) {
//                return java.util.Arrays.stream(array).map(i -> -i).toArray();
//            }
//        }


        int[] array = new int[]{-1, 2, -3, 4, -5};

       Arrays.stream(array).boxed().map(i -> -i).forEach(System.out::println);

       String start = "most trees are blue";
       StringBuilder sb = new StringBuilder();
       Arrays.stream(start.split(" ")).map(w -> w = w.split("")[0].toUpperCase().concat(w.substring(1))).forEach(s -> sb.append(s + " "));
        System.out.println(sb.toString());
    }
}
