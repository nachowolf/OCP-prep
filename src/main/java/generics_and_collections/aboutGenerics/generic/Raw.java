package generics_and_collections.aboutGenerics.generic;

//A RAW TYPE IS THE NAME OF A GENERIC CLASS OR INTERFACE WITHOUT TYPE ARGUMENTS
//"unchecked" means that the compiler does not have enough type information to perform all type checks necessary to ensure type safety

class Block<T>{

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}


public class Raw {
    public static void main(String[] args) {
        Block<String> stringBlock = new Block<>(); //GENERIC TYPE
        stringBlock.setT("String");
        System.out.println(stringBlock.getT());

        Block block = new Block();  // RAW TYPE
        block.setT("String");
        System.out.println(block);

      Block<String> blockOfString = new Block<>();
      Block ablock = blockOfString;

      Block anotherBlock = new Block();
      Block<Integer> numBlock = anotherBlock;  //UNCHECK CONVERSION

    }
}
