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
        int n = getNumber(1, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            System.out.print("To create a bot, type \"Bot \" + name of the bot." + '\n'
                    + "Please enter the name of Player " + i + ": ");
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
        String input = SC.nextLine();
        
        if (input.toLowerCase().startsWith("y")) {
            return true;
        }else if (input.toLowerCase().startsWith("n")) {
            return false;
        }
        System.out.print("Please enter Y/N: ");
        return getYN();
    }
    

    public static void getEnter() {
        SC.nextLine();
    }
    
    public static void options() {
        // for changing dice size, number of rolls per turn etc.
        boolean showOptions = true;
        while (showOptions) {
            ArrayList<String> options = new ArrayList<String>() {
                {
                    add("      OPTIONS" + '\n');
                    add("What would you like to change? " + '\n');
                    add("1. Number of rolls per turn. Currently: " + DiceGame.RPT + '\n');
                    add("2. Number of faces. Currently: " + DiceGame.FACES + '\n');
                    add("3. Difficulty." + '\n');
                    add("4. Goal number." + '\n');
                    add("5. Exit Options" + '\n');
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
                    System.out.println("Difficulty has yet to be implemented." + '\n'
                            + "Press enter to continue.");
                    getEnter();
                    break;
                case 4:
                    System.out.print("Enter your desired goal mumber: ");
                    DiceGame.Goalpost = getNumber(1, Integer.MAX_VALUE);
                    break;
                case 5:
                    System.out.println("Exiting options.");
                    showOptions = false;
                    break;
            }
        }
        menu();
    }

    public static void rules() {
        System.out.print(
                "                                           RULES" + '\n'
                + "In this dice game the players take turn rolling " + DiceGame.RPT + " dice and saving the total." + '\n'
                + "You may continue rolling the dice and add to the total until you either save it in the ‘bank’ or roll a 1." + '\n'
                + "If you roll a 1 you lose your points for the turn." + '\n'
                + "If you roll two or more of the same kind, their score will be doubled or tripled and so on." + '\n'
                + "If a player has more than 100 points that player wins." + '\n'
                + "If both players have more than 100 it is the player with the most points who wins." + '\n'
                + "If they have the same amount of points it's a draw" + '\n'
                + "Press 'enter' to continue.");
        SC.nextLine();
        menu();
    }

    public static int valueRoll(ArrayList<Integer> I) {
        if (hasSame(I)) {
            switch (DiceGame.sum(I)) {
                case 2:
                    DiceGame.ONES +=2;
                    return 10;  
                default:
                    return DiceGame.sum(I) * 2;
            }
        } else {
            return DiceGame.sum(I);
        }
    }

    public static boolean hasSame(ArrayList<Integer> I) {
        int S = I.size();
        for (int i = 0; i < S - 1; i++) {
            for (int j = 1; j < S ; j++) {
                if (I.get(i) == I.get(j)) {
                    DiceBot.notHappy();
                    return true;
                }
            }
        }
        return false;
    }

    public static void menu() {
        ArrayList<String> menuOptions = new ArrayList<String>() {
            {
                add("      Menu" + '\n');
                add("1. Start game." + '\n');
                add("2. Options." + '\n');
                add("3. Rules." + '\n');
                add("4. Exit game." + '\n');
                add("Please enter your choice: ");
            }
        };

        for (String n : menuOptions) {
            System.out.print(n);
        }

        switch (getNumber(1, 4)) {
            case 1:
                break;
            case 2:
                options();
                break;
            case 3:
                rules();
                break;
            case 4:
                DiceGame.GAME = false;
                break;

        }
    }
}
