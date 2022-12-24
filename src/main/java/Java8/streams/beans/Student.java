package Java8.streams.beans;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String name;
    private int rollNo;
    List<PhoneInfo> phoneInfoList;
}
