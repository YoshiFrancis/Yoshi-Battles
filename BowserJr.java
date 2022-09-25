public class BowserJr extends Character {
    BowserJr(String name) {
        super(name, "Bowser", 'A');
        int[] tmp = {(int)Math.floor(this.level * 2.5), (int) Math.floor(this.level * 1.4), 100};
        this.attributes = tmp;
    }

    BowserJr(String name, int level, int exp) {
        super(name, "Bowser", 'A');
        this.level = level;
        this.exp = exp;
        int[] tmp = {(int)Math.floor(this.level * 2.5), (int) Math.floor(this.level * 1.4), 100};
        this.attributes = tmp;
    }


    @Override
    protected String catchPhrase() {
        return "hehehehehehehehe!";
    }
}
