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
		if(list.get(0).getSize() < list.get(1).getSize()) {
			fail("Not yet implemented");
		}
		else if(list.get(1).getSize()<list.get(2).getSize()){
			fail("Not yet implemented1");
		}
	}

}
