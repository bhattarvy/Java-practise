package designpatterns.structural.decorator.decorators;

public class CompressionDecorator extends DataSourceDecorator{


    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void execute() {
        System.out.println("Compression Decorator");
        super.execute();

    }


}
