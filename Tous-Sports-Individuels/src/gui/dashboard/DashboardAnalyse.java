package gui.dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import data.Course;
import data.Sport;
import data.User;
import data.UserStatic;
import gui.Test;
import process.SportManager;
import test.manual.SportValue;

public class DashboardAnalyse extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String sport;
	private User userFriend = null;
	private String data;
	private SportManager sm= new SportManager();
	
	Graphics2D g2;
	private boolean empty = true;

	public DashboardAnalyse() {
	}

	// Defines action when repaint is called
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Use Graphics2D to have more drawing options later
		g2 = (Graphics2D) g;
		
		if(empty) {
			printErrorMessage(g2);
		}else {
			printGraphic(g2);
		}
		
	}
	
	private void printErrorMessage(Graphics2D g2) {
		g2.setFont(new Font("Lancer", Font.BOLD, 20));
		g2.setColor(Color.RED);
		g2.drawString("Pas de graphique actuellement",55, 100);
	}
	
	private void printGraphic(Graphics2D g2) {
		List<Sport> sport = null;
		//sport = sm.getSportByUser(UserStatic.getInstance().getUserName()
			//	, this.sport);
		
		sport = sm.getSportByUser("weezy", this.sport);
		
		//PaintVisitor paintVisitor = new PaintVisitor(g2, this.data, sport);
		//course.accept(paintVisitor);
		
		switch (this.sport) {
		
			case SportValue.Course:
				switch (this.data) {
					case SportValue.CourseKilometer:
						CourseKilometer(sport,SportValue.CourseKilometer,SportValue.Course);
					break;
					case SportValue.CourseMaxSpeed:
						CourseKilometer(sport,SportValue.CourseMaxSpeed,SportValue.Course);
					break;
					case SportValue.CourseAverageSpeed:
						//CourseKilometer(sport);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Cyclisme:
				switch (this.data) {
					case SportValue.CyclismeAverageSpeed:
						//CourseKilometer(sport);
					break;
					case SportValue.CyclismeNumberOfSprint:
						CourseKilometer(sport,SportValue.CyclismeNumberOfSprint,SportValue.Cyclisme);
					break;
					case SportValue.CyclismeUphillDistance:
						CourseKilometer(sport,SportValue.CyclismeUphillDistance,SportValue.Cyclisme);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Football:
				switch (this.data) {
					case SportValue.Foorballkilometer:
						CourseKilometer(sport,SportValue.Foorballkilometer,SportValue.Football);
					break;
					case SportValue.FoorballNumberSuccessfulDribble:
						//CourseKilometer(sport);
					break;
					case SportValue.FoorballNumberSuccessfulPass:
						//CourseKilometer(sport);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Natation:
				switch (this.data) {
					case SportValue.NatationDistanceCouléeDepart:
						//CourseKilometer(sport);
					break;
					case SportValue.NatationNombreMvtBras:
						CourseKilometer(sport,SportValue.NatationNombreMvtBras,SportValue.Natation);
					break;
					case SportValue.NatationTime:
						//CourseKilometer(sport);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Tennis:
				switch (this.data) {
					case SportValue.TennisMaxSpeedService:
						//CourseKilometer(sport);
					break;
					case SportValue.TennisNumberAces:
						//CourseKilometer(sport);
					break;
					case SportValue.TennisNumberSuccessfulShot:
						//CourseKilometer(sport);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + this.sport);
		}
		
	}
	
	private void CourseKilometer(List<Sport> lsport, String legendOrdinate, String legendGraphic) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
		Course course = new Course();
		Boolean exist;
		Calendar cal = Calendar.getInstance();
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
			exist=false;
			String dayI = i.toString();
			
			for(Sport s : lsport) {
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
		
		JFreeChart barChart = ChartFactory.createBarChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	    barChart.setBackgroundPaint(Color.white);
	    
	    JFreeChart lineChart = ChartFactory.createLineChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	  
	    BufferedImage chartImage = lineChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
        g2.drawImage(chartImage, 0,0, null);
	}

	public User getUser() {
		return this.userFriend;
	}
	
	public void setUser(User user) {
		this.userFriend = user;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getSport() {
		return this.sport;
	}
	
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	public void setEmpty() {
		this.empty = false;
	}

}
