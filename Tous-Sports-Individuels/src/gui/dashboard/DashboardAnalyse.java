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
import data.Cyclisme;
import data.Tennis;
import data.Football;
import data.Natation;
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
	
	private List<Sport> lsport = null;
	private List<Sport> lsportFriend = null;
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
		UserStatic user = new UserStatic();		
		lsport = sm.getSportByUser(user.getInstance().getUserName(), this.sport);
		
		if(existFriend()) {
			lsportFriend = sm.getSportByUser(getUser().getUserName(), this.sport);
		}
		
		switch (this.sport) {
		
			case SportValue.Course:
				switch (this.data) {
					case SportValue.CourseKilometer:
						Course(lsport,SportValue.CourseKilometer,SportValue.Course, 1);
					break;
					case SportValue.CourseMaxSpeed:
						Course(lsport,SportValue.CourseMaxSpeed,SportValue.Course, 2);
					break;
					case SportValue.CourseAverageSpeed:
						Course(lsport,SportValue.CourseAverageSpeed,SportValue.Course, 3);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Cyclisme:
				switch (this.data) {
					case SportValue.CyclismeAverageSpeed:
						Cyclisme(lsport,SportValue.CyclismeAverageSpeed,SportValue.Cyclisme,1);
					break;
					case SportValue.CyclismeNumberOfSprint:
						Cyclisme(lsport,SportValue.CyclismeNumberOfSprint,SportValue.Cyclisme,2);
					break;
					case SportValue.CyclismeUphillDistance:
						Cyclisme(lsport,SportValue.CyclismeUphillDistance,SportValue.Cyclisme,3);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Football:
				switch (this.data) {
					case SportValue.Footballkilometer:
						Football(lsport,SportValue.Footballkilometer,SportValue.Football,1);
					break;
					case SportValue.FootballNumberSuccessfulDribble:
						Football(lsport,SportValue.FootballNumberSuccessfulDribble,SportValue.Football,2);
					break;
					case SportValue.FootballNumberSuccessfulPass:
						Football(lsport,SportValue.FootballNumberSuccessfulPass,SportValue.Football,3);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Natation:
				switch (this.data) {
					case SportValue.NatationDistanceCouléeDepart:
						Natation(lsport,SportValue.NatationDistanceCouléeDepart, SportValue.Natation,1);
					break;
					case SportValue.NatationNombreMvtBras:
						Natation(lsport,SportValue.NatationNombreMvtBras, SportValue.Natation,2);
					break;
					case SportValue.NatationTime:
						Natation(lsport,SportValue.NatationTime, SportValue.Natation,3);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;
			
			case SportValue.Tennis:
				switch (this.data) {
					case SportValue.TennisMaxSpeedService:
						Tennis(lsport,SportValue.TennisMaxSpeedService,SportValue.Football,1);
					break;
					case SportValue.TennisNumberAces:
						Tennis(lsport,SportValue.TennisNumberAces,SportValue.Football,1);
					break;
					case SportValue.TennisNumberSuccessfulShot:
						Tennis(lsport,SportValue.TennisNumberSuccessfulShot,SportValue.Football,1);
					break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.data);
				}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + this.sport);
		}
		
	}
	
	private void Course(List<Sport> lsport, String legendOrdinate, String legendGraphic, Integer choix) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		UserStatic user = new UserStatic();
		Course course = new Course();
		Boolean exist;
		Integer choix_data = choix;
		Calendar cal = Calendar.getInstance();
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(choix_data==1) {
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
						dataset.addValue(course.getKilometer(),user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(course.getKilometer(),user.getInstance().getUserName(), dayI);
					}
				}
			}
			if(!exist) {
				if(i<10) {
					dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
				}else {
					dataset.addValue(0,user.getInstance().getUserName(),dayI);
				}
			}
			
			if(existFriend()) {
				for(Sport sf : lsportFriend) {
					course = (Course) sf;
					Integer d = course.getDate().getDate();
					Integer m = course.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(course.getKilometer(),getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(course.getKilometer(),getUser().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,getUser().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,getUser().getUserName(),dayI);
					}
				}
			}
			
		}
		}
		if(choix_data==2) {
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
							dataset.addValue(course.getMaxSpeed(),user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(course.getMaxSpeed(),user.getInstance().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,user.getInstance().getUserName(),dayI);
					}
				}
				if(existFriend()) {
					for(Sport sf : lsportFriend) {
						course = (Course) sf;
						Integer d = course.getDate().getDate();
						Integer m = course.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(course.getMaxSpeed(),getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(course.getMaxSpeed(),getUser().getUserName(), dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,getUser().getUserName(),dayI);
						}
					}
				}
				
			}
		}
		
			if(choix_data==3) {
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
								dataset.addValue(course.getAverageSpeed(),user.getInstance().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(course.getAverageSpeed(),user.getInstance().getUserName(),dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,user.getInstance().getUserName(),dayI);
						}
					}
					if(existFriend()) {
						for(Sport sf : lsportFriend) {
							course = (Course) sf;
							Integer d = course.getDate().getDate();
							Integer m = course.getDate().getMonth();
							
							if(d==i) {
								exist = true;
								if(i<10) {
									dataset.addValue(course.getAverageSpeed(),getUser().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(course.getAverageSpeed(),getUser().getUserName(), dayI);
								}
							}
						}
						if(!exist) {
							if(i<10) {
								dataset.addValue(0,getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(0,getUser().getUserName(),dayI);
							}
						}
					}
				}
			}
		
		JFreeChart barChart = ChartFactory.createBarChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	    barChart.setBackgroundPaint(Color.white);
	    
	    JFreeChart lineChart = ChartFactory.createLineChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	  switch (choix_data) {
	  case 1:
		  	BufferedImage chartImage = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
		  	g2.drawImage(chartImage, 0,0, null);
		  	break;
	  case 2:
		    BufferedImage chartImage1 = lineChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage1, 0,0, null);
	        break;
	  case 3:
		    BufferedImage chartImage2 = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage2, 0,0, null);
	        break;
		  
	  }
	}
	
	private void Cyclisme(List<Sport> lsport, String legendOrdinate, String legendGraphic, Integer choix) {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				UserStatic user = new UserStatic();
				Cyclisme cyclisme = new Cyclisme();
				Boolean exist;
				Integer choix_data = choix;
				Calendar cal = Calendar.getInstance();
				cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				if(choix_data==1) {
				for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
					exist=false;
					String dayI = i.toString();
					
					for(Sport s : lsport) {
						cyclisme = (Cyclisme) s;
						Integer d = cyclisme.getDate().getDate();
						Integer m = cyclisme.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(cyclisme.getNumberOfSprint(),user.getInstance().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(cyclisme.getNumberOfSprint(),user.getInstance().getUserName(), dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,user.getInstance().getUserName(),dayI);
						}
					}
					if(existFriend()) {
						for(Sport sf : lsportFriend) {
							cyclisme = (Cyclisme) sf;
							Integer d = cyclisme.getDate().getDate();
							Integer m = cyclisme.getDate().getMonth();
							
							if(d==i) {
								exist = true;
								if(i<10) {
									dataset.addValue(cyclisme.getNumberOfSprint(),getUser().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(cyclisme.getNumberOfSprint(),getUser().getUserName(), dayI);
								}
							}
						}
						if(!exist) {
							if(i<10) {
								dataset.addValue(0,getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(0,getUser().getUserName(),dayI);
							}
						}
					}
				}
				}
				if(choix_data==2) {
					for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
						exist=false;
						String dayI = i.toString();
						
						for(Sport s : lsport) {
							cyclisme = (Cyclisme) s;
							Integer d = cyclisme.getDate().getDate();
							Integer m = cyclisme.getDate().getMonth();
							
							if(d==i) {
								exist = true;
								if(i<10) {
									dataset.addValue(cyclisme.getUphillDistance(),user.getInstance().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(cyclisme.getUphillDistance(),user.getInstance().getUserName(), dayI);
								}
							}
						}
						if(!exist) {
							if(i<10) {
								dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(0,user.getInstance().getUserName(),dayI);
							}
						}
						if(existFriend()) {
							for(Sport sf : lsportFriend) {
								cyclisme = (Cyclisme) sf;
								Integer d = cyclisme.getDate().getDate();
								Integer m = cyclisme.getDate().getMonth();
								
								if(d==i) {
									exist = true;
									if(i<10) {
										dataset.addValue(cyclisme.getUphillDistance(),getUser().getUserName(),"0"+dayI);
									}else {
										dataset.addValue(cyclisme.getUphillDistance(),getUser().getUserName(), dayI);
									}
								}
							}
							if(!exist) {
								if(i<10) {
									dataset.addValue(0,getUser().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(0,getUser().getUserName(),dayI);
								}
							}
						}
						
					}
				}
				
					if(choix_data==3) {
						for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
							exist=false;
							String dayI = i.toString();
							
							for(Sport s : lsport) {
								cyclisme = (Cyclisme) s;
								Integer d = cyclisme.getDate().getDate();
								Integer m = cyclisme.getDate().getMonth();
								
								if(d==i) {
									exist = true;
									if(i<10) {
										dataset.addValue(cyclisme.getAverageSpeed(),user.getInstance().getUserName(),"0"+dayI);
									}else {
										dataset.addValue(cyclisme.getAverageSpeed(),user.getInstance().getUserName(),dayI);
									}
								}
							}
							if(!exist) {
								if(i<10) {
									dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(0,user.getInstance().getUserName(),dayI);
								}
							}
							if(existFriend()) {
								for(Sport sf : lsportFriend) {
									cyclisme = (Cyclisme) sf;
									Integer d = cyclisme.getDate().getDate();
									Integer m = cyclisme.getDate().getMonth();
									
									if(d==i) {
										exist = true;
										if(i<10) {
											dataset.addValue(cyclisme.getAverageSpeed(),getUser().getUserName(),"0"+dayI);
										}else {
											dataset.addValue(cyclisme.getAverageSpeed(),getUser().getUserName(), dayI);
										}
									}
								}
								if(!exist) {
									if(i<10) {
										dataset.addValue(0,getUser().getUserName(),"0"+dayI);
									}else {
										dataset.addValue(0,getUser().getUserName(),dayI);
									}
								}
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
	
	
	private void Tennis(List<Sport> lsport, String legendOrdinate, String legendGraphic, Integer choix) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		UserStatic user = new UserStatic();
		Tennis tennis = new Tennis();
		Boolean exist;
		Integer choix_data = choix;
		Calendar cal = Calendar.getInstance();
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(choix_data==1) {
		for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
			exist=false;
			String dayI = i.toString();
			
			for(Sport s : lsport) {
				tennis = (Tennis) s;
				Integer d = tennis.getDate().getDate();
				Integer m = tennis.getDate().getMonth();
				
				if(d==i) {
					exist = true;
					if(i<10) {
						dataset.addValue(tennis.getNumberSuccessfulShot(),user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(tennis.getNumberSuccessfulShot(),user.getInstance().getUserName(), dayI);
					}
				}
			}
			if(!exist) {
				if(i<10) {
					dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
				}else {
					dataset.addValue(0,user.getInstance().getUserName(),dayI);
				}
			}
			
			if(existFriend()) {
				for(Sport sf : lsportFriend) {
					tennis = (Tennis) sf;
					Integer d = tennis.getDate().getDate();
					Integer m = tennis.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(tennis.getNumberSuccessfulShot(),getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(tennis.getNumberSuccessfulShot(),getUser().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,getUser().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,getUser().getUserName(),dayI);
					}
				}
			}
			
		}
		}
		if(choix_data==2) {
			for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
				exist=false;
				String dayI = i.toString();
				
				for(Sport s : lsport) {
					tennis = (Tennis) s;
					Integer d = tennis.getDate().getDate();
					Integer m = tennis.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(tennis.getMaxSpeedService(),user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(tennis.getMaxSpeedService(),user.getInstance().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,user.getInstance().getUserName(),dayI);
					}
				}
				if(existFriend()) {
					for(Sport sf : lsportFriend) {
						tennis = (Tennis) sf;
						Integer d = tennis.getDate().getDate();
						Integer m = tennis.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(tennis.getMaxSpeedService(),getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(tennis.getMaxSpeedService(),getUser().getUserName(), dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,getUser().getUserName(),dayI);
						}
					}
				}
			}
		}
		
			if(choix_data==3) {
				for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
					exist=false;
					String dayI = i.toString();
					
					for(Sport s : lsport) {
						tennis = (Tennis) s;
						Integer d = tennis.getDate().getDate();
						Integer m = tennis.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(tennis.getNumberAces(),user.getInstance().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(tennis.getNumberAces(),user.getInstance().getUserName(),dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,user.getInstance().getUserName(),dayI);
						}
					}
					if(existFriend()) {
						for(Sport sf : lsportFriend) {
							tennis = (Tennis) sf;
							Integer d = tennis.getDate().getDate();
							Integer m = tennis.getDate().getMonth();
							
							if(d==i) {
								exist = true;
								if(i<10) {
									dataset.addValue(tennis.getNumberAces(),getUser().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(tennis.getNumberAces(),getUser().getUserName(), dayI);
								}
							}
						}
						if(!exist) {
							if(i<10) {
								dataset.addValue(0,getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(0,getUser().getUserName(),dayI);
							}
						}
					}
				}
			}
		
		JFreeChart barChart = ChartFactory.createBarChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	    barChart.setBackgroundPaint(Color.white);
	    
	    JFreeChart lineChart = ChartFactory.createLineChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	  switch (choix_data) {
	  case 1:
		  	BufferedImage chartImage = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
		  	g2.drawImage(chartImage, 0,0, null);
		  	break;
	  case 2:
		    BufferedImage chartImage1 = lineChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage1, 0,0, null);
	        break;
	  case 3:
		    BufferedImage chartImage2 = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage2, 0,0, null);
	        break;
		  
	  }
	}
	
	private void Football(List<Sport> lsport, String legendOrdinate, String legendGraphic, Integer choix) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		UserStatic user = new UserStatic();
		Football football = new Football();
		Boolean exist;
		Integer choix_data = choix;
		Calendar cal = Calendar.getInstance();
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(choix_data==1) {
		for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
			exist=false;
			String dayI = i.toString();
			
			for(Sport s : lsport) {
				football = (Football) s;
				Integer d = football.getDate().getDate();
				Integer m = football.getDate().getMonth();
				
				if(d==i) {
					exist = true;
					if(i<10) {
						dataset.addValue(football.getNumberSuccessfulPass(),user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(football.getNumberSuccessfulPass(),user.getInstance().getUserName(), dayI);
					}
				}
			}
			if(!exist) {
				if(i<10) {
					dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
				}else {
					dataset.addValue(0,user.getInstance().getUserName(),dayI);
				}
			}
			
			if(existFriend()) {
				for(Sport sf : lsportFriend) {
					football = (Football) sf;
					Integer d = football.getDate().getDate();
					Integer m = football.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(football.getNumberSuccessfulPass(),getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(football.getNumberSuccessfulPass(),getUser().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,getUser().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,getUser().getUserName(),dayI);
					}
				}
			}
			
		}
		}
		if(choix_data==2) {
			for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
				exist=false;
				String dayI = i.toString();
				
				for(Sport s : lsport) {
					football = (Football) s;
					Integer d = football.getDate().getDate();
					Integer m = football.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(football.getKilometer(),user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(football.getKilometer(),user.getInstance().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,user.getInstance().getUserName(),dayI);
					}
				}
				if(existFriend()) {
					for(Sport sf : lsportFriend) {
						football = (Football) sf;
						Integer d = football.getDate().getDate();
						Integer m = football.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(football.getKilometer(),getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(football.getKilometer(),getUser().getUserName(), dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,getUser().getUserName(),dayI);
						}
					}
				}
			}
		}
		
			if(choix_data==3) {
				for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
					exist=false;
					String dayI = i.toString();
					
					for(Sport s : lsport) {
						football = (Football) s;
						Integer d = football.getDate().getDate();
						Integer m = football.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(football.getNumberSuccessfulDribble(),user.getInstance().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(football.getNumberSuccessfulDribble(),user.getInstance().getUserName(),dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,user.getInstance().getUserName(),dayI);
						}
					}
					if(existFriend()) {
						for(Sport sf : lsportFriend) {
							football = (Football) sf;
							Integer d = football.getDate().getDate();
							Integer m = football.getDate().getMonth();
							
							if(d==i) {
								exist = true;
								if(i<10) {
									dataset.addValue(football.getNumberSuccessfulDribble(),getUser().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(football.getNumberSuccessfulDribble(),getUser().getUserName(), dayI);
								}
							}
						}
						if(!exist) {
							if(i<10) {
								dataset.addValue(0,getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(0,getUser().getUserName(),dayI);
							}
						}
					}
				}
			}
		
		JFreeChart barChart = ChartFactory.createBarChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	    barChart.setBackgroundPaint(Color.white);
	    
	    JFreeChart lineChart = ChartFactory.createLineChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	  switch (choix_data) {
	  case 1:
		  	BufferedImage chartImage = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
		  	g2.drawImage(chartImage, 0,0, null);
		  	break;
	  case 2:
		    BufferedImage chartImage1 = lineChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage1, 0,0, null);
	        break;
	  case 3:
		    BufferedImage chartImage2 = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage2, 0,0, null);
	        break;
		  
	  }
	}
	
	private void Natation(List<Sport> lsport, String legendOrdinate, String legendGraphic, Integer choix) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		UserStatic user = new UserStatic();
		Natation natation = new Natation();
		Boolean exist;
		Integer choix_data = choix;
		Calendar cal = Calendar.getInstance();
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(choix_data==1) {
		for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
			exist=false;
			String dayI = i.toString();
			
			for(Sport s : lsport) {
				natation = (Natation) s;
				Integer d = natation.getDate().getDate();
				Integer m = natation.getDate().getMonth();
				
				if(d==i) {
					exist = true;
					if(i<10) {
						dataset.addValue(natation.getDistanceCouléeDepart(),user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(natation.getDistanceCouléeDepart(),user.getInstance().getUserName(), dayI);
					}
				}
			}
			if(!exist) {
				if(i<10) {
					dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
				}else {
					dataset.addValue(0,user.getInstance().getUserName(),dayI);
				}
			}
			
			if(existFriend()) {
				for(Sport sf : lsportFriend) {
					natation = (Natation) sf;
					Integer d = natation.getDate().getDate();
					Integer m = natation.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(natation.getDistanceCouléeDepart(),getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(natation.getDistanceCouléeDepart(),getUser().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,getUser().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,getUser().getUserName(),dayI);
					}
				}
			}
			
		}
		}
		if(choix_data==2) {
			for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
				exist=false;
				String dayI = i.toString();
				
				for(Sport s : lsport) {
					natation = (Natation) s;
					Integer d = natation.getDate().getDate();
					Integer m = natation.getDate().getMonth();
					
					if(d==i) {
						exist = true;
						if(i<10) {
							dataset.addValue(natation.getNombreMvtBras(),user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(natation.getNombreMvtBras(),user.getInstance().getUserName(), dayI);
						}
					}
				}
				if(!exist) {
					if(i<10) {
						dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
					}else {
						dataset.addValue(0,user.getInstance().getUserName(),dayI);
					}
				}
				if(existFriend()) {
					for(Sport sf : lsportFriend) {
						natation = (Natation) sf;
						Integer d = natation.getDate().getDate();
						Integer m = natation.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(natation.getNombreMvtBras(),getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(natation.getNombreMvtBras(),getUser().getUserName(), dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,getUser().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,getUser().getUserName(),dayI);
						}
					}
				}
			}
		}
		
			if(choix_data==3) {
				for(Integer i=1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
					exist=false;
					String dayI = i.toString();
					
					for(Sport s : lsport) {
						natation = (Natation) s;
						Integer d = natation.getDate().getDate();
						Integer m = natation.getDate().getMonth();
						
						if(d==i) {
							exist = true;
							if(i<10) {
								dataset.addValue(natation.getTime(),user.getInstance().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(natation.getTime(),user.getInstance().getUserName(),dayI);
							}
						}
					}
					if(!exist) {
						if(i<10) {
							dataset.addValue(0,user.getInstance().getUserName(),"0"+dayI);
						}else {
							dataset.addValue(0,user.getInstance().getUserName(),dayI);
						}
					}
					if(existFriend()) {
						for(Sport sf : lsportFriend) {
							natation = (Natation) sf;
							Integer d = natation.getDate().getDate();
							Integer m = natation.getDate().getMonth();
							
							if(d==i) {
								exist = true;
								if(i<10) {
									dataset.addValue(natation.getTime(),getUser().getUserName(),"0"+dayI);
								}else {
									dataset.addValue(natation.getTime(),getUser().getUserName(), dayI);
								}
							}
						}
						if(!exist) {
							if(i<10) {
								dataset.addValue(0,getUser().getUserName(),"0"+dayI);
							}else {
								dataset.addValue(0,getUser().getUserName(),dayI);
							}
						}
					}
				}
			}
		
		JFreeChart barChart = ChartFactory.createBarChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	    barChart.setBackgroundPaint(Color.white);
	    
	    JFreeChart lineChart = ChartFactory.createLineChart(legendOrdinate, "Date", 
				legendGraphic, dataset, PlotOrientation.VERTICAL, true, true, false);
	  switch (choix_data) {
	  case 1:
		  	BufferedImage chartImage = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
		  	g2.drawImage(chartImage, 0,0, null);
		  	break;
	  case 2:
		    BufferedImage chartImage1 = lineChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage1, 0,0, null);
	        break;
	  case 3:
		    BufferedImage chartImage2 = barChart.createBufferedImage(Test.IDEAL_DASHBOARD_DIMENSION.width,
	        		Test.IDEAL_DASHBOARD_DIMENSION.height, null);
	        g2.drawImage(chartImage2, 0,0, null);
	        break;
		  
	  }
	}

	public User getUser() {
		return this.userFriend;
	}
	
	public void setUser(User user) {
		this.userFriend = user;
	}
	
	public Boolean existFriend() {
		Boolean exist = true;
		if(userFriend == null) {
			exist = false;
		}
		return exist;
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
