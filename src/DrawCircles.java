
// ****************************************************************
// DrawCircles.java
//
// An applet that uses the Circle class to create and draw
// 10 random circles.
//          
// ****************************************************************
import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawCircles extends Applet {
	static ArrayList<Circle> list = new ArrayList<Circle>();
	private static final long serialVersionUID = -5377489978159682007L;

	// ---------------------------------------------------------
	// Create 10 circles and draw each one. Note that the circles
	// are not saved , so they will be different each time
	// paint is called.
	// ---------------------------------------------------------
	public void paint(Graphics page) {
		init();
		for (int i = 0; i < 10; i++) {
			list.get(i).draw(page);
		}
	}

	public void init() {
		for (int i = 0; i < 10; i++) {
			list.add(new Circle());
		}
	}
}