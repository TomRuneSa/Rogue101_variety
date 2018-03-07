package inf101.v18.rogue101.objects;

import inf101.v18.gfx.gfxmode.ITurtle;
import inf101.v18.grid.GridDirection;
import inf101.v18.rogue101.game.IGame;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player implements IPlayer {
    private int hp = getMaxHealth();
    @Override
    public boolean draw(ITurtle painter, double w, double h) {
        painter.save();
        painter.turn(75);
        double size = ((double) hp + getMaxHealth()) / (2.0 * getMaxHealth());
        double carrotLength = size * h * .6;
        double carrotWidth = size * h * .4;
        painter.jump(-carrotLength / 6);
        painter.shape().ellipse().width(carrotLength).height(carrotWidth).fillPaint(Color.RED).fill();
        painter.jump(carrotLength / 2);
        painter.setInk(Color.BLUE);
        for (int i = -1; i < 2; i++) {
            painter.save();
            painter.turn(20 * i);
            painter.draw(carrotLength / 3);
            painter.restore();
        }
        painter.restore();
        return true;
    }
    @Override
    public void keyPressed(IGame game, KeyCode key) {
        if (key == KeyCode.LEFT) {
            tryToMove(game, GridDirection.WEST);
        }
        if (key == KeyCode.RIGHT){
            tryToMove(game, GridDirection.EAST);
        }
        if (key == KeyCode.UP){
            tryToMove(game, GridDirection.NORTH);
        }
       if (key == KeyCode.DOWN){
            tryToMove(game, GridDirection.SOUTH);
        }
        showStatus(game);

    }

    public void tryToMove(IGame game, GridDirection dir) {
        if (game.canGo(dir)) {
            game.move(dir);
            return;
        }
        else{
            game.displayMessage("Wanker");
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
        return 100;
    }

    @Override
    public int getDefence() {
        return 0;
    }

    @Override
    public int getMaxHealth() {
        return 100;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public int handleDamage(IGame game, IItem source, int amount) {
        return 0;
    }

    public void showStatus(IGame game){
        game.displayStatus("NAme: " + getName() + ", Score: " + getCurrentHealth());
    }

}
