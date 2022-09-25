public class Yoshi extends Character {

    Yoshi(String name) {
        super(name, "Yoshi", 'S');
        int[] tmp = {(int)Math.floor(this.level * 2.7), (int) Math.floor(this.level * 1.6), 100};
        this.attributes = tmp;
    }

    Yoshi(String name, int level, int exp) {
        super(name, "Yoshi", 'S');
        this.level = level;
        this.exp = exp;
        int[] tmp = {(int)Math.floor(this.level * 2.7), (int) Math.floor(this.level * 1.6), 100};
        this.attributes = tmp;
    }


    @Override
    protected String catchPhrase() {
        return "Yoshi!!!!!!!!!!";
    }

}
