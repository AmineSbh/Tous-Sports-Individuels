package gui.dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import data.Course;
import data.Sport;
import data.User;
import data.UserStatic;
import gui.Test;
import process.SportManager;

public class DashboardAnalyse extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String sport;
	private User userFriend;
	private String data;
	
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
		
		SportManager sm= new SportManager();
		
		Date date= new Date();
		Sport course= new Course();
		
		//sport = sm.getSportByUser(UserStatic.getInstance().getUserName()
			//	, this.sport);
		
		sport = sm.getSportByUser("weezy", this.sport);
		
		PaintVisitor paintVisitor = new PaintVisitor(g2, this.data, sport);
		course.accept(paintVisitor);
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
