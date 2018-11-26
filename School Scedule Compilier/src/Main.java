
/* Name: School Schedule Compiler
 * Description: Compile all schedules to see free time
 * Date Started: September 5, 2018
 * Date Modified: September 5, 2018
 * Version: 0.0.1
 */

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class Main extends JFrame {

	String select = "select";

	public Main() {
		// Title
		super("School Schedule Compilier");

		Object[][] rowData = { { "8:00-8:30", select, select, select, select, select, select, select },
				{ "8:30-9:00", select, select, select, select, select, select, select },
				{ "9:00-9:30", select, select, select, select, select, select, select },
				{ "9:30-10:00", select, select, select, select, select, select, select },
				{ "10:00-10:30", select, select, select, select, select, select, select },
				{ "10:30-11:00", select, select, select, select, select, select, select },
				{ "11:00-11:30", select, select, select, select, select, select, select },
				{ "11:30-12:00", select, select, select, select, select, select, select },
				{ "12:30-13:00", select, select, select, select, select, select, select },
				{ "13:00-13:30", select, select, select, select, select, select, select },
				{ "13:30-14:00", select, select, select, select, select, select, select },
				{ "14:00-14:30", select, select, select, select, select, select, select },
				{ "14:30-15:00", select, select, select, select, select, select, select },
				{ "15:00-15:30", select, select, select, select, select, select, select },
				{ "15:30-16:00", select, select, select, select, select, select, select },
				{ "16:00-16:30", select, select, select, select, select, select, select },
				{ "16:30-17:00", select, select, select, select, select, select, select },
				{ "17:00-17:30", select, select, select, select, select, select, select },
				{ "17:30-18:00", select, select, select, select, select, select, select },
				{ "18:00-18:30", select, select, select, select, select, select, select },
				{ "18:30-19:00", select, select, select, select, select, select, select },
				{ "19:00-19:30", select, select, select, select, select, select, select },
				{ "19:30-20:00", select, select, select, select, select, select, select },
				{ "20:00-20:30", select, select, select, select, select, select, select },
				{ "20:30-21:00", select, select, select, select, select, select, select },
				{ "21:30-22:00", select, select, select, select, select, select, select }, };

		// Column Header
		String columnHeader[] = { "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

		// Create Table
		JTable table = new JTable(rowData, columnHeader);

		// SET CUSTOM RENDERER TO TEAMS COLUMN
		table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		;

		// SET CUSTOM EDITOR TO TEAMS COLUMN
		table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));

		// SCROLLPANE,SET SZE,SET CLOSE OPERATION
		JScrollPane pane = new JScrollPane(table);
		getContentPane().add(pane);
		setSize(450, 100);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		Main SSC = new Main();
		SSC.setVisible(true);
	}
}

// BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements TableCellRenderer {

	// CONSTRUCTOR
	public ButtonRenderer() {
		// SET BUTTON PROPERTIES
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int col) {

		// SET PASSED OBJECT AS BUTTON TEXT
		setText((obj == null) ? "" : obj.toString());

		return this;
	}

}

// BUTTON EDITOR CLASS
class ButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private Boolean clicked;

	public ButtonEditor(JTextField txt) {
		super(txt);

		btn = new JButton();
		btn.setOpaque(true);

		// WHEN BUTTON IS CLICKED
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fireEditingStopped();
			}
		});
	}

	// OVERRIDE A COUPLE OF METHODS
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

		// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		lbl = (obj == null) ? "" : obj.toString();
		btn.setText(lbl);
		clicked = true;
		return btn;
	}

	// IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	@Override
	public Object getCellEditorValue() {

		if (clicked) {
			// SHOW US SOME MESSAGE
			JOptionPane.showMessageDialog(btn, lbl + " Clicked");
		}
		// SET IT TO FALSE NOW THAT ITS CLICKED
		clicked = false;
		return new String(lbl);
	}

	@Override
	public boolean stopCellEditing() {

		// SET CLICKED TO FALSE FIRST
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		super.fireEditingStopped();
	}
}