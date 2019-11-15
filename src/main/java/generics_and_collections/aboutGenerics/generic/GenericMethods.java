package generics_and_collections.aboutGenerics.generic;


//Generic Method to compare pairs
class Util{
    public static <K, V> boolean compare(PairPots<K,V> p1 , PairPots<K,V> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

class PairPots<K, V>{
    private K key;
    private V value;

    public PairPots(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericMethods {
    public static void main(String[] args) {
        PairPots<Integer, String> pot1 = new PairPots<>(5,"Stainless");
        PairPots<Integer, String> pot2 = new PairPots<>(4,"Cast Iron");
        boolean val = Util.compare(pot1, pot2);
        System.out.println(val);
    }
}
