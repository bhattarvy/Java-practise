package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class JacksonMain {

    public static void main(String[] args) throws JsonProcessingException {
        Customer customer = new Customer();
        customer.setName("Arvind");
        customer.setStandard("12th");

        ObjectMapper objectMapper = new ObjectMapper();



        String customerString = objectMapper.writeValueAsString(customer);

        System.out.println(customerString);

        try {
            FakeCustomer fakeCustomer = objectMapper.readValue(customerString, FakeCustomer.class);

            System.out.println(fakeCustomer.toString());
        } catch (Exception e) {
            //System.out.println(e);
            System.out.println("exception occurred while reading the json object");
        }


        Teacher teacher = new Teacher();
        teacher.setName("Arvind Teacher");
        teacher.customerList = new ArrayList<>();
        teacher.customerList.add(customer);

        // Customer Json String to JsonNode
        JsonNode jsonNode = objectMapper.readTree(customerString);
        System.out.println(jsonNode.toString());
        System.out.println(jsonNode.get("name"));

        String teacherString = objectMapper.writeValueAsString(teacher);
        System.out.println(teacherString);
        jsonNode = objectMapper.readTree(teacherString);
        System.out.println(jsonNode.toString());
        System.out.println(jsonNode.get("customerList").toString());

        List<Customer> customerList = objectMapper.readValue(jsonNode.get("customerList").toString(), new TypeReference<List<Customer>>(){});
        System.out.println(customerList);


        // creating Java Map from Json String
        Map<String , Object> map = objectMapper.readValue(teacherString, new TypeReference<Map<String, Object>>() {});
        System.out.println(map);
        System.out.println(map.get("customerList"));


        // student Map serialization and deserialization that contains a map

        StudentMap studentMap = new StudentMap();
        studentMap.setName("CoolArvind");
        studentMap.setNumbersMap(new HashMap<>());
        studentMap.getNumbersMap().put("science","56");
        studentMap.getNumbersMap().put("maths","70");
        studentMap.getNumbersMap().put("english","60");

        String studentMapString = objectMapper.writeValueAsString(studentMap);
        System.out.println(studentMapString);


        StudentMap studentMaptest1 = objectMapper.readValue(studentMapString, StudentMap.class);
        System.out.println(studentMaptest1);









    }
}
