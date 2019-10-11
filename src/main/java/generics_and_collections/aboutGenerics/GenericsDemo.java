package generics_and_collections.aboutGenerics;

import java.util.ArrayList;
import java.util.List;

//Create own generic
class Pencil<T>{
    T value;

    public Pencil(T val){
        this.value = val;
    }
}

class Pen{}

public class GenericsDemo {
    public static void main(String[] args) {
        int value = 5;
//  type safety (int)
//        List<Integer> values = new ArrayList<Integer>();
//        values.add(7);
//        values.add("String");
//        List sup = ArrayList<? T>();
Pencil<Pen> pencil = new Pencil<>(new Pen());

    }
}
