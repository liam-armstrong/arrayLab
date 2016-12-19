

import java.awt.Graphics;
//*******************************************
//Circle.java
//
//Define a Circle class with methods to create and draw
//a circle of random size, color, and location.
//       
//****************************************************************

import java.awt.*;
import java.util.Random;

public class Circle{

	private int x, y;
	private int radius;
	private Color color;

	static Random generator = new Random();

	// ---------------------------------------------------------
	// Creates a random circle with properties in ranges given:
	// -- radius 25..74
	// -- color RGB value 0..16777215 (24-bit)
	// -- x-coord of upper left-hand corner 0..399
	// -- y-coord of upper left-hand corner 0..199
	// ---------------------------------------------------------
	public Circle() {

		radius = Math.abs(generator.nextInt()) % 50 + 25;
		color = new Color(Math.abs(generator.nextInt()) % 16777216);
		x = Math.abs(generator.nextInt()) % 400;
		y = Math.abs(generator.nextInt()) % 200;

	}

	// ---------------------------------------------------------
	// Draws circle on graphics object given
	// ---------------------------------------------------------

	public void draw(Graphics page) {
		page.setColor(color);
		page.fillOval(x, y, radius * 2, radius * 2);
	}
}
