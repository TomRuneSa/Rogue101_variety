package inf101.v18.rogue101.objects;

import inf101.v18.rogue101.game.IGame;
import javafx.scene.input.KeyCode;

public class Player implements IPlayer {
    private int hp = getMaxHealth();
    @Override
    public void keyPressed(IGame game, KeyCode key) {

    }

    @Override
    public int getAttack() {
        return 1000;
    }
    public int getCurrentHealth() {
        return hp;
    }

    @Override
    public int getDamage() {
        return 1000;
    }

    @Override
    public int getDefence() {
        return 1000;
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }

    @Override
    public String getName() {
        return "rabbit";
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String getSymbol() {
        return "@";
    }

    @Override
    public int handleDamage(IGame game, IItem source, int amount) {
        hp -= amount;
        return amount;
    }
}
