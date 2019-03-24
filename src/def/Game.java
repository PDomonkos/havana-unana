package def;
import animal.Orangutan;
import tile.Tile;


public class Game {

	public void addPoint(Orangutan o) {
		Logger.get_static_logger().enter(this, "addPoint", new Object[] {o});
		
		
		Logger.get_static_logger().exit(this, "addPoint", new Object[] {o}, "");
	}
	
	public void end(Orangutan o) {
		Logger.get_static_logger().enter(this, "end", new Object[] {o});
		
		
		Logger.get_static_logger().exit(this, "end", new Object[] {o}, "");
	}
}
