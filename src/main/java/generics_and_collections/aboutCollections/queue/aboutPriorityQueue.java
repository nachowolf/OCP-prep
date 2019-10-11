package generics_and_collections.aboutCollections.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class aboutPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Customer> customerQueue = new PriorityQueue<>();
        customerQueue.add(new Customer(3, "John"));
        customerQueue.add(new Customer(5, "Jack"));
        customerQueue.add(new Customer(1, "Jill"));
        customerQueue.add(new Customer(1, "Susan"));
        customerQueue.add(new Customer(45, "Edward"));
        customerQueue.add(new Customer(7, "Katy"));
        customerQueue.add(new Customer(3, "Lucy"));

        System.out.println(customerQueue.size());

//        Iterator<Customer> queue = customerQueue.iterator();
//        while(queue.hasNext()){
//            System.out.println( customerQueue.poll().toString());
//        }
        customerQueue.forEach(System.out::println);
        customerQueue.poll();
        customerQueue.forEach(System.out::println);
//        customerQueue.poll().;
    }
}

class Customer implements Comparable<Customer>{

    private int rank;
    private String name;

    public Customer(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Customer c) {
        if(rank < c.rank)
            return -1;
        else if(rank > c.rank)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return ("Customer name: " + name + ", rank: " + rank);
    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
