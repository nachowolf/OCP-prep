package generics_and_collections.aboutCollections.list;


import generics_and_collections.dummy.marbles.*;
import static generics_and_collections.dummy.colors.Color.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


//Comparator class to sort marbles by reverse alphabetical colour

public class ListArrayList {

    public static void main(String[] args) {

        List<Marble> bag = new ArrayList();
        bag.add(new Marble(RED));
        bag.add(new Marble(BLUE));
        bag.add(new Marble(BLUE));
        bag.add(new Marble(BLUE));
        bag.add(new Marble(RED));
        bag.add(new Marble(GREEN));
        bag.add(new Marble(BLACK));
        bag.add(new Marble(WHITE));
        bag.add(new Marble(WHITE));
        bag.add(new Marble(BLACK));
        bag.add(new Marble(PURPLE));
        bag.add(new Marble(YELLOW));
        bag.add(new Marble(YELLOW));
        bag.add(new Marble(ORANGE));
        bag.add(new Marble(PURPLE));
        bag.add(new Marble(RED));
        bag.add(new Marble(RED));
        bag.add(new Marble(GREEN));
        bag.add(new Marble(WHITE));
        bag.add(new Marble(GREEN));
        bag.add(new Marble(BLUE));

        List<Marble> duplicate = bag.stream().collect(Collectors.toList());

        System.out.printf("Total marbles in bag: %s\n", bag.size());
        System.out.printf("Index of first blue marble in the bag: %s\n",bag.indexOf(new Marble(BLUE)));
        System.out.printf("%s\n", bag.get(bag.indexOf(new Marble(BLUE))));
        bag.set(bag.indexOf(new Marble(BLUE)), new Marble(ORANGE));
        System.out.printf("Blue marble at index 1 has been replaced with an Orange marble: %s\n\n", bag.get(1));

        System.out.println("Original ArrayList");
        bag.stream().forEach(System.out::println);

        System.out.println("\nArraylist with blue marbles that has been removed\n");
        bag.removeIf(marble -> marble.getColor().equals(BLUE));
        bag.forEach(System.out::println);

        System.out.println("\nReplace all marbles with white marbles using lambda\n");
        System.out.println("Original ArrayList");
        bag.stream().forEach(System.out::println);
        System.out.println();
        bag.replaceAll(marble -> new Marble(WHITE));

        System.out.println("WHite marble ArrayList");
        bag.stream().forEach(System.out::println);

        System.out.println("\nReplace all white marbles with purple marbles using custom UnaryOperator\n");

        System.out.println("Original ArrayList");
        bag.stream().forEach(System.out::println);
        System.out.println();
        bag.replaceAll(new Purplify());

        System.out.println("Purple marble ArrayList");
        bag.stream().forEach(System.out::println);
        System.out.println("Original ArrayList: \n");
        duplicate.forEach(System.out::println);
        System.out.println();
        System.out.println("ordered ArrayList: ");
        duplicate.sort(new AlphabetiColorOrder());
        duplicate.forEach(System.out::println);

        System.out.println("\nReverse alphabetical colours");

        Comparator<Marble> sortMeMarbles = ( m1,  m2) -> m1.getColor().compareTo(m2.getColor()) * -1;
        duplicate.sort(sortMeMarbles);

        duplicate.forEach(System.out::println);

        System.out.println();

       duplicate.sort(new ColorLengthSorter());
       duplicate.forEach(System.out::println);

    }
}

/*
####################| NOTES |####################

# Functional Interfaces can work with overloaded constructors

#################################################
 */
