package data;

import java.sql.Date;

import process.SportVisitor;

public class Natation extends Sport{
	private double DistanceCouléeDepart;
	private int NombreMvtBras;
	private int Time; /*temps sur 100 mètres en seconde*/
	
	public Natation(Date date) {
		super(date);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public double getDistanceCouléeDepart() {
		return DistanceCouléeDepart;
	}

	public void setDistanceCouléeDepart(double distanceCouléeDepart) {
		DistanceCouléeDepart = distanceCouléeDepart;
	}

	public int getNombreMvtBras() {
		return NombreMvtBras;
	}

	public void setNombreMvtBras(int nombreMvtBras) {
		NombreMvtBras = nombreMvtBras;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}

}
