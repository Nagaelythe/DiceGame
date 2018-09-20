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
        if (num < min || num > max) {
            System.out.print("Please enter a number between: " + min + " and " + max + ": ");
            num = getNumber(min, max);
        }
        return num;
    }

    public static boolean getYN() {
        return SC.nextLine().toLowerCase().startsWith("y");
    }

    public static void options() {
        // for changing dice size, number of rolls per turn etc.
        boolean showOptions = true;
        while (showOptions) {
            ArrayList<String> options = new ArrayList<String>() {
                {
                    add("      OPTIONS+'\n'");
                    add("What would you like to change?"+'\n');
                    add("1. Number of rolls per turn. Currently: " + DiceGame.RPT+'\n');
                    add("2. Number of faces. Currently: " + DiceGame.FACES+'\n');
                    add("3. Difficulty."+'\n');
                    add("4. Goal number."+'\n');
                    add("5 Exit"+'\n');
                    add("Enter a number to choose:");
                }
            };
            for (String n : options) {
                System.out.print(n);
            }
            switch (getNumber(1, 5)) {
                case 1:
                    System.out.print("How many rolls per turn would you like?" + '\n'
                            + "enter a number: ");
                    DiceGame.RPT = getNumber(1, Integer.MAX_VALUE);
                    break;
                case 2:
                    System.out.println("How many faces would you like the dice to have?" + '\n'
                            + "Dice is currently " + DiceGame.FACES + "-sided.");
                    DiceGame.FACES = getNumber(1, Integer.MAX_VALUE);
                    break;
                case 3:
                    System.out.println("Difficulty has yet to be implemented.");
                    break;
                case 4:
                    System.out.println("Max Number has yet to be implemented.");
                    break;
                case 5:
                    System.out.println("Exiting options.");
                    showOptions = false;
                    break;
            }
        }
    }

    public static void rules() {
        System.out.println(
                "                                           RULES" + '\n'
                + "In this dice game the players take turn rolling " + DiceGame.RPT + " dice and saving the total." + '\n'
                + "You may continue rolling the dice and add to the total until you either save it in the ‘bank’ or roll a 1." + '\n'
                + "If you roll a 1 you lose your points for the turn." + '\n'
                + "If you roll two or more of the same kind, their score will be doubled or tripled and so on." + '\n'
                + "If a player has more than 100 points that player wins." + '\n'
                + "If both players have more than 100 it is the player with the most points who wins." + '\n'
                + "If they have the same amount of points it's a draw");

    }
}
