package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class TableModelStudent extends AbstractTableModel {

	String[] columns = { "MBR", "IME", "PREZIME" };
	private List<Student> stdenti;

	
	
	public TableModelStudent(List<Student> stdenti) {
		this.stdenti = stdenti;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return stdenti.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Student r = stdenti.get(arg0);
		switch (arg1) {
		case 0:
			return r.getIdStudenta();
		case 1:
			return r.getIme();
		case 2:
			return r.getPrezime();
		}
		return null;
	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

}
