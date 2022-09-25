public class Mario extends Character{
    Mario(String name) {
        super(name, "Mario", 'S');
        int[] tmp = {(int)Math.floor(this.level * 2.9), (int) Math.floor(this.level * 1.2), 100};
        this.attributes = tmp;
    }

    Mario(String name, int level, int exp) {
        super(name, "Mario", 'S');
        this.level = level;
        this.exp = exp;
        int[] tmp = {(int)Math.floor(this.level * 2.9), (int) Math.floor(this.level * 1.2), 100};
        this.attributes = tmp;
    }


    @Override
    protected String catchPhrase() {
        return "Mi a Mario!";
    }
}
