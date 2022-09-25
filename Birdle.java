public class Birdle extends Character {
    Birdle(String name) {
        super(name, "Bowser", 'B');
        int[] tmp = {(int)Math.floor(this.level * 1.9), (int) Math.floor(this.level * 1.4), 100};
        this.attributes = tmp;
    }

    Birdle(String name, int level, int exp) {
        super(name, "Borwser", 'B');
        this.level = level;
        this.exp = exp;
        int[] tmp = {(int)Math.floor(this.level * 1.9), (int) Math.floor(this.level * 1.4), 100};
        this.attributes = tmp;
    }


    @Override
    protected String catchPhrase() {
        return "I'm a bird!";
    }
}
