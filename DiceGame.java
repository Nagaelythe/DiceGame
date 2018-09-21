package dicegame;

import java.util.ArrayList;
import java.util.Collection;

public class DiceGame {

    static int ONES = 0; // number of ones rolled.
    static ArrayList<Player> PLAYERS = new ArrayList<Player>(); // Players array.
    private static int tempBank = 0; // temp bank variable. Should be made local but not possible with current game loop.
    static boolean GAME = true; // gamestate
    static ArrayList<Integer> ROLLS = new ArrayList<Integer>(); // stores the rolls during a players turn
    static int RPT = 2; // rolls per turn.
    static int FACES = 6; //The amount of faces on the dice. Standard is 6, can be changed from UI.menu
    static boolean bot = false; //falg to check if there is a bot.
    static int turnNumber = 0; // how many turns have passed, Should be read as turnNumber+1 to acurately represent the turn.
    public static int Goalpost = 100; // Amount of points Req to win the game.
    static Player WINNER; // when we find a winner.

    public static void main(String[] args) { // Main Game Loop
        //  UI.rules();
        UI.menu(); // setting up the game.
        if (!GAME) { // checking to se if we should run the game at all
            return;
        }
        UI.getPlayers(); // Initialising player array
        int players = PLAYERS.size();

        while (GAME) {// main Game loop.
            turn(turnNumber % players, PLAYERS.get(turnNumber % players));
            gameIsDone(PLAYERS.get(turnNumber % players)); // Check if the game is done.
        }

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
        UI.dispRolls();

        if (ROLLS.contains(1) && sum(ROLLS) != RPT) {
            lossTurn(p);
            if (!p.isBot) { // checking if player is a bot.
                if (bot) { // checking if there is a bot.
                    DiceBot.Taunt();
                }
                System.out.println("Pres enter to continue to next players turn:");
                UI.getEnter();
            }
            System.out.println("");
            return;
        } else {
            tempBank += UI.valueRoll(ROLLS);
            System.out.println("Giving you a total of " + (p.getBank() + tempBank) + " points.");
            System.out.println("Would you like to continue? ");
        }

        Play(p);

        ROLLS.clear();
        System.out.println("");
    }

    public static void lossTurn(Player p) {
        System.out.println("You rolled a SINGLE 1, you lost " + tempBank + " points");
        ROLLS.clear();
        tempBank = 0;
        ONES++;
        turnNumber++;
        p.updStreak();
    }

    public static void endTurn(Player p) {
        p.addToBank(tempBank);
        turnNumber++;
        System.out.println(p.name + " stops his turn and is now at " + p.getBank() + " points.");
        tempBank = 0;
        p.updStreak();
        p.newTurn();

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

    public static void Play(Player p) {
        if (!p.isBot) {  // pllayer  action
            if (UI.getYN()) {
                p.nxtTurn();
            } else {
                endTurn(p);
            }
        } else {
            if (DiceBot.gamble(tempBank, p.getBank(), p.getCStreak())) {
                p.nxtTurn();
            } else {
                endTurn(p);

            }
        }
    }

}
