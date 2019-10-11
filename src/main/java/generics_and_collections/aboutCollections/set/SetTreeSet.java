package generics_and_collections.aboutCollections.set;

import java.util.Set;
import java.util.TreeSet;

public class SetTreeSet {


    public static void main(String[] args) {
//        TreeSet<Integer> ferryTime = new TreeSet<>();
//        ferryTime.add(1400);
//        ferryTime.add(1800);
//        ferryTime.add(1750);
//        ferryTime.add(1300);
//
//        ferryTime.descendingSet().forEach(System.out::println);
//        System.out.println();
//        ferryTime.forEach(System.out::println);
//

        TreeSet<String> names = new TreeSet<>();
        names.add("Bob");
        names.add("Andy");
        names.add("andy");
        names.add("Zandy");

        System.out.println("Total :" + names.size());
        names.forEach(System.out::println);
        System.out.println();
        names.descendingSet().forEach(System.out::println);
        names.pollFirst();
        System.out.println("Total : " + names.size());


    }
}

//###############################| NOTES |########################################

/*
#| Integers are ordered in ascending order by default

#| Strings are sorted in Lexicographic order starting from Capital letters to small letters


*/
