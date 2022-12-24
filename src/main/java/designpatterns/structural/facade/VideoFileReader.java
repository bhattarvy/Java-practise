package designpatterns.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class VideoFileReader {

    public List<Integer> readVidoeFile() {
        List<Integer> ar= new ArrayList<>();
        ar.add(1);ar.add(3);ar.add(4);
        return ar;
    }
}
