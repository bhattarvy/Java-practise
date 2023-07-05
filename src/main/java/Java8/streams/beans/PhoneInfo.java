package Java8.streams.beans;

import com.sun.org.apache.xpath.internal.operations.Bool;
import designpatterns.creational.builder.Book;
import lombok.*;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PhoneInfo {

    private String number;

    private boolean isPrimary;
    private Boolean checkInfo;
    private Boolean presentInNDNCList = null;

    @Override
    public String toString() {
        return "PhoneInfo{" + "number='" + number + '\'' + ", isPrimary=" + isPrimary + ", presentInNDNCList=" +
               presentInNDNCList + '}';
    }


}
