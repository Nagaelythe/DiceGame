package dicegame;

import java.util.ArrayList;

public class Player {
    private int Streak = 0;
    private int currentStreak =0;
    private int Bank = 0;
    protected String name;
    public boolean isBot;

    public Player(String name) {
        this.name = name;
    }
    public int getBank(){
        return Bank;
    }

    public void addToBank(int i) {
        Bank += i;
    }

    public void newTurn(){
        this.currentStreak =0;
    }
    public void nxtTurn(){
        currentStreak++;
    }
    public void updStreak(){
        if(currentStreak > Streak) Streak = currentStreak;
    }
    

}
