package designpatterns.structural.decorator.decorators;



public class DataSourceDecorator implements DataSource {

    DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Override
    public void execute() {
        dataSource.execute();
    }
}
