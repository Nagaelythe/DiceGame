package dicegame;

import java.util.ArrayList;

public class Player {
    private int Streak = 0;
    private int currentStreak =0;
    private int Bank = 0;
    protected String name;

    public Player(String name) {
        this.name = name;
    }


    public void addToBank(ArrayList<Integer> roll) {
        Bank += DiceGame.sum(roll);
    }
    public void newTurn(){
        this.currentStreak =0;
    }
    public void nxtTurn(){
        currentStreak++;
    }
    public void updStreak(int i){
        if(i > Streak) Streak = i;
    }
    
}
