package LLD;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.tuple.Pair;


import java.util.*;

public class SnakeLadder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of leader board");

        SnakeBoard board = new SnakeBoard(sc.nextInt());

        System.out.println("Set Snake Positions of snaker ladder problem");
        int snakesNumber = sc.nextInt();
        List<SnakePosition> snakePositions = new ArrayList<>();
        Set<Pair<Integer,Integer>> snakePairs = new HashSet<>();

        while(snakesNumber-->0){
            int posHead=sc.nextInt();
            int posTail=sc.nextInt();
            snakePairs.add(Pair.of(posHead, posTail));
            SnakePosition snakePosition = new SnakePosition(posHead,posTail);
            snakePositions.add(snakePosition);
        }
        board.setSnakePositions(snakePositions);

        System.out.println("Enter no of ladder in board");
        int ladderNumbers = sc.nextInt();
        List<LadderPosition> ladderPositions = new ArrayList<>();
        while(ladderNumbers-->0){
            int posX=sc.nextInt();
            int posY = sc.nextInt();
            if(snakePairs.contains(Pair.of(posX,posY))){
                System.out.println("in this position already a snake is sitting, please change the position of this " +
                                   "ladder");
                ladderNumbers++;
                continue;
            }
            LadderPosition laddderPosition = new LadderPosition(posX,posY);
            ladderPositions.add(laddderPosition);
        }
        board.setLadderPositions(ladderPositions);

        int noOfPlayers = sc.nextInt();
        List<Player> players = new ArrayList<>(noOfPlayers);
        Map<String,Integer> playersPosition = new HashMap<>();
        for(int i=0; i<noOfPlayers; i++){
            Player player = new Player("Player - "+(i+1));
            players.add(player);
            playersPosition.put(String.valueOf(player.getId()),0);
        }
        board.setPlayerPositions(playersPosition);
        Queue<Player> queue = new LinkedList<>();
        for(Player player:players){
            queue.add(player);
        }
        board.setPlayerQueue(queue);

    }


}


// Services

class DiceService {
    public int rollDice(){
        return RandomUtils.nextInt(1,7);
    }
}

@AllArgsConstructor
class SnakeLadderService {


    private DiceService diceService;

    public void startGame(SnakeBoard snakeBoard){

        Queue<Player> queue = snakeBoard.getPlayerQueue();
        while(!queue.isEmpty()){
            Player player = queue.peek();
            int diceNumber = diceService.rollDice();
            int newPosition = getNewPositionFromOldPosition(diceNumber,
                    snakeBoard.getPlayerPositions().get(player.getId()),  snakeBoard);
        }
    }

    private int getNewPositionFromOldPosition(int diceNumber, int oldPosition, SnakeBoard board){
        if(oldPosition+diceNumber>board.getSize()){
            return oldPosition;
        } else{
            Optional<SnakePosition> snakePosition =
                    board.getSnakePositions().stream().filter((e)->e.head==(oldPosition+diceNumber)).findFirst();
        }
        return 0;
    }

}



// Entities

@Getter
@Setter
class SnakeBoard {
    private int size;
    private List<SnakePosition> snakePositions;
    private List<LadderPosition> ladderPositions;
    private Queue<Player> playerQueue;
    private Map<String,Integer> playerPositions;
    public SnakeBoard(int size){
        this.size = size;
    }
}

@Getter
class SnakePosition {
    int head;
    int tail;
    public SnakePosition(int x,int y){
        this.head=x;
        this.tail=y;
    }
}

class LadderPosition {
    int head;
    int tail;
    public LadderPosition(int x,int y){
        this.head=x;
        this.tail=y;
    }
}

@Getter
class Player {
    private String name;
    private UUID id;

    public Player(String name){
        this.name=name;
        this.id= UUID.randomUUID();
    }
}

