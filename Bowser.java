public class Bowser extends Character {
    Bowser(String name) {
        super(name, "Bowser", 'S');
        int[] tmp = {(int)Math.floor(this.level * 2), (int) Math.floor(this.level * 2.8), 100};
        this.attributes = tmp;
    }

    Bowser(String name, int level, int exp) {
        super(name, "Yoshi", 'S');
        this.level = level;
        this.exp = exp;
        int[] tmp = {(int)Math.floor(this.level * 2), (int) Math.floor(this.level * 2.8), 100};
        this.attributes = tmp;
    }
    @Override
    protected String catchPhrase() {
        return "Rawrrrrrrrrrrrr";
    }
}
