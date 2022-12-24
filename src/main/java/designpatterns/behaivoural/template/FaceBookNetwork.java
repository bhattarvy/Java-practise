package designpatterns.behaivoural.template;

public class FaceBookNetwork extends Network{
    @Override
    void login(String userName, String passWord) {
        System.out.println("Facebook Loging in");
        System.out.println("username : "+ userName+" \n password : "+ passWord);
        this.userName=userName;
        this.passWord=passWord;
    }

    @Override
    void logout() {
        System.out.println("Facebook logging out");
        System.out.println("username : "+ userName+" \n password : "+ passWord);
    }

    @Override
    void sendData(String data) {
        System.out.println("Facebook Data sending: "+ data);
    }
}
