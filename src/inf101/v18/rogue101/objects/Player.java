package inf101.v18.rogue101.objects;

import inf101.v18.grid.GridDirection;
import inf101.v18.rogue101.game.IGame;
import inf101.v18.rogue101.objects.IItem;
import inf101.v18.rogue101.objects.IPlayer;
import javafx.scene.input.KeyCode;

public class Player implements IPlayer {
    @Override
    public void keyPressed(IGame game, KeyCode key) {
        if (key == KeyCode.LEFT) {
            tryToMove(game, GridDirection.WEST);
        }
        else if (key == KeyCode.RIGHT){
            tryToMove(game, GridDirection.EAST);
        }
        else if (key == KeyCode.UP){
            tryToMove(game, GridDirection.NORTH);
        }
        else if (key == KeyCode.DOWN){
            tryToMove(game, GridDirection.SOUTH);
        }

    }


    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getCurrentHealth() {
        return 0;
    }

    @Override
    public int getDefence() {
        return 0;
    }

    @Override
    public int getMaxHealth() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public int handleDamage(IGame game, IItem source, int amount) {
        return 0;
    }
}
