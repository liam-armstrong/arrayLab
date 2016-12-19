
//********************************************************************
//  StyleGUI.java       Author: Lewis/Loftus
//
//  Represents the user interface for the StyleOptions program.
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleGUI {
	private final int WIDTH = 300, HEIGHT = 150;
	private int fontSize = 36;
	private int style = Font.PLAIN;
	private JLabel saying;
	private JCheckBox bold, italic, small, medium, large;
	private JPanel primary;

	// -----------------------------------------------------------------
	// Sets up a panel with a label and some check boxes that
	// control the style of the label's font.
	// -----------------------------------------------------------------
	public StyleGUI() {
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", style, fontSize));

		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.cyan);

		small = new JCheckBox("Small");
		small.setBackground(Color.cyan);
		medium = new JCheckBox("Medium");
		medium.setBackground(Color.cyan);
		medium.setSelected(true);
		large = new JCheckBox("Large");
		large.setBackground(Color.cyan);

		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);

		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		small.addItemListener(listener);
		medium.addItemListener(listener);
		large.addItemListener(listener);

		primary = new JPanel();
		primary.add(saying);
		primary.add(bold);
		primary.add(italic);
		primary.add(small);
		primary.add(medium);
		primary.add(large);
		primary.setBackground(Color.cyan);
		primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	// -----------------------------------------------------------------
	// Returns the primary panel containing the GUI.
	// -----------------------------------------------------------------
	public JPanel getPanel() {
		return primary;
	}

	// *****************************************************************
	// Represents the listener for both check boxes.
	// *****************************************************************
	private class StyleListener implements ItemListener {
		// --------------------------------------------------------------
		// Updates the style of the label font style.
		// --------------------------------------------------------------
		public void itemStateChanged(ItemEvent event) {
			style = Font.PLAIN;

			if (bold.isSelected())
				style = Font.BOLD;

			if (italic.isSelected())
				style += Font.ITALIC;

			if (small.isSelected())
				fontSize = 12;

			if (medium.isSelected())
				fontSize = 26;

			if (large.isSelected())
				fontSize = 32;

			saying.setFont(new Font("Helvetica", style, fontSize));
		}
	}
}