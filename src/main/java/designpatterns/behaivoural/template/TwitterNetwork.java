package designpatterns.behaivoural.template;

public class TwitterNetwork extends Network{


    @Override
    void login(String userName, String passWord) {
        System.out.println("Twitter Loging in");
        System.out.println("username : "+ userName+" \n password : "+ passWord);
    }

    @Override
    void logout() {
        System.out.println("Twitter logging out");
        System.out.println("username : "+ userName+" \n password : "+ passWord);

    }

    @Override
    void sendData(String data) {
        System.out.println("Twitter Data sending: "+ data);
    }

}
