package designpatterns.behaivoural.template;

public abstract class Network {

    String userName;
    String passWord;

    abstract void login(String userName,String passWord );
    abstract void logout();
    abstract void sendData(String data);

    void post(String userName, String passWord, String data) {

        if(userName==this.userName && this.passWord==passWord){

            sendData(data);
        } else {
            System.out.println("invalid creds");
            logout();
        }
    }





}


/*

    <|c|>
    Network
    -login() - depends to Concrete Network class
    -post() -  use login cred and sendData function but not directly depends on concrete network class
    -logout() - depends directly on concrete network class
    -sendData() - dependds on concrete network class




 */