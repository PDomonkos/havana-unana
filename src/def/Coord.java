package def;

public class Coord {
	
	private double x, y;
	
	public Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double GetX() { return x; }
	public double GetY() { return y; }
	
	public void Set(double x, double y) {
		this.x = x; this.y = y;
	}
	
	public void SetX(double x) { this.x = x; }
	public void SetY(double y) { this.y = y; }
}
