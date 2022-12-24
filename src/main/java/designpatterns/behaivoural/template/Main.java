package designpatterns.behaivoural.template;


public class Main {

    public static void main(String[] args) {

        Network faceNetwork =  new FaceBookNetwork();
        Network twitNetwork = new TwitterNetwork();

        faceNetwork.login("arvind","pass");
        twitNetwork.login("arvind","pass");


        faceNetwork.post("arvind","pass","facedata");
        twitNetwork.post("arvind","pass","facedata");


    }

}
