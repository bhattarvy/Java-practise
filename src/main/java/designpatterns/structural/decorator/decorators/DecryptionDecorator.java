package designpatterns.structural.decorator.decorators;


public class DecryptionDecorator extends DataSourceDecorator {


    public DecryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void execute() {
        System.out.println("Decryption Decorator");
        super.execute();
    }
}
