/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author Martin Wulff
 */
public class DiceBot {
    
    
    public static boolean gamble(int currentScore, int inBank, int Streak){
        if(inBank+currentScore+10>=100)return true;
        return currentScore < 21;
    }
    
}
