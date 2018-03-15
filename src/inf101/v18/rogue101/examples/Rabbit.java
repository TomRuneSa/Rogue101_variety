package inf101.v18.rogue101.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import inf101.v18.gfx.gfxmode.ITurtle;
import inf101.v18.grid.GridDirection;
import inf101.v18.grid.ILocation;
import inf101.v18.rogue101.game.IGame;
import inf101.v18.rogue101.objects.IActor;
import inf101.v18.rogue101.objects.IItem;
import inf101.v18.rogue101.objects.INonPlayer;
import inf101.v18.rogue101.objects.Player;

public class Rabbit implements INonPlayer {
    private int food = 0;
    private int hp = getMaxHealth();

    @Override
    public void doTurn(IGame game) {
        if (food == 0)
            hp--;
        else
            food--;
        if (hp < 1)
            return;

        for (IItem item : game.getLocalItems()) {
            if (item instanceof Carrot) {
                System.out.println("found carrot!");
                int eaten = item.handleDamage(game, this, 5);
                if (eaten > 0) {
                    System.out.println("ate carrot worth " + eaten + "!");
                    food += eaten;
                    game.displayMessage("You hear a faint crunching (" + getName() + " eats " + item.getArticle() + " "
                            + item.getName() + ")");
                    return;
                }
            }
        }
        // TODO: prøv forskjellige varianter her
        List<GridDirection> possibleMoves = game.getPossibleMoves();
        GridDirection carrot = null;
        if (!possibleMoves.isEmpty()) {
            Collections.shuffle(possibleMoves);
            for (GridDirection dir : possibleMoves) {
                ILocation loc = game.getLocation(dir);
                for (IItem item : game.getMap().getItems(loc)) {
                    if (item instanceof Carrot) {
                        carrot = dir;
                    }
                    for (GridDirection dir1 : GridDirection.EIGHT_DIRECTIONS) {
                        ILocation loc1 = game.getLocation(dir1);
                        for (IItem itm : game.getMap().getAll(loc1)) {
                            if (itm instanceof IActor) {
                                game.attack(dir1, itm);
                                return;
                            }
                        }
                    }
                }
            }
        }

        if (carrot != null) {
            game.move(carrot);
        } else {
            game.move(possibleMoves.get(0));

        }
    }


    @Override
    public boolean draw(ITurtle painter, double w, double h) {
        return false;
    }

    @Override
    public int getAttack() {
        return 100000;
    }

    @Override
    public int getCurrentHealth() {
        return hp;
    }

    @Override
    public int getDamage() {
        return 100000000;
    }

    @Override
    public int getDefence() {
        return 1000;
    }

    @Override
    public int getMaxHealth() {
        return 50000;
    }

    @Override
    public String getName() {
        return "rabbit";
    }

    @Override
    public int getSize() {
        return 15;
    }

    @Override
    public String getSymbol() {
        return hp > 0 ? "R" : "¤";
    }

    @Override
    public int handleDamage(IGame game, IItem source, int amount) {
        hp -= amount;
        return amount;
    }

}
