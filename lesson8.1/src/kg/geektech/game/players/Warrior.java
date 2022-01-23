package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {

    public Warrior(int health, int damage, String name) {

        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int bag = RPG_Game.random.nextInt(2,4);
        this.setDamage(getDamage()*bag);


    }
}
