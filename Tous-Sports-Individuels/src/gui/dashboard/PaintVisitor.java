package gui.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import data.Course;
import data.Cyclisme;
import data.DBConnection;
import data.Football;
import data.Friend;
import data.Natation;
import data.Sport;
import data.Tennis;
import data.User;
import gui.Test;
import process.SportVisitor;

public class PaintVisitor implements SportVisitor {
	
	private Graphics2D g2;
	private String dataToProcess;
	private List<Sport> sport;
	
	public PaintVisitor(Graphics2D graphics, String data,List<Sport> sport) {
		this.g2 = graphics;
		this.dataToProcess = data;
		this.sport = sport;
	}

	@Override
	//TODO Try 
	public Void visit(Course sport) {
		
		ArrayList list = new ArrayList<Double>();
		Course course = new Course();
		
		for(Sport s : this.sport) {
			course = (Course) s;
			list.add(course.getKilometer());
		}
		
		Object[] obj = list.toArray();

		double[] values = new double[obj.length];
		for(int i=0; i < values.length; i++) {
		  //Convertir les objets en int
			values[i]=(double) obj[i];
		}
		
		HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Hist",values,20); // Number of bins is  50
        String plotTitle = "";
        String xAxis = "Date";
        String yAxis = "Kilometer";
        PlotOrientation orientation = PlotOrientation.VERTICAL;

        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xAxis, yAxis,
                dataset, orientation, show, toolTips, urls);

        chart.setBackgroundPaint(Color.white);
		
		BufferedImage chartImage = chart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
        g2.drawImage(chartImage, 0,0, null);
		return null;
	}

	@Override
	public Void visit(Cyclisme sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Football sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Natation sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Tennis sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(User user) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(user);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Friend friend) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(friend);
		readTransaction.commit();
		session.close();
		return null;
	}

	public void setDataToProcess(String dataToProcess) {
		this.dataToProcess = dataToProcess;
	}

}
