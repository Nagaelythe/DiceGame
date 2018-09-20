package dicegame;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    static ArrayList<Integer> ROLLS = new ArrayList<Integer>(); // stores the rolls during a players turn
    static int RPT = 2; // rolls per turn.
    static int FACES = 6;
    private static final Scanner SC = new Scanner(System.in);
    private static ArrayList<Integer> tempBank = new ArrayList<Integer>();


    public static void getPlayers() {
        /* gets the number of players as well as their 
names and saves them in an ArrayList of Players.*/
        System.out.print("Please enter the number of players: ");
        int n = Integer.parseInt(SC.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.print("Please enter the name of Player " + i + ": ");
            DiceGame.PLAYERS.add(new Player(SC.nextLine()));
        }
    }

    public static int getNumber(int min, int max) {
        int num = Integer.parseInt(SC.nextLine());
        if (num <= min && num >= max) {
            System.out.print("Please enter a number between: " + min + " and + " + max + ": ");
            num = getNumber(min, max);
        }
        return num;
    }

    public static boolean getYN() {
        return SC.nextLine().toLowerCase().startsWith("y");
    }

        public static void options() {
        // for changing dice size, number of rolls per turn etc.
    }
    
    public static void rules(){
        
    }
     public static void turn(int n, Player p) {
        Dice d6 = new Dice(FACES);
        System.out.println("Player: " + n + ": " + p.name);

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
    
}
