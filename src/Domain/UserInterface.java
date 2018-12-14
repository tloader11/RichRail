package Domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import TaskLayer.TrainController;

public class UserInterface extends javax.swing.JFrame implements ActionListener {
	private JPanel p1;
	private JTextPane tpTextTrain;
	private JButton btnDelWag3;
	private JButton btnDelWag2;
	private JButton btnDelWag1;
	private JButton btnAddWag3;
	private JPanel pnlWagons;
	private JButton btnAddWag2;
	private JButton btnAddWag1;
	private JTextField tfCurTrain;
	private JButton btnDelTrain;
	private JButton btnChooseTrain;
	private JComboBox cbAllTrains;
	private JButton btnNewTrain;
	private JTextField tfNewTrain;
	private JPanel p2;
	private JPanel drawPanel;

	private HashMap numberOfWagons;
	private int currentNumberOfWagons;
	private int curTrain = -1;
	private int OFFSET = 100;
	private int TRAINLENGTH = 100;

	private Controller cc = new Controller();
	private TrainController tc = new TrainController();
	/**
	 * Auto-generated main method to display this JFrame
	 */

	public UserInterface() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			// -------------------LAYOUT------------------------------//

			this.setTitle("UserInterface");
			GridBagLayout lo = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			lo.rowWeights = new double[] { 0.1, 0.1, 0.1 };
			lo.rowHeights = new int[] { 4, 4, 4 };
			lo.columnWeights = new double[] { 0.1, 0.1, 0.1 };
			lo.columnWidths = new int[] { 7, 7, 7 };
			getContentPane().setLayout(lo);

