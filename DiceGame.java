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
<<<<<<< HEAD
    static int turnNumber=0;
    static int players;
=======
    static int turnNumber = 0;
>>>>>>> 1e8570a5a92e7cc6ffc0f27c01f9c31e43dd1c80

    public static void main(String[] args) {
        // UI.options();

        //  UI.rules();
        UI.getPlayers();

        int players = PLAYERS.size();

        UI.options();
        while (GAME) {
<<<<<<< HEAD
            PLAYERS.get(turnNumber%players).newTurn();
            turn(turnNumber%players, PLAYERS.get(turnNumber%players));
            
=======
            PLAYERS.get(turnNumber % players).newTurn();
            turn(turnNumber, PLAYERS.get(turnNumber % players));

>>>>>>> 1e8570a5a92e7cc6ffc0f27c01f9c31e43dd1c80
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
<<<<<<< HEAD
        System.out.println("Player " + (n+1) + ": " + p.name);
=======
        System.out.println("Player " + (PLAYERS.indexOf(p.name) + 1) + ": " + p.name);
>>>>>>> 1e8570a5a92e7cc6ffc0f27c01f9c31e43dd1c80

        
        for (int i = 0; i < RPT; i++) {
            ROLLS.add(d6.roll());
        }
        System.out.println("You rolled:");
        for (int i = 0; i < ROLLS.size(); i++) {
            System.out.println("d" + (i+1) + ": " + ROLLS.get(i));
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
            System.out.println("Would you like to continue (Y/N)" + '\n');
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
<<<<<<< HEAD
    
=======
>>>>>>> 1e8570a5a92e7cc6ffc0f27c01f9c31e43dd1c80
    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

}
