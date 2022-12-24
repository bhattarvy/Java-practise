package designpatterns.structural.decorator;


import designpatterns.structural.decorator.decorators.*;


public class Main {


    public static void main(String[] args) {

        DataSource fileDataSource = new FileDataSource();
        DataSourceDecorator dataSourceDecoratorEncrypt = new EncryptionDecorator( fileDataSource);
        dataSourceDecoratorEncrypt.execute();


        System.out.println("------");

        DataSourceDecorator dataSourceDecoratorDecrypt = new DecryptionDecorator(new EncryptionDecorator(fileDataSource));
        dataSourceDecoratorDecrypt.execute();
    }

}
