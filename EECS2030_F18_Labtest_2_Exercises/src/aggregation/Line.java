package aggregation;

public class Line{

	Point p1, p2;
	Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	Line(Line line) {
		this.p1 = line.getStart();
		this.p2 = line.getEnd();
	}
	
	Point getStart() {
		return p1;
	}
	
	Point getEnd() {
		return p2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}else if(this.getClass() != obj.getClass() || obj == null) {
			return false;
		}
		
		Line other = (Line) obj;
		return this.getStart().equals(other.getStart()) && this.getEnd().equals(other.getEnd());
	}
}
