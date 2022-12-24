package designpatterns.creational.builder;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class Book {

    private String title;
    private String Author;
}
