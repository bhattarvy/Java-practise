package designpatterns.structural.facade;

import java.util.List;

public class MPEGCompressor {

    public List<Integer> doCompressor(List<Integer> ar){

        ar.forEach((e)->{
            e=e*e;
        });
        return ar;

    }
}
