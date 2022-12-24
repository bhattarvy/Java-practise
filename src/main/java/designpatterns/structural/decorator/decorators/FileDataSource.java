package designpatterns.structural.decorator.decorators;


public class FileDataSource implements DataSource {

    @Override
    public void execute() {
        System.out.println("FileDataSource");
    }
}


/*



 */