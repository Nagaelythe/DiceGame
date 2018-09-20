package dicegame;

import java.util.ArrayList;

public class DiceGame {

    static int ONES; // number of ones rolled.
    static ArrayList<Player> PLAYERS = new ArrayList<Player>();
    private static ArrayList<Integer> tempBank = new ArrayList<Integer>();
    static boolean GAME = true; // gamestate
    static ArrayList<Integer> ROLLS = new ArrayList<Integer>(); // stores the rolls during a players turn
    static int RPT = 2; // rolls per turn.
    static int FACES = 6;

    public static void main(String[] args) {
        UI.getPlayers();
        int turnNumber = 0;

        while (GAME) {
            turn(turnNumber, PLAYERS.get(turnNumber));

            if (turnNumber < PLAYERS.size()) {
                turnNumber++;
            } else {
                turnNumber = 0;
            }
        }
        printPlayers(PLAYERS);
    }

    public static void printPlayers(ArrayList<Player> players) {
        for (Player n : players) {
            System.out.print("player " + (players.indexOf(n) + 1) + ": " + n.name + " ");
        }
    }

    public static void turn(int n, Player p) {
        Dice d6 = new Dice(FACES);
        System.out.println("Player " + (n + 1) + ": " + p.name);

        for (int i = 0; i < RPT; i++) {
            ROLLS.add(d6.roll());
        }
        System.out.println("You rolled:");
        for (int r : ROLLS) {
            System.out.println("d" + (ROLLS.indexOf(r) + 1) + ": " + r);
        }
        if (ROLLS.contains(1)) {
            System.out.println("You rolled a 1, bank cleared.");
            ROLLS.clear();

        } else {
            System.out.println("Would you like to keep any? (Y/N)" + '\n');
        }
        if (UI.getYN()) {
            System.out.print("Which die would you like to keep?" + '\n'
                    + "Enter a number: ");
            tempBank.add(ROLLS.get(UI.getNumber(1, ROLLS.size()) - 1));
        }
        p.addToBank(ROLLS);
        ROLLS.clear();
    }

    public static void options() {
        // for changing dice size, number of rolls per turn etc.
    }
}
