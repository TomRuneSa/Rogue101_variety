package inf101.v18.rogue101.objects;

import inf101.v18.gfx.gfxmode.ITurtle;
import inf101.v18.grid.GridDirection;
import inf101.v18.grid.ILocation;
import inf101.v18.rogue101.examples.Carrot;
import inf101.v18.rogue101.examples.Rabbit;
import inf101.v18.rogue101.game.IGame;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {
    private List<IItem> carryItem = new ArrayList<>();
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
        if(key == KeyCode.Q){
            List<IItem> list = game.getLocalItems();
            if(list.size()==0){
                game.displayMessage("Nothing here");
                return;
            }
            if(list.get(0) instanceof Dust) {game.displayMessage("Nothing here"); return;}

            carryItem.add( game.pickUp(list.get(0)));

        }
        if(key == KeyCode.W){
            if (carryItem.size() == 0){
                game.displayMessage("You don't have stuff");
                return;
            }

            if (canDrop(game)){
                game.drop(carryItem.get(0));
                carryItem.remove(0);
            }
            else{
                game.displayMessage("You can't drop stuff here ");
                return;
            }

        }
        showStatus(game);
    }

    public void tryToMove(IGame game, GridDirection dir) {
        if (game.canGo(dir)) {
            game.move(dir);
            return;
        }
        else{
            game.displayMessage("Well.. This does not work");
        }
    }
    public boolean canDrop(IGame game){
        if (game.getLocalItems().size() == 0) return true;
        if(game.getLocalItems().get(0) instanceof Carrot || game.getLocalItems().get(0) instanceof Rabbit)
            return false;
        return true;
    }

    @Override
    public int getAttack() {
        return 10;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public int getCurrentHealth() {
        return 10;
    }

    @Override
    public int getDefence() {
        return 1;
    }

    @Override
    public int getMaxHealth() {
        return 100;
    }

    @Override
    public String getName() {
        return "Player";
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
        int carrots = 0;
        for (int i = 0; i <carryItem.size() ; i++) {
            if (carryItem.get(i) instanceof Carrot){
                carrots++;
            }

        }
        game.displayStatus("Amount of carrots: " + carrots + " Score: " + getCurrentHealth() + getName());


    }

}
