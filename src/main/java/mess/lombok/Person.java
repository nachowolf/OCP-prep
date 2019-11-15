package mess.lombok;

import lombok.*;

import java.io.Serializable;

@Builder
@ToString
@Getter
public class Person {

    private String name;
    private Integer age;
}
