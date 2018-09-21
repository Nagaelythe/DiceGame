package dicegame;

import java.util.Random;

public class Dice {

    private int faces;
    private Random r = new Random();
    private static int rolls = 0;
    public Dice(int f) {
        this.faces = f;
        rolls++;
    }

    public int roll() {
        return 1 + r.nextInt(faces);
    }
    
    public static int getrolls(){
        return rolls;
    }
}
