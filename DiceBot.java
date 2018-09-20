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
    
    
    public static boolean gamble(int currentScore, int inBank, int Streak){
        if(inBank+currentScore+10>=100)return true;
        return currentScore < 21;
    }
    public static void Taunt(){
        Random r = new Random();
        System.out.print("Bot says: ");
        switch(r.nextInt(5)){
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
                break;               
        }
    }
}
