package data;

import java.util.Date;
import javax.persistence.*;

import process.SportVisitor;
import test.manual.SportValue;

@Entity
public class Natation extends Sport{
	private double DistanceCouléeDepart;
	private int NombreMvtBras;
	private int Time; /*temps sur 100 mètres en seconde*/
	
	public Natation(User user,Date date, double distanceCouléeDepart, int nombreMvtBras, int time) {
		super(user,SportValue.Natation,date);
		this.DistanceCouléeDepart=distanceCouléeDepart;
		this.NombreMvtBras=nombreMvtBras;
		this.Time=time;
	}

	public Natation() {
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
