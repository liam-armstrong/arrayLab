
// *************************************************************************
//  ColorGUI.java
// 
//  Represents the user interface for the ColorOptions program that lets
//  the user change background color by selecting a radio button.
// *************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorGUI {
	private final int WIDTH = 350, HEIGHT = 100, FONT_SIZE = 20;
	private final int NUM_COLORS = 5;
	private JPanel primary;
	private Color[] color = new Color[NUM_COLORS];
	private JCheckBox yellow, cyan, red, green, magenta;
	private JLabel heading;

	// ------------------------------------------------------------------
	// Sets up a GUI with a label at the top and a set of radio buttons
	// that control the background color of the panel.
	// ------------------------------------------------------------------
	public ColorGUI() {
		// Set up heading and colors
		heading = new JLabel("Choose the background color!");
		heading.setFont(new Font("Helvetica", Font.BOLD, FONT_SIZE));

		color[0] = Color.yellow;
		color[1] = Color.cyan;
		color[2] = Color.red;
		color[3] = Color.green;
		color[4] = Color.magenta;

		// Set up the panel
		primary = new JPanel();
		primary.add(heading);
		primary.setBackground(Color.yellow);
		primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		primary.setLocation(500, 500);
		// Instantiate a ButtonGroup object and a ColorListener object

		yellow = new JCheckBox("Yellow");
		yellow.setBackground(null);
		cyan = new JCheckBox("Cyan");
		cyan.setBackground(null);
		red = new JCheckBox("Red");
		red.setBackground(null);
		green = new JCheckBox("Green");
		green.setBackground(null);
		magenta = new JCheckBox("Magenta");
		magenta.setBackground(null);
		yellow.setSelected(true);

		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(yellow);
		colorGroup.add(cyan);
		colorGroup.add(red);
		colorGroup.add(green);
		colorGroup.add(magenta);
		// Group the radio buttons, add a ColorListener to each,
		ColorListener listener = new ColorListener();
		yellow.addActionListener(listener);
		cyan.addActionListener(listener);
		red.addActionListener(listener);
		green.addActionListener(listener);
		magenta.addActionListener(listener);
		// set the background color of each and add each to the panel.
		primary.add(yellow);
		primary.add(cyan);
		primary.add(red);
		primary.add(green);
		primary.add(magenta);
	}

	// --------------------------------------------------------------
	// Returns the primary panel containing the GUI.
	// --------------------------------------------------------------
	public JPanel getPanel() {
		return primary;
	}

	// **************************************************************
	// Represents the listener for the radio buttons.
	// **************************************************************
	private class ColorListener implements ActionListener {
		// --------------------------------------------------------
		// Updates the background color of the panel based on
		// which radio button is selected.
		// --------------------------------------------------------
		public void actionPerformed(ActionEvent event) {
			int i = 0;

			if (yellow.isSelected())
				i = 0;

			if (cyan.isSelected())
				i = 1;

			if (red.isSelected())
				i = 2;

			if (green.isSelected())
				i = 3;

			if (magenta.isSelected())
				i = 4;

			primary.setBackground(color[i]);
			primary.repaint();
		}
	}
}
