public class Battlefield {
    
    Character[] teamOne;
    Character[] teamTwo;
    int round = 1;

    Battlefield(Character[][] teams) {
        this.teamOne = teams[0];
        this.teamTwo = teams[1];
    }

    public void attack(Character attacker, Character defender) {
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
                defender.alive = false;
            }
            return;
        }
        System.out.println(attacker.name + " did no damage to " + defender.name + " !");
    }

    public String[][] generateEnemyMoves() {
        String[][] enemyMoves = new String[3][2];

        for (int i = 0; i < 3; i++) {
            if (!teamTwo[i].alive) {
                enemyMoves[i][0] = "fainted";
                continue;
            }
            if ((int) Math.random() <= .7) {
                enemyMoves[i][0] = "attack";
                int index = (int) (Math.random() * 3);
                while (!teamOne[index].alive) {
                    index = (int) Math.random() * 3;
                    System.out.println(index);
                }
                System.out.println("index = " + index);
                enemyMoves[i][1] = teamOne[index].name;
            } else {
                enemyMoves[i][0] = "defend";
                int index = (int) Math.random() * 2;
                while (!teamTwo[index].alive) {
                    index = (int) Math.random() * 2;
                }
                enemyMoves[i][1] = teamTwo[index].name;
            }

        }
        return enemyMoves;
    }


    // public void defend(Character defender, Character defended) {
    //     if (defender.attributes[2] <= 0 || defended.attributes[2] <= 0) {
    //         System.out.println("Not a valid move");
    //     }


    // }


}
