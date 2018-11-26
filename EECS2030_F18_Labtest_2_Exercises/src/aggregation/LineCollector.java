package aggregation;

public class LineCollector {

	private Line[] lines;
	private int numLines;
	private final int MAX_LINES = 20;


	LineCollector(){
		lines = new Line[MAX_LINES];
		numLines = 0;
	}

	LineCollector(LineCollector lc){
		this.lines = lc.lines;
		this.numLines = lc.numLines;
	}

	void addLine(Line line) {
		lines[numLines] = line;
		numLines ++;
	}

	Line getLineAt(int index) {
		return lines[index];
	}

	Line[] getLines(){
		return lines;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}else if(this.getClass() != obj.getClass() || obj == null) {
			return false;
		}
		LineCollector other = (LineCollector) obj;
		if(this.numLines != other.numLines) {
			return false;
		}
		
		for(int i = 0; i < numLines; i ++) {
			if (!this.lines[i].equals(other.lines[i])) {
				return false;
			}
		}		
		return true;
	}
}
