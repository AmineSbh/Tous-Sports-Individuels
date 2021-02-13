package data;

import java.sql.Date;

import process.SportVisitor;

public class Natation extends Sport{
	private double DistanceCouléeDepart;
	private int NombreMvtBras;
	private int Time; /*temps sur 100 mètres en seconde*/
	
	public Natation(int id, Date date) {
		super(id, date);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
