package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();
    private static int heroWarriorDamage;

    public static void start() {
        Boss boss = new Boss(700, 50, "Tanos");
        Warrior warrior = new Warrior(270, 15, "Captain America");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magic magic = new Magic(260, 20, "Harry Potter");
        Berserk berserk = new Berserk(290, 25, "Hulk");
        Medic assistant = new Medic(280, 10, 5, "Hermiona");
        Golim golim = new Golim(200,20,"Rock");
         Hero[] heroes = {warrior, doc, magic, berserk, assistant,golim};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        round_number++;
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
        date_reset(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(round_number + " ROUND ______________");
        System.out.println(boss.getName().toUpperCase() + " Boss health: "
                + boss.getHealth() + " [" +
                boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName().toUpperCase()
                    + " health: " + heroes[i].getHealth() + " [" +
                    heroes[i].getDamage() + "]");
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                heroWarriorDamage = heroes[0].getDamage();
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println(boss.getName() + " won!!!");
        }
        return allHeroesDead;
    }

    private static void date_reset(Boss boss, Hero[] heroes) {
        heroes[0].setDamage(heroWarriorDamage);

    }

}
