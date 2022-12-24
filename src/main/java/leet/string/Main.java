package leet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Leet1 leet1 = new Leet1();
        leet1.solve1592();

    }


    public void switchCaseWithConditions(){

        List<String> mlTags = new ArrayList<>(Arrays.asList("Service Readiness - Top-100",
                "Sales Readiness Top-100"));

        for(String tag : mlTags){

            if(tag.contains("Top")){
                tag = tag.substring(tag.indexOf("Top"));
            }
            if(tag.contains("All"))
                tag = tag.substring(tag.indexOf("All"));



        }
    }

}
