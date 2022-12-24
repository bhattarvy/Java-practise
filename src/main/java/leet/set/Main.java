package leet.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {

        playWithSet();

    }

    public static void playWithSet(){

        Set<String> st = new TreeSet<>();
        st.add("10");
        st.add("3");
        st.add("6");

        st.forEach(e-> System.out.println(e));
    }
}
