import java.util.Scanner;
public class Character {
    static int characterCount;
    String name;
    String kingdom;
    int level;
    char grade;
    int exp = 0;
    boolean chosen = false;
    boolean alive = true;
    // [attack, defense, health]
    protected int[] attributes = new int[3];

    public Character() {
        this.name = "unselected";
        this.kingdom = "unselected";
        this.level = 0;
        this.grade = 'Z';

    }
    public Character(String name, String kingdom, char grade){

        this.name = name;
        this.kingdom = kingdom;
        this.grade = grade;
        this.level = (int) (Math.random() * 21) + 20;
        this.exp = 0;
        characterCount++;
    }

    public Character(String name, String kingdom, int level, char grade, int exp){

        this.name = name;
        this.kingdom = kingdom;
        this.level = level;
        this.grade = grade;
        this.exp = exp;
        characterCount++;
    }

    public void printAttributes() {
        System.out.println(String.format("%s's attributes are: level: %d // attack: %d // defense: %d // health : %d", this.name, this. level, this.attributes[0], this.attributes[1], this.attributes[2]));
    }

    public int getAttack() {
        return this.attributes[0];
    }

    public int getDefense() {
        return this.attributes[1];
    }

    public int getHealth() {
        return this.attributes[2];
    }

    protected String catchPhrase() {
        return "Default character";
    }

    public String toString() {
        return String.format("I am %s of %s's Kingdom with a level of %d and grade of %s.", this.name, this.kingdom, this.level, this.grade);
    }
    

    public static void main(String[] args) {
        // Yoshi Josh = new Yoshi("Josh", 42, 28);
        // Bowser Bowsey = new Bowser("Bowsey", 34, 86);
        Scanner myObj  = new Scanner(System.in);
        System.out.print("Enter username: ");
        String playerName = myObj.nextLine();

        Yoshi Yoshi = new Yoshi("Yoshi");
        Bowser Bowser = new Bowser("Bowser");
        BowserJr BowserJr = new BowserJr("BowserJr");
        Luigi Luigi = new Luigi("Luigi");
        Mario Mario = new Mario("Mario");
        Birdle Birdle = new Birdle("Birdle");
        Character[] characters = {Yoshi, Bowser, BowserJr, Luigi, Mario, Birdle};

        for (Character character : characters) {
            character.printAttributes();
            System.out.println(character.catchPhrase());
        }

        Character playerCharacter = new Character();
       
        boolean selected = false;

        while (selected == false) {
            System.out.print("Choose a character: ");
            String playerChoice = myObj.nextLine();
            for (Character character : characters) {
                if (character.name.equalsIgnoreCase(playerChoice)) {
                    selected = true;
                    System.out.println("You have chosen " + character.name);
                    playerCharacter = character;
                    playerCharacter.name = playerName;
                    break;
                }
            }
            if (selected) {
                break;
            }
            System.out.println("Please choose a given character!");
        }

        playerCharacter.printAttributes();
        
        Character[][] teams = new Character[2][3];
        teams[0][0] = playerCharacter;
        playerCharacter.chosen = true;
        while (teams[0][1] == null || teams[0][2] == null) {
            System.out.print("Choose a teamate: ");
            String playerChoice = myObj.nextLine();
            for (int i = 0; i < characterCount; i++) {
                if (characters[i].name.equalsIgnoreCase(playerChoice) && characters[i].chosen == false) {
                    if (teams[0][1] == null) {
                        teams[0][1] = characters[i];
                        characters[i].chosen = true;
                        System.out.println("You have chosen " + characters[i].name);

                    } else {
                        teams[0][2] = characters[i];
                        characters[i].chosen = true;
                        System.out.println("You have chosen " + characters[i].name);
                    }
                } else if (i == characterCount - 1) {
                    System.out.println("Please choose a valid character!");
                }        
            }
        }

        for (Character character : characters) {
            if (character.chosen == false) {
                if (teams[1][0] == null) {
                    teams[1][0] = character;
                    character.chosen = true;
                } else if (teams[1][1] == null) {
                    teams[1][1] = character;
                    character.chosen = true;
                } else {
                    teams[1][2] = character;
                    character.chosen = true;
                    break;
                }
            }
        }

        for (int i = 0; i < 2; i++ ) {
            System.out.println("-------------Team #" + (i+1) + "-------------");
            for (Character character : teams[i]) {
                System.out.println(character.name);
                character.printAttributes();
            }
        }
        
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Let the battle begin!!!!!!!!!!!!!!!!");
        System.out.println("-------------------------------------------------------------------------------");

        Battlefield Battlefield = new Battlefield(teams);

        while ((teams[0][0].alive || teams[0][1].alive || teams[0][2].alive) && (teams[1][0].alive || teams[1][1].alive || teams[1][2].alive)) {

        }



    }
}
