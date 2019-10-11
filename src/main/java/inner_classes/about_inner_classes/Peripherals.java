package inner_classes.about_inner_classes;

public class Peripherals {

    private String foo = "WOOO IT WORKS";

  class USB{
        public void staticPrint(){
            System.out.println("USB Static");
        }

        public void print(){
            System.out.println("USB");
        }
    }

  class HeadPhones{
        public  void print() {
            System.out.println("Headphones");
        }
    }

  class bar{
        public void print(){
            System.out.println(foo);
        }
  }

//  class []

}
