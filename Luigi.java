public class Luigi extends Character {
    Luigi(String name) {
        super(name, "Mario", 'B');
        int[] tmp = {(int)Math.floor(this.level * 2.0), (int) Math.floor(this.level * 1.1), 100};
        this.attributes = tmp;
    }

    Luigi(String name, int level, int exp) {
        super(name, "Mario", 'B');
        this.level = level;
        this.exp = exp;
        int[] tmp = {(int)Math.floor(this.level * 2.0), (int) Math.floor(this.level * 1.1), 100};
        this.attributes = tmp;
    }


    @Override
    protected String catchPhrase() {
        return "Ya Hoooooo!!!!";
    }
}
