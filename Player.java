package dicegame;

import java.util.ArrayList;

public class Player {

    private ArrayList<Integer> bank = new ArrayList<>();
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public int bankSum() {
        int sum = 0;
        for (int i = 0; i < bank.size(); i++) {
            sum += bank.get(i);
        }
        return sum;
    }

    public void addToBank(ArrayList<Integer> roll) {
        bank.addAll(roll);
    }
}
