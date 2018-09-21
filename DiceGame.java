package dicegame;

import java.util.ArrayList;
import java.util.Collection;

public class DiceGame {

    static int ONES =0; // number of ones rolled.
    static ArrayList<Player> PLAYERS = new ArrayList<Player>();
    private static int tempBank = 0;
    static boolean GAME = true; // gamestate
    static ArrayList<Integer> ROLLS = new ArrayList<Integer>(); // stores the rolls during a players turn
    static int RPT = 2; // rolls per turn.
    static int FACES = 6;
    static boolean bot = false;
    static int turnNumber = 0;
    public static int Goalpost = 100;
    static Player WINNER;

    public static void main(String[] args) {
        //  UI.rules();
        UI.menu();
       if(!GAME){
        return;
       }
        UI.getPlayers();
        int players = PLAYERS.size();
       
        while (GAME) {
            turn(turnNumber % players, PLAYERS.get(turnNumber % players));
            gameIsDone(PLAYERS.get(turnNumber % players));
        }

        //if(WINNER.isBot) DiceBot.Dance();
        

        

        if (WINNER.isBot) {
            DiceBot.Dance();
        }
        UI.scoreScreen();

    }

    public static void printPlayers(ArrayList<Player> players) {
        for (Player n : players) {
            System.out.print("player " + (players.indexOf(n.name) + 1) + ": " + n.name + " ");
        }
    }

    public static void turn(int n, Player p) {
        Dice d6 = new Dice(FACES);

        System.out.println("Player " + (n + 1) + ": " + p.name);

        for (int i = 0; i < RPT; i++) {
            ROLLS.add(d6.roll());
        }
        System.out.println("You rolled:");
        for (int i = 0; i < ROLLS.size(); i++) {
            System.out.println("d" + (i + 1) + ": " + ROLLS.get(i));
        }
        if (ROLLS.contains(1) && sum(ROLLS) != 2) {
            System.out.println("You rolled a SINGLE 1, you lost " + tempBank + " points");
            ROLLS.clear();
            tempBank = 0;
            ONES++;
            turnNumber++;
            p.updStreak();

            if (!p.isBot) {

                if (bot) {
                    DiceBot.Taunt();
                }
                System.out.println("Pres enter to continue to next players turn:");
                UI.getEnter();
            }
            System.out.println("");
            return;
        } else {
            tempBank += UI.valueRoll(ROLLS);
            System.out.println("Your roll is worth " + UI.valueRoll(ROLLS) + ".");
            System.out.println("Giving you a total of " + (p.getBank() + tempBank) + " points.");
            System.out.println("Would you like to continue (Y/N): ");
        }

        if (!p.isBot) {  // pllayer  action
            if (UI.getYN()) {
                p.nxtTurn();
            } else {
                p.addToBank(tempBank);
                turnNumber++;
                tempBank = 0;
                p.updStreak();
                p.newTurn();
            }
        } else {
            if (DiceBot.gamble(tempBank, p.getBank(), p.getCStreak())) {
                p.nxtTurn();
            } else {
                p.addToBank(tempBank);
                turnNumber++;
                System.out.println(p.name + " stops his turn and is now at " + p.getBank() + " points.");
                tempBank = 0;
                p.updStreak();
                p.newTurn();

            }
        }
        ROLLS.clear();
        System.out.println("");
    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static void gameIsDone(Player p) {
        GAME = !(p.getBank() >= Goalpost);
        WINNER = p;
    }
}
