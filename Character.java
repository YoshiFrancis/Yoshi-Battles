import java.util.Scanner;
import java.util.Arrays;

public class Character {
    static int characterCount;
    String name;
    String kingdom;
    int level;
    char grade;
    int exp = 0;
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
        this.level = (int) (Math.random() * 20) + 20;
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

    protected static void attack(Character attacker, Character defender) {
        if (attacker.attributes[0] > defender.attributes[1]) {
            int damage = (attacker.attributes[0] - defender.attributes[1]);
            defender.attributes[2] -= damage;
            System.out.println(String.format("%s did %d damage to %s", attacker.name, damage, defender.name));
            if (defender.attributes[2] <= 0) {
                defender.attributes[2] = 0;
            }
            System.out.println(String.format("%s has %d health points left!", defender.name, defender.attributes[2]));
            if (defender.attributes[2] <= 0) {
                System.out.println(defender.name + " has fainted!");
            }
            return;
        }
        System.out.println(attacker.name + " did no damage to " + defender.name + " !");
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

        while (teams[0][1] == null && teams[0][2] == null) {
            System.out.print("Choose a teamate: ");
            String playerChoice = myObj.nextLine();
            for (Character character : characters) {
                if (character.name.equalsIgnoreCase(playerChoice)) {
                    System.out.println("You have chosen " + character.name);
                    if (teams[0][1] == null) {
                        teams[0][1] = character;
                    } else {
                        teams[0][2] = character;
                    }
                    break;
                }
            }
            System.out.println("Please choose a given character!");
        }
        


    }
}
