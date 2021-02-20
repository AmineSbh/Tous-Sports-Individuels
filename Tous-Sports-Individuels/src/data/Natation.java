package data;

import java.sql.Date;
import javax.persistence.*;

import process.SportVisitor;

@Entity
public class Natation extends Sport{
	private double DistanceCoul�eDepart;
	private int NombreMvtBras;
	private int Time; /*temps sur 100 m�tres en seconde*/
	
	public Natation(User user,Date date, double distanceCoul�eDepart, int nombreMvtBras, int time) {
		super(user,date);
		this.DistanceCoul�eDepart=distanceCoul�eDepart;
		this.NombreMvtBras=nombreMvtBras;
		this.Time=time;
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public double getDistanceCoul�eDepart() {
		return DistanceCoul�eDepart;
	}

	public void setDistanceCoul�eDepart(double distanceCoul�eDepart) {
		DistanceCoul�eDepart = distanceCoul�eDepart;
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
