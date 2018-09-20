package dicegame;

import java.util.ArrayList;

public class DiceGame {

    static int ONES; // number of ones rolled.
    static ArrayList<Player> PLAYERS = new ArrayList<Player>();
    private static int tempBank = 0;
    static boolean GAME = true; // gamestate
    static ArrayList<Integer> ROLLS = new ArrayList<Integer>(); // stores the rolls during a players turn
    static int RPT = 2; // rolls per turn.
    static int FACES = 6;

    static int turnNumber = 0;

    public static void main(String[] args) {
        //  UI.rules();
        UI.menu();
        UI.getPlayers();

        int players = PLAYERS.size();

        UI.options();
        while (GAME) {
            PLAYERS.get(turnNumber % players).newTurn();
            turn(turnNumber % players, PLAYERS.get(turnNumber % players));
        }
        printPlayers(PLAYERS);

    }

    public static void printPlayers(ArrayList<Player> players) {
        for (Player n : players) {
            System.out.print("player " + (players.indexOf(n.name) + 1) + ": " + n.name + " ");
        }
    }

    public static void turn(int n, Player p) {
        Dice d6 = new Dice(FACES);

        System.out.println("Player " + (n + 1) + ": " + p.name);
        System.out.println("Player " + (PLAYERS.indexOf(p.name) + 1) + ": " + p.name);

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
            turnNumber++;
            p.updStreak();
            System.out.println("Pres enter to continue to next players turn:");
            UI.getYN();
            return;
        } else {
            tempBank += sum(ROLLS);
            System.out.println("Your roll is worth " + UI.valueRoll(ROLLS) + ".");
            System.out.println("Giving you a total of " + (p.getBank() + tempBank) + " points.");
            System.out.print("Would you like to continue (Y/N): ");
        }

        if (UI.getYN()) {
            p.nxtTurn();
        } else {
            p.addToBank(tempBank);
            turnNumber++;
            tempBank = 0;
            p.updStreak();
        }
        ROLLS.clear();

    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

}
