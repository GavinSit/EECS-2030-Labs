package aggregation;

public class Point {
	private double x, y;
	
	Point(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	
	public Point(Point point) {
		this.x = point.x;
		this.y= point.y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (this.getClass() != obj.getClass() || obj == null) {
			return false;
		}
		
		Point point = (Point) obj;
		
		return this.getX() == point.getX() && this.getY() == point.getY();
	}
}
