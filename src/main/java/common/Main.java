package common;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {

    public static void main(String[] args) {

        String s ="";
        System.out.println(s.toUpperCase());
        String t="";
        if (s == t) {
            System.out.println("yeah empty");
        }


        DealerMaster dealerMaster1 = new DealerMaster("GMotors", "English");
        DealerMaster dealerMaster2 = null;

        System.out.println("this is main method");
        try {
            if (dealerMaster1 == null && dealerMaster1.getLanguage() != "English")
                System.out.println("Passed 1");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("first case");
        }
        try {
            if (dealerMaster2 == null || dealerMaster2.getLanguage() != "English")
                System.out.println("Passed2");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            if(dealerMaster2 != null && dealerMaster2.getLanguage()!="ENGLISH")
                System.out.println("Passed3");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

@Data
@AllArgsConstructor
class DealerMaster {
    String name;
    String language;
}
