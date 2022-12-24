package Java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {


    public void convertStringtoCharStream(){
        String t = "1234adsf$3234";

        IntStream intStream = t.chars();
        StringBuffer ans = new StringBuffer();
        t.chars().mapToObj((e)-> { return (char)(e);}).filter((e)->{ return Character.isDigit(e);}).forEach((e)->{
            ans.append(e);
        });

        System.out.println(ans);
    }

    public List<Contacts> intialiseContactsWithPhoneList(){
        List<Contacts>  contacts = Arrays.asList(
                new Contacts("arvind", Arrays.asList(new Phone[] { new Phone("202", "21323",0) }),""),
                new Contacts("krsna", Arrays.asList(new Phone[] { new Phone("202", "12345",1) }),"")
        );
        return contacts;
    }

    public Set<String> streamFilterWithSet(){
        Set<String> fieldSet =  new HashSet<>(Arrays.asList("jsdnfd","sfkndf","fjngf","customerid"));
        List<String> removableFields = new ArrayList<>(Arrays.asList("customerid"));
        fieldSet=
                fieldSet.stream().filter((e)->{ return !removableFields.contains(e);}).peek((e)-> System.out.println(e)).collect(Collectors.toSet());

        return fieldSet;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.streamFilterWithSet());


        /*
        List<Contacts> contacts = t.intialiseContactsWithPhoneList();
        contacts.stream().filter((e)-> e.getPhoneList() != null && !e.getPhoneList().isEmpty()).forEach((e)->{
            List<Phone> phoneList = e.getPhoneList();
            for(Phone phone: phoneList){
                if(phone.getPhoneType()==0)
                    e.setPrimaryPhone(phone.getPhoneNumber());
            }
        });

        contacts.forEach((contact)->{
            System.out.println(contact);
        });*/

    }





    @Data
    @AllArgsConstructor
    public class Contacts{
        String name;
        List<Phone> phoneList;
        String primaryPhone;
    }

    @Data
    @AllArgsConstructor
    public class Phone{
        String code;
        String phoneNumber;
        int phoneType;
    }

}
