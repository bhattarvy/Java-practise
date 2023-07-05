package designpatternsudemycourse.solid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SRP {

    public static void main(String[] args) throws IOException {


        /*
        * Here Journal Class follows Responsibility Principle - as functions are related to journal only
        * if we have created persistence function also inside the journal that would be wrong and voilates the SRP
        * Principle.
        *
        * JournalDAO contains the persistenc function and that is correct way
        * Class should contain functions that are applicable to it no extra functions should be there.
        *
        * */

        Journal journal = new Journal();
        journal.addEntry("I cried today");
        journal.addEntry("I laughed today");
        journal.addEntry("I again cried after");

        JournalDAO journalDAO = new JournalDAO();
        String fileName = "testFileName.txt";
        journalDAO.save(journal, fileName);

        Runtime.getRuntime().exec(fileName);
    }
}


class Journal {
    public List<String> enteries = new ArrayList<>();
    public static int count=0;

    public void addEntry(String text){
        this.enteries.add("entry : "+ count + " "+text);
    }
    public void removeEntry(int index){
        this.enteries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator()+enteries);
    }
}

class JournalDAO {
    public void save(Journal journal, String fileName) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(fileName)){
            out.println(journal.toString());
        }
    }
}

