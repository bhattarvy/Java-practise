package LLD.conceptandcoding.snakeladder;


import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SnakeApplication {

    public static void main(String[] args) {
        SnakeApplication snakeApplication = new SnakeApplication();
        snakeApplication.run();
    }

    void run(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Size of the board");
        int size = sc.nextInt();
        Position[] position = new Position[size];


        System.out.println("Enter number of snakes");
        int snakeNo = sc.nextInt();

        while(snakeNo-- >0){
            int x= sc.nextInt();
            position[x].snake.from = sc.nextInt();
            position[x].snake.to = sc.nextInt();
        }

        System.out.println("Enter ladder information");
        int ladderNo = sc.nextInt();

        while(ladderNo -- > 0){
            int x= sc.nextInt();
            position[x].ladder.from =sc.nextInt();
            position[x].ladder.to =sc.nextInt();
        }

        List<Dice> diceList = new ArrayList<>();
        System.out.println("Enter dice info");
        int diceNo= sc.nextInt();
        diceList.add(new Dice6());
        diceList.add(new Dice8());

        Board board = new Board(size,position,diceList);

        System.out.println("enter player information");
        int playerNo = sc.nextInt();
        List<Player> playersList = Arrays.asList(new Player("1","arvind",false,0,null), new Player("2","bhatt",
                false,0,null));



        Application application = new Application(board, playersList);

        //create Service Classes objects
        DiceService diceService = new DiceService();
        SnakeService snakeService = new SnakeService();
        LadderService ladderService = new LadderService();
        PlayerService playerService = new PlayerService();

        SystemService systemService  = new SystemService(application,playerService,snakeService,ladderService);
        systemService.play();
    }

}


// Models


@Data
@AllArgsConstructor
class Snake{
    int from;
    int to;
}

@Data
@AllArgsConstructor
class Ladder{
    int from;
    int to;
}

@Data
@AllArgsConstructor
class Player{
    String playerId;
    String name;
    boolean finished = false;
    int rank;
    Position position = new Position(-1,null,null);
}


interface Dice{
    int rollDice();
}

class Dice6 implements  Dice{


    @Override
    public int rollDice() {
        return 0;
    }
}

class Dice8 implements Dice {

    @Override
    public int rollDice() {
        return 0;
    }
}

@Data
@AllArgsConstructor
class Board{
    int size;
    Position[] positions;
    List<Dice> diceList;
}


@Data
@AllArgsConstructor
class Application {
    private Board board;
    private List<Player> players;
}




@Data
@AllArgsConstructor
class Position{
    int pos;
    Snake snake;
    Ladder ladder;
}



// Services
@Data
@AllArgsConstructor
class SystemService {

    Application application;

    PlayerService playerService;

    SnakeService snakeService;

    LadderService ladderService;


    void play(){

        List<Player> playerList = application.getPlayers();
        for(int i=0; i<playerList.size(); i++){

            int jumps = playerService.rollDice(playerList.get(i), application.getBoard().diceList);

            Player player = playerList.get(i);
            playerService.setNewPosition(player, jumps, application.getBoard());
            snakeService.checkSnake(player,application.getBoard());
            ladderService.checkLadder(player,application.getBoard());

            if(player.getPosition().getPos()>=application.getBoard().size)
                player.setFinished(true);



            if(checkWinningMove())
                break;
            if(i==playerList.size()-1)
                i=0;
        }
    }


    boolean checkWinningMove(){
        // Winnign move is that all player has finished the game
        for(int i=0; i<application.getPlayers().size(); i++){
            if(!application.getPlayers().get(i).finished)
                return false;
        }
        return true;
    }

}

class DiceService {
    int rollDice(Dice dice){
        return 0;
    }
}

class PlayerService {

    DiceService diceService;

    int rollDice(Player player, List<Dice> diceList){
        int x=0;
        for(int i=0; i<diceList.size(); i++){
            x+=diceService.rollDice(diceList.get(i));
        }

        return x;
    }

    void setNewPosition(Player player, int jumps, Board board){
        int x= player.getPosition().pos+jumps;
        Position position= board.getPositions()[x];
        player.setPosition(position);
    }
}

class SnakeService {


    void checkSnake(Player player, Board board){
        Position position = player.getPosition();
        if(position.snake!=null){
            int to  = position.getSnake().getTo();
            position=board.getPositions()[to];

        }
        player.setPosition(position);
    }

}

class LadderService {

    void checkLadder(Player player, Board board){
        Position position = player.getPosition();
        if(position.getLadder()!=null){
            int to = position.getLadder().getTo();
            position = board.getPositions()[to];
        }
        player.setPosition(position);
    }
}



