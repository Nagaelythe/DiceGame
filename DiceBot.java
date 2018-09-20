/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.Random;

/**
 *
 * @author Martin Wulff
 */
public class DiceBot {

    private static int kickassmove = 0;

    public static boolean gamble(int currentScore, int inBank, int Streak) {
        if (currentScore >= DiceGame.Goalpost) {
            return false;
        }
        if (inBank + currentScore + 10 >= DiceGame.Goalpost) {
            return true;
        }
        return currentScore < 21;

    }

    public static void Taunt() {
        Random r = new Random();
        System.out.print("Bot says: ");
        switch (r.nextInt(5)) {
            case 0:
                System.out.println("Loooooo---hoo");
                System.out.println("Seee-heeer!");
                break;
            case 1:
                System.out.println("Thats a bold move! lets se how it works out for you.");
                break;
            case 2:
                System.out.println("Interesting, i do prefer winning my self.");
                break;
            case 3:
                System.out.println("The trick is to not loose all your points.");
                break;
            case 4:
                System.out.println("I AM THE GREATEST!");
<<<<<<< HEAD
                break;

=======
                break;               
>>>>>>> 403a533db93909c131453dceb76ed87b4bfae7d1
        }
    }

    public static void notHappy() {
        System.out.println("bot says: You lucky !@#$!@#£%&");
    }

    public static void Dance() {
        for (int i =0 ; i<10; i ++){
            /*
        for (int i = 0; i < 13; i++) {
            System.out.println("");
            
        }
             */
            
            System.out.println("Go DICE BOT! go DICE BOT!");
            switch (kickassmove) {

                case 0:
                    System.out.println("¯\\_[ツ]_/¯");
                    kickassmove = (kickassmove + 1) % 4;

                case 1:
                    System.out.println("_/-(ツ)-/¯");
                    kickassmove = (kickassmove + 1) % 4;


                case 2:
                    System.out.println("¯\\_(ツ)-\\_");
                    kickassmove = (kickassmove + 1) % 4;


                case 3:
                    System.out.println("_/-(ツ)-\\_");
                    kickassmove = (kickassmove + 1) % 4;


            }
        }

    }
}
