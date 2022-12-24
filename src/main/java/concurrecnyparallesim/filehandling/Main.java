package concurrecnyparallesim.filehandling;

import concurrecnyparallesim.filehandling.emlreader.EmlReader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        try {
            File file = File.createTempFile("temp",".eml");
            Path path = file.toPath();
            /*EmlReader emlReader = new EmlReader();
            String fileName = "/Users/arvind/Desktop/sampleDevFile/sample.eml";
            emlReader.readFile(fileName);*/
        } catch (Exception e){
            System.out.println("Exceptipon occured : " + e);
        }

    }

}
