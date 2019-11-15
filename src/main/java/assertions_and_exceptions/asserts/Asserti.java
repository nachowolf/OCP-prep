package assertions_and_exceptions.asserts;

import java.sql.SQLException;

public class Asserti {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
//try{
    int number = 2;
    assert(number >= 4): "Number is greater than 4";

//}
//catch (AssertionError ex){
//       ex.printStackTrace();

}

//    }
}
