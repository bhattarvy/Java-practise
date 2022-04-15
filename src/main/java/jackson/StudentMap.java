package jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class StudentMap {

    @JsonProperty("Student Name")
    String name;

    @JsonIgnore
    int isTopper;

    Map<String, String> numbersMap;
}
