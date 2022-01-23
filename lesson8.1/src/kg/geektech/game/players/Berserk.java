package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int block = RPG_Game.random.nextInt(50);
        boss.setHealth(getHealth() - block);
        System.out.println("Berserk return the attack to the boss " + block);

    }
}
