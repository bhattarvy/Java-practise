package syntaxpratise.enumspractise;

import static syntaxpratise.enumspractise.Apple.GoldenDel;

public class Client {

    public static void main(String[] args) {

        Enum t = Apple.GoldenDel;
        System.out.println(Apple.valueOf("GoldenDel"));
        System.out.println(Apple.values());
        System.out.println(Apple.valueOf(GoldenDel.name()));

    }
}
