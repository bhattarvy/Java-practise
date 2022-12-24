package designpatterns.creational.builder;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;

public class Main {

    public static void main(String[] args) {


        Book book = Book.builder().title("sjfd").Author("sfjdfsj").build();
        System.out.println(book.toString());
    }
}
