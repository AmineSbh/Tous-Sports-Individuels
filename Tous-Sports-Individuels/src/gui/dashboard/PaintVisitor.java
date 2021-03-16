package gui.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
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
import test.manual.SportValue;

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
		
		switch (dataToProcess) {
		case SportValue.CourseKilometer:
			CourseKilometer();
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + dataToProcess);
		}
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
	
	private void CourseKilometer() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
		Course course = new Course();
		Boolean exist;
		
		Calendar cal = Calendar.getInstance();
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
			exist=false;
			String dayI = i.toString();
			
			for(Sport s : this.sport) {
				course = (Course) s;
				Integer d = course.getDate().getDate();
				Integer m = course.getDate().getMonth();
				
				if(d==i) {
					exist = true;
					if(i<10) {
						dataset.addValue(course.getKilometer(),"Weezy","0"+dayI);
					}else {
						dataset.addValue(course.getKilometer(),"Weezy",dayI);
					}
				}
			}
			if(!exist) {
				if(i<10) {
					dataset.addValue(0,"Weezy","0"+dayI);
				}else {
					dataset.addValue(0,"Weezy",dayI);
				}
			}
		}
		
		JFreeChart barChart = ChartFactory.createBarChart("Kilometres parcouru", "Date", 
	      "Kilometres", dataset, PlotOrientation.VERTICAL, true, true, false);
	    barChart.setBackgroundPaint(Color.white);
	    
	    BufferedImage chartImage = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
        g2.drawImage(chartImage, 0,0, null);
		
	}

}
