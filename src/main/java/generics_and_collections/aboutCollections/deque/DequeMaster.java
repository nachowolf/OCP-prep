package generics_and_collections.aboutCollections.deque;

import java.util.*;

class Customer{
    private int totalItems;

    public Customer(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    @Override
    public String toString() {
        return String.format("This customer has %d %s", this.totalItems, this.totalItems == 1 ? "item" : "items");
    }
}

public class DequeMaster {



    public static void main(String[] args) {
        Deque<Customer> shop = new ArrayDeque<>();

//      ADDS ITEMS TO THE FRONT OF A DEQUE
        shop.addFirst(new Customer(1));
        shop.offerFirst(new Customer(2));   // returns boolean

//        ADDS ITEMS TO THE BACK OF A DEQUE
        shop.addLast(new Customer(10));
        shop.offerLast(new Customer(11));      //returns boolean

//        offer methods are preferred if deque restriction is set else exception is thrown

        //REMOVES ITEMS from THE FRONT OF A DEQUE
//        shop.removeFirst();
//        shop.pollFirst();

//        REMOVES ITEMS from THE BACK OF A DEQUE
//        shop.removeLast();
        System.out.println(shop.size());
        System.out.println(shop.peekLast());
        System.out.println( "here " + shop.pollLast());
        System.out.println( "here " + shop.pollLast());
        System.out.println(shop.size());



//        RETURNS THE FIRST ITEM IN A LIST
//        System.out.println(shop.getFirst());



        System.out.println();
        shop.forEach(System.out::println);
    }
}
