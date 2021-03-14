package gui.dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import data.User;

public class DashboardAnalyse extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String sport;
	Graphics2D g2;
	private boolean end = false;
	
	private static boolean DEBUG = false;

	public DashboardAnalyse(String sport) {
		this.sport = sport;
	}

	// Defines action when repaint is called
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Use Graphics2D to have more drawing options later
		g2 = (Graphics2D) g;
		
		final DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Femme", 21);
        pieDataset.setValue("Homme", 11);
        final JFreeChart pieChart = 
        		ChartFactory.createPieChart("Ratio H/F", pieDataset, true, false, false);
        
        BufferedImage chartImage = pieChart.createBufferedImage(404, 260, null);
        g2.drawImage(chartImage, 0,0, null);
	}
	
	private void printDebugGrid(Graphics2D g2) {
		g2.setColor(Color.GRAY);
		g2.drawLine(50, 1, 50, 500);
	}

	public void setSimulation(String sport) {
		this.sport = sport;
	}
	
	public void setEnd(Boolean a) {
		this.end = a;
	}

}
