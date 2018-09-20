package dicegame;

public class Player {

    private int Streak = 0;
    private int currentStreak = 0;
    private int Bank = 0;
    protected String name;
    public boolean isBot;

    public Player(String name) {
        this.name = name;
        if (name.length() > 2) {
            isBot = name.substring(0, 3).toLowerCase().equals("bot");
            DiceGame.bot = true;
        }
    }

    public int getBank() {
        return Bank;
    }

    public void addToBank(int i) {
        Bank += i;
    }

    public void newTurn() {
        this.currentStreak = 0;
    }

    public void nxtTurn() {
        currentStreak++;
    }

    public void updStreak() {
        if (currentStreak > Streak) {
            Streak = currentStreak;
        }
    }

    public int getCStreak() {
        return currentStreak;
    }

    @Override
    public String toString() {
        return "Player " + (DiceGame.PLAYERS.indexOf(this) + 1) + ": " + name + "!" + '\n'
                + "You scored: " + Bank + " points. " + '\n'
                + "Your best streak is " + Streak + '\n';
    }

}
