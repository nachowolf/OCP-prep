package generics_and_collections.aboutGenerics.generic;



class NonGenericBox{
    private Object object;
    public void set(Object object){this.object = object;}
    public Object get(){return object;}
}

class GenericBox<T>{
    private T t;

    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }

}
/*
* E - Element
* K - Key
* N - Number
* T - Type
* V - Value
* S, U, V - 2nd, 3rd,4th types
* */

//Generic pair interface

    interface Pair<K,V>{
         K getKey();
         V getValue();
    }

    class PairedBox<K,V> implements Pair<K,V>{

        private K key;
        private V value;

        public PairedBox(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }


public class Box {
    public static void main(String[] args) {

//     ######| NON GENERIC BOX |#####
        NonGenericBox nonGenericBox = new NonGenericBox();
        nonGenericBox.set(new Object());
        System.out.println(nonGenericBox.get());

        nonGenericBox.set(new Integer(5));
        System.out.println(nonGenericBox.get());

        nonGenericBox.set(new String("String"));
        System.out.println(nonGenericBox.get());

//        !!!!!!!!!!  TYPE CANT BE SPECIFIED LIKE THIS !!!!!!!!!!

//        ##########| GENERIC BOX |##########
        GenericBox<String> genericBox = new GenericBox<>();
        genericBox.set("String");
        System.out.println(genericBox.get());

//        genericBox.set(5);   <--- Error if try to set a non String value

//        ##########| GENERIC INTERFACE PAIR BOX|##########
        PairedBox<String, Integer> boxKey = new PairedBox<>("Golden Key", 3);
        System.out.println(boxKey.getKey() + " : " + boxKey.getValue());
    }
}

