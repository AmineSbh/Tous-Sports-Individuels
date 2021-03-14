package process;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class NotesJFrame extends JFrame {
	
	 private JDialog ratioHommeFemmeJdialog;
	 private JPanel boutons =  new JPanel();

    private class ShowRatioHommeFemmeAction extends AbstractAction {

        private ShowRatioHommeFemmeAction() {
            super("Ratio h/f");
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
        	//ratioHommeFemmeJdialog = new JDialog();
            //ratioHommeFemmeJdialog.setTitle("Ratio H/F");

            
            final DefaultPieDataset pieDataset = new DefaultPieDataset();

            pieDataset.setValue("Femme", 21);
            pieDataset.setValue("Homme", 11);

            final JFreeChart pieChart = ChartFactory.createPieChart("Ratio H/F", pieDataset, true, false, false);
            //final ChartPanel cPanel = new ChartPanel(pieChart);

            //ratioHommeFemmeJdialog.getContentPane().add(cPanel);

           // ratioHommeFemmeJdialog.pack();
            //ratioHommeFemmeJdialog.setVisible(true);
            
            boutons.add(new ChartPanel(pieChart));

            boutons.setPreferredSize(new Dimension(800, 600));
        }
    }
    
    public NotesJFrame() {
        
        //boutons.add(new JButton(new ShowRatioHommeFemmeAction()));
    	final DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("Femme", 21);
        pieDataset.setValue("Homme", 11);

        final JFreeChart pieChart = ChartFactory.createPieChart("Ratio H/F", pieDataset, true, false, false);
        boutons.add(new ChartPanel(pieChart));

        boutons.setPreferredSize(new Dimension(800, 600));
        
        getContentPane().add(boutons);
    }
    
    public static void main(String[] args) {
		NotesJFrame demo = new NotesJFrame();
		demo.pack();
		demo.setVisible(true);
	}
}
