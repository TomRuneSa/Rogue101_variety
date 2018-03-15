package inf101.v18.rogue101.tests;

import static junit.framework.Assert.fail;
import static org.junit.Assert.*;

import inf101.v18.rogue101.examples.Carrot;
import inf101.v18.rogue101.examples.Rabbit;
import inf101.v18.rogue101.objects.IItem;
import inf101.v18.rogue101.objects.Player;
import org.junit.jupiter.api.Test;

import inf101.v18.grid.ILocation;
import inf101.v18.rogue101.map.GameMap;

import java.util.ArrayList;
import java.util.List;

class GameMapTest {

    @Test
    void testSortedAdd() {
        GameMap gameMap = new GameMap(20, 20);
        ILocation location = gameMap.getLocation(10, 10);
        gameMap.add(location, new Carrot());
        gameMap.add(location, new Rabbit());
        gameMap.add(location, new Player());

        List<IItem> list = gameMap.getAll(location);
        if (list.get(0).getSize() < list.get(1).getSize()) {
            fail("Not sorted correctly");
        } else if (list.get(1).getSize() < list.get(2).getSize()) {
            fail("Not sorted correctly");
        }
    }


    @Test
    void visibleTest() {
        GameMap map = new GameMap(20, 20);
        ILocation loc = map.getLocation(10, 10);
        List<ILocation> lst = map.getNeighbourhood(loc, 1);
        for (int i = 0; i < lst.size(); i++) {
            if (loc.gridDistanceTo(lst.get(i)) > 1) {
                fail("Wrong distance");
            }
        }
        if (lst.size() != 8) {
            fail("You done fukced up" + lst.size());
        }

    }

    @Test
    void cornerTest() {
        GameMap map = new GameMap(20, 20);
        ILocation loc = map.getLocation(1, 1);
        List<ILocation> lst = map.getNeighbourhood(loc, 2);
        for (int i = 0; i < lst.size(); i++) {
            if (loc.gridDistanceTo(lst.get(i)) > 2) {
                fail("Wrong distance");
            }
        }
        if (lst.size() != 15) {
            fail("This number aint right" + lst.size());
        }

    }


    @Test
    void edgeTest(){
        GameMap map = new GameMap(20, 20);
        ILocation loc = map.getLocation(0, 10);
        List<ILocation> lst = map.getNeighbourhood(loc, 2);
        for (int i = 0; i < lst.size(); i++) {
            if (loc.gridDistanceTo(lst.get(i)) > 2) {
                fail("Wrong distance");
            }
        }
        if (lst.size() != 14) {
            fail("This number aint right" + lst.size());
        }

    }

}
