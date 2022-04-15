package jackson;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    String name;

    List<Customer> customerList;

}
