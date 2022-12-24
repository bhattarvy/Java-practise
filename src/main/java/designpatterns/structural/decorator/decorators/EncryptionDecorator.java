package designpatterns.structural.decorator.decorators;

public class EncryptionDecorator extends DataSourceDecorator{


    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void execute() {
        System.out.println("Encryption Decorator");
        super.execute();

    }
}