			// -----------------PANEL--BOVEN----------------------//
			{
				p1 = new JPanel();
				p1.setLayout(new BorderLayout());
				getContentPane().add(p1, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					drawPanel = new JPanel();
					drawPanel.setBackground(Color.WHITE);
					p1.add(drawPanel, BorderLayout.CENTER);
				}
			}
			{
				// ---------------PANEL--LINKS----------------------//
				p2 = new JPanel();
				GridBagLayout p2Lay = new GridBagLayout();
				p2.setLayout(null);
				p2.setLayout(p2Lay);
				getContentPane().add(p2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					tpTextTrain = new JTextPane();
					tpTextTrain.setEditable(false);
					tpTextTrain.setPreferredSize(new Dimension(100, 24));
					p2.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					p2.setBounds(10, 10, 100, 15);
					p2Lay.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
					p2Lay.rowHeights = new int[] { 7, 7, 7, 7 };
					p2Lay.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
					p2Lay.columnWidths = new int[] { 7, 7, 7, 7 };
					tpTextTrain.setText("Train name:");
				}
				// ---------------TEXTFIELDS------------------------//
				{
					tfNewTrain = new JTextField(20);
					p2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					tfCurTrain = new JTextField();
					tfCurTrain.setEditable(false);
					p2.add(tfCurTrain, new GridBagConstraints(1, 1, 1, 0, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					tfCurTrain.setText("No train selected.");
				}
				// ---------------COMBOBOX--SELECT------------------------//
				{
					ComboBoxModel cbAllTrainsModel = new DefaultComboBoxModel(new String[] {});
					cbAllTrains = new JComboBox();
					cbAllTrains.setModel(cbAllTrainsModel);
					p2.add(cbAllTrains, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				
				// --------------------BUTTONS------------------------//
				{
					btnNewTrain = new JButton();
					p2.add(btnNewTrain, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnNewTrain.setText("Make new train");
					btnNewTrain.addActionListener(this);
				}
				{
					btnChooseTrain = new JButton();
					p2.add(btnChooseTrain, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnChooseTrain.setText("Select train");
					btnChooseTrain.addActionListener(this);
				}
				{
					btnDelTrain = new JButton();
					p2.add(btnDelTrain, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnDelTrain.setText("Delete train");
					btnDelTrain.addActionListener(this);
				}
			}
			// --------------------BUTTONS---PANEL------------------------//
			{
				pnlWagons = new JPanel();
				GridBagLayout p3Lay = new GridBagLayout();
				getContentPane().add(pnlWagons, new GridBagConstraints(1, 2, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				p3Lay.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				p3Lay.rowHeights = new int[] { 7, 7, 7, 7 };
				p3Lay.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
				p3Lay.columnWidths = new int[] { 7, 7, 7, 7 };
				pnlWagons.setLayout(p3Lay);
				pnlWagons.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

				// ---------------ADD--WAGON--BUTTONS------------------------//
				{
					btnAddWag1 = new JButton();
					btnAddWag1.setText("Add wagon");
					btnAddWag1.addActionListener(this);
					pnlWagons.add(btnAddWag1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				// -------------DELETE--BUTTONS------------------------------//
				{
					btnDelWag1 = new JButton();
					btnDelWag1.setText("Delete wagon");
					btnDelWag1.addActionListener(this);
					pnlWagons.add(btnDelWag1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				// ---------------------------------------------------------//
			}
			pack();
			setSize(1000, 800);
			numberOfWagons = new HashMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnNewTrain) {
			String train = tfNewTrain.getText();
			if (train != null && train.trim().length() > 0) {
				
				cc.create(train, "train", 0);
//				train = addTrain(train);
				curTrain = cbAllTrains.getSelectedIndex();
//				drawTrain(train);
			}
		} else if (event.getSource() == btnChooseTrain) {
			if (cbAllTrains.getItemCount() > 0) {
				String selection = (String) cbAllTrains.getSelectedItem();
				tfCurTrain.setText("Selected: " + selection);
				int ti = cbAllTrains.getSelectedIndex();
				if (ti != curTrain) {
					numberOfWagons.put(curTrain, currentNumberOfWagons);
				}
				curTrain = ti;
				try {
					currentNumberOfWagons = (Integer) numberOfWagons.get(curTrain);
				} catch (Exception e) {
					currentNumberOfWagons = 0;
				}
			}
		} else if (event.getSource() == btnDelTrain) {
			if (cbAllTrains.getItemCount() > 0) {
				String t = (String) cbAllTrains.getSelectedItem();
				cbAllTrains.removeItemAt(cbAllTrains.getSelectedIndex());
				numberOfWagons.remove(t);
				Graphics g = drawPanel.getGraphics();
				g.setColor(Color.WHITE);
				System.out.println(curTrain + " - " + OFFSET);
				if (cbAllTrains.getItemCount() == 0) {
					g.fillRect(30, 40 + 0 * OFFSET, 1000, 100);
					g.fillRect(30, 40 + 1 * OFFSET, 1000, 100);
					g.fillRect(30, 40 + 2 * OFFSET, 1000, 100);
				}
				if (curTrain == cbAllTrains.getItemCount()) {
					System.out.println(curTrain + "test" + cbAllTrains.getItemCount());
					g.fillRect(30, 40 + 2 * OFFSET, 1000, 100);
				} else {
					g.fillRect(30, 40 + curTrain * OFFSET, 1000, 100);
				}
				if ((String) cbAllTrains.getSelectedItem() != null) {
					curTrain = cbAllTrains.getSelectedIndex();
					tfCurTrain.setText("selected: " + (String) cbAllTrains.getSelectedItem());
				} else {
					curTrain = 0;
					tfCurTrain.setText("No train selected.");
				}
			}
		} else if (event.getSource() == btnAddWag1) {
			currentNumberOfWagons++;
			drawWagon("Wagon1");
		} else if (event.getSource() == btnDelWag1) {
			repaint(30 + TRAINLENGTH, 80 + curTrain * OFFSET, 1, 1);
		} 
		loadTrains();
	}

	public String addTrain(String train) {
		String t = "";
		try {
			t = train.trim();
			for (int i = 0; i < cbAllTrains.getItemCount(); i++) {
				String cbTrain = (String) cbAllTrains.getItemAt(i);
				if (cbTrain.equalsIgnoreCase(t)) {
					t = "";
					break;
				}
			}
			if (t != "") {
				if (curTrain >= 0) {
					numberOfWagons.put(curTrain, currentNumberOfWagons);
				}
				cbAllTrains.addItem(t);
				cbAllTrains.setSelectedItem(t);
				numberOfWagons.put(t, 0);
			}
		} catch (Exception e) {
		}
		return t;

	}
	
	public void loadTrains() {
		for (String train : tc.selectAllTrainCodes()) {
			System.out.println(train);
			drawTrain(train);
		}
		
	}

	public void drawTrain(String train) {
		if (train != "") {
			Graphics g = drawPanel.getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(30, 80 + curTrain * OFFSET, 80, 40);
			g.fillRect(80, 60 + curTrain * OFFSET, 30, 30);
			g.drawRoundRect(85, 40 + curTrain * OFFSET, 20, 20, 20, 20);
			g.setColor(Color.BLACK);
			g.fillRoundRect(35, 120 + curTrain * OFFSET, 20, 20, 20, 20);
			g.fillRoundRect(80, 120 + curTrain * OFFSET, 20, 20, 20, 20);
			g.drawString(train, 40, 105 + curTrain * OFFSET);
		}
	}

	public void drawWagon(String wagon) {
		Graphics g = drawPanel.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(30 + currentNumberOfWagons * TRAINLENGTH, 80 + curTrain * OFFSET, 80, 40);
		g.setColor(Color.BLACK);
		g.fillRoundRect(35 + currentNumberOfWagons * TRAINLENGTH, 120 + curTrain * OFFSET, 20, 20, 20, 20);
		g.fillRoundRect(80 + currentNumberOfWagons * TRAINLENGTH, 120 + curTrain * OFFSET, 20, 20, 20, 20);
		g.drawString(wagon, 40 + currentNumberOfWagons * TRAINLENGTH, 105 + curTrain * OFFSET);
	}
}
