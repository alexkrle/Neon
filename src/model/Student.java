package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStudenta;

	private String ime;

	private String prezime;

	public Student() {
	}

	public int getIdStudenta() {
		return this.idStudenta;
	}

	public void setIdStudenta(int idStudenta) {
		this.idStudenta = idStudenta;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
}