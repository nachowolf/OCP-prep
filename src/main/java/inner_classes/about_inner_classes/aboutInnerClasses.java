package inner_classes.about_inner_classes;
import  inner_classes.about_inner_classes.Peripherals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Computer{
     class Mouse{
        class RightClick {
            public void print(){
                System.out.println("Right Click");
            }
        }
        class LeftClick {
            public void print(){
                System.out.println("Left Click");
            }
        }
        class Scroller {
            public void print(){
                System.out.println("Scroll");
            }
        }
         public void print(){
             System.out.println("Mouse");
         }

    }
     class KeyBoard{
         public void print(){
             System.out.println("Keyboard");
         }
     }
     class Screen{
         public void print(){
             System.out.println("Screen");
         }
     }
     class Speaker{
         public void print(){
             System.out.println("Speaker");
         }
     }

    public void print(){
        System.out.println("Computer");
    }
}

public class aboutInnerClasses {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Computer.Mouse mouse = computer.new Mouse();
        Peripherals peripherals = new Peripherals();

//        USB.staticPrint();
//        Peripherals.HeadPhones.print();
//
//        USB usb = new USB();
//        usb.print();

        Peripherals.bar test = peripherals.new bar();
        test.print();


        List<String> tr = new ArrayList<>();
        tr.add("Hello");
        tr.add("ruffle");
        tr.add("Symphony");

        List<String> s = tr.stream().filter(i-> i.startsWith("H")).collect(Collectors.toList());
        s.forEach(System.out::println);






    }
}
