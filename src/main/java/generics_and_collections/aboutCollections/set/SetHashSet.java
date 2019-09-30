package generics_and_collections.aboutCollections.set;

import java.util.*;

class Pencil{
    private String color;

    public Pencil(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pencil pencil = (Pencil) o;
        return color.equalsIgnoreCase(pencil.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color.toLowerCase());
    }

    @Override
    public String toString() {
        return this.color;
    }
}

public class SetHashSet {
    public static String[] colours = {"red", "blue", "gray", "purple", "pink", "orange", "green", "black", "yellow", "white"};

    public static void redCaps(){
        Set<Pencil> redPencilCrayons = new HashSet();

        Pencil pencil1 = new Pencil("red"),
                pencil2 = new Pencil("Red"),
                pencil3 = new Pencil("rEd"),
                pencil4 = new Pencil("RED"),
                pencil5 = new Pencil("RED");

        redPencilCrayons.add(pencil1);
        redPencilCrayons.add(pencil2);
        redPencilCrayons.add(pencil3);
        redPencilCrayons.add(pencil4);
        redPencilCrayons.add(pencil5);

        System.out.println(redPencilCrayons.size());
        System.out.println(pencil1.equals(pencil2));
    }

    public static void orderOfThings(){
        Set<Pencil> pencilBag = new HashSet<>();

        for(String colour : colours){pencilBag.add(new Pencil(colour));}

        pencilBag.forEach(System.out::println);
    }

    public static void existenceIsFutile(){
        Set<Pencil> pencilBag = new HashSet<>();

        Pencil pencil1 = new Pencil(colours[3]),
               pencil2 = new Pencil(colours[3]);

        System.out.println(pencil1.equals(pencil1));
        System.out.println(pencil2.equals(pencil2));
        System.out.println(pencil1.equals(pencil2));

        pencilBag.add(new Pencil(colours[3]));
        System.out.println( pencilBag.contains(new Pencil[3]));
    }

    public static void countingPencils(){
        Set<Pencil> pencilCase = new HashSet<>();
        for(String colour : colours){
            pencilCase.add(new Pencil(colour));
        }

        Iterator<Pencil> pencilIterator = pencilCase.iterator();
        int counter = 0;

        while (pencilIterator.hasNext()){
            counter++;
            System.out.println("Color: " + pencilIterator.next());
            ;
        }
        System.out.println("Total pencils : " + counter);
    }

        public static void main(String[] args) {

//           redCaps();
//           orderOfThings();
//            existenceIsFutile();
//            countingPencils();

    }

}

//###############################| NOTES |########################################

/*
#| HashSet compares items' HashCodes before deciding whether to add them or not

#| HashSet .contains() method compares object bytecode rather than .equals()

#| HashSet .iterator() provides another way to move through a HasSet

#| HashSet order of items in set is unpredictable

*/