package generics_and_collections.aboutGenerics;

public class GenericLee {



    public static<T> void printer(T[] x){
        for(T t : x){
            System.out.printf("%s \n\n", t);
        }
    }

    public static void main(String[] args) {
        String[] s = {"hello", "WOrld", "ROPER"};
        Integer[] i = {12,46,54,48,49};
        Boolean[] b = {true, true, false, true, false};

        printer(s);
        printer(i);
        printer(b);
    }
}
