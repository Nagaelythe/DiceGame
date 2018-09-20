package dicegame;

import java.util.Random;

public class Dice {

    private int faces;
    private Random r = new Random();

    public Dice(int f) {
        this.faces = f;
    }

    public int roll() {
        return 1 + r.nextInt(faces);
    }

}
