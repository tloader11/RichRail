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
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import TaskLayer.TrainController;
import TaskLayer.TrainPartController;

public class UserInterface extends javax.swing.JFrame implements ActionListener {
	private JPanel p1;
	private JTextPane tpTextTrain;
	private JButton btnDelWag;
	private JPanel pnlWagons;
	private JButton btnAddWag;
	private JTextField tfCurTrain;
	private JButton btnDelTrain;
	private JButton btnChooseTrain;
	private JComboBox cbAllTrains;
	private JComboBox cbAllWagons;
	private JButton btnNewTrain;
	private JTextField tfNewTrain;
	private JPanel p2;
	private JPanel drawPanel;

	private HashMap numberOfWagons;
	private int currentNumberOfWagons = 0;
	private int OFFSET = 100;
	private int TRAINLENGTH = 100;

	private Controller cc = new Controller();
	private TrainPartController tpc = new TrainPartController();
	private TrainController tc = new TrainController();

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
					p2.add(tfCurTrain, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					tfCurTrain.setText("No train selected.");
				}
				// --------------------BUTTONS---PANEL------------------------//
				{
					pnlWagons = new JPanel();
					GridBagLayout p3 = new GridBagLayout();
					getContentPane().add(pnlWagons, new GridBagConstraints(1, 2, 2, 3, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					p3.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
					p3.rowHeights = new int[] { 7, 7, 7, 7 };
					p3.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
					p3.columnWidths = new int[] { 7, 7, 7, 7 };
					pnlWagons.setLayout(p3);
					pnlWagons.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

					// ---------------COMBOBOX--SELECT------------------------//
					{
						ComboBoxModel cbAllTrainsModel = new DefaultComboBoxModel(new String[] {});
						cbAllTrains = new JComboBox();
						cbAllTrains.setModel(cbAllTrainsModel);
						p2.add(cbAllTrains, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

					}

					{
						ComboBoxModel cbAllWagonsModel = new DefaultComboBoxModel(new String[] {});
						cbAllWagons = new JComboBox();
						cbAllWagons.setModel(cbAllWagonsModel);
						pnlWagons.add(cbAllWagons,
								new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
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

				// ---------------ADD--WAGON--BUTTONS------------------------//
				{
					btnAddWag = new JButton();
					btnAddWag.setText("Add wagon");
					btnAddWag.addActionListener(this);
					pnlWagons.add(btnAddWag, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}

				{
					btnDelWag = new JButton();
					btnDelWag.setText("Delete wagon");
					btnDelWag.addActionListener(this);
					pnlWagons.add(btnDelWag, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
			}
			pack();
			setSize(1000, 800);
			numberOfWagons = new HashMap();
			loadTrains();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAddWag) {
			String selTrain = (String) cbAllTrains.getSelectedItem();
			String selType = (String) cbAllWagons.getSelectedItem();
			tc.AddTrainPart(selTrain, selType);
		}
		if (event.getSource() == btnDelWag) {
			String selTrain = (String) cbAllTrains.getSelectedItem();
			String selType = (String) cbAllWagons.getSelectedItem();
			tc.delTrainPart(selTrain, selType);
		}

		if (event.getSource() == btnNewTrain) {
			String train = tfNewTrain.getText();
			if (train.length() > 1 && train.length() <= 10) {
				cc.create(train, "train", 2);
				System.out.println(cc.selectAll());
			} else if (train.length() > 1) {
				System.out.println("Name too short!");
			} else {
				System.out.println("Name too long!");
			}
		} else if (event.getSource() == btnChooseTrain)

		{
			if (cbAllTrains.getItemCount() > 0) {
				String selection = (String) cbAllTrains.getSelectedItem();
				tfCurTrain.setText("Selected: " + selection);
			}
		} else if (event.getSource() == btnDelTrain) {
			String t = (String) cbAllTrains.getSelectedItem();
			String trainName = t.trim();
			System.out.println(trainName);
			cc.delete(trainName, "train");
			refreshCB();
			if ((String) cbAllTrains.getSelectedItem() != null) {
				tfCurTrain.setText("Selected: " + (String) cbAllTrains.getSelectedItem());
			} else {
				tfCurTrain.setText("No train selected.");
			}
		}
		refreshCB();
		refreshGUI();
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
		} catch (Exception e) {
		}
		return t;

	}

	public void loadTrains() {
		for (String train : tc.selectAllTrainCodes()) {
			addTrain(train);
		}
		refreshGUI();
		refreshCB();
	}

	public void refreshCB() {
		cbAllTrains.removeAllItems();
		for (String train : cc.selectAll()) {
			cbAllTrains.addItem(train);
		}
		cbAllWagons.removeAllItems();
		for (String type : cc.getTypes()) {
			cbAllWagons.addItem(type);

		}
	}

	public void refreshGUI() {
		Graphics g1 = drawPanel.getGraphics();
		g1.setColor(Color.WHITE);
		g1.fillRect(0, 0, 9000, 4000);
		int curTrain = 0;
		for (String train : cc.selectAll()) {
			Graphics g = drawPanel.getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(30, 80 + curTrain * OFFSET, 80, 40);
			g.fillRect(80, 60 + curTrain * OFFSET, 30, 30);
			g.drawRoundRect(85, 40 + curTrain * OFFSET, 20, 20, 20, 20);
			g.setColor(Color.BLACK);
			g.fillRoundRect(35, 120 + curTrain * OFFSET, 20, 20, 20, 20);
			g.fillRoundRect(80, 120 + curTrain * OFFSET, 20, 20, 20, 20);
			g.drawString(train, 40, 105 + curTrain * OFFSET);
			for (Object wagon : cc.select(train).getPartsTypes()) {
				System.out.print(wagon);
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(30 + 2 * TRAINLENGTH, 80 + curTrain * OFFSET, 80, 40);
				g.setColor(Color.BLACK);
				g.fillRoundRect(35 + 2 * TRAINLENGTH, 120 + curTrain * OFFSET, 20, 20, 20, 20);
				g.fillRoundRect(80 + 2 * TRAINLENGTH, 120 + curTrain * OFFSET, 20, 20, 20, 20);
				g.drawString(wagon.toString(), 40 + 2 * TRAINLENGTH, 105 + curTrain * OFFSET);
			}
			curTrain += 1;
		}

	}

	// public void drawWagon(String wagon) {
	// Graphics g = drawPanel.getGraphics();
	// g.setColor(Color.LIGHT_GRAY);
	// g.fillRect(30 + currentNumberOfWagons * TRAINLENGTH, 80 + 1 * OFFSET, 80,
	// 40);
	// g.setColor(Color.BLACK);
	// g.fillRoundRect(35 + currentNumberOfWagons * TRAINLENGTH, 120 + 1 * OFFSET,
	// 20, 20, 20, 20);
	// g.fillRoundRect(80 + currentNumberOfWagons * TRAINLENGTH, 120 + 1 * OFFSET,
	// 20, 20, 20, 20);
	// g.drawString(wagon, 40 + currentNumberOfWagons * TRAINLENGTH, 105 + 1 *
	// OFFSET);
	// }

}
