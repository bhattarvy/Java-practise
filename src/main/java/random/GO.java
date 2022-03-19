package random;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

public class GO {






    public static void main(String[] args) {
       List<Contact> ls = new ArrayList<>();

       for(int i=0; i<3; i++) {
            Contact c= new Contact();
            c.setCampaign(Integer.valueOf(i).toString());
            ls.add(c);
       }

        ls.forEach((e)-> {
            e.setStartDate(12);
            e.setEndDate(123);
        });

        System.out.println("hey this is new code");
    }
}
