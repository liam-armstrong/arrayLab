
//****************************************************************
//DrawPerson.java
//
//An applet that uses the Graphics draw methods to draw a person.
//
//****************************************************************
import java.awt.*;
import java.applet.Applet;

@SuppressWarnings("serial")
public class DrawPerson extends Applet {

	private final int APPLET_WIDTH = 600;
	private final int APPLET_HEIGHT = 400;

	private int[] shirtX = { 60, 0, 20, 60, 50, 130, 120, 160, 180, 120 };
	private int[] shirtY = { 100, 150, 180, 160, 250, 250, 160, 180, 150, 100 };
	private int[] pantsX = { 50, 50, 80, 80, 100, 100, 130, 130, 50 };
	private int[] pantsY = { 240, 340, 340, 280, 280, 340, 340, 240, 240 };
	private int headX = 66;
	private int headY = 45;
	private int[] zigzagX = { 100, 75, 105, 75,  100, };
	private int[] zigzagY = { 210, 190, 170, 160, 140,  };
	private int[] hairX = { 71, 91, 111 };
	private int[] hairY = { 55, 40, 55 };

	// --------------------------------------
	// Set applet size
	// --------------------------------------
	public void init() {
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}

	// --------------------------------------
	// Draw person
	// --------------------------------------
	public void paint(Graphics page) {
		for (int i = 0; i < 3; i++) {
			page.setColor(Color.blue);
			page.fillPolygon(shirtX, shirtY, shirtX.length);

			page.setColor(Color.darkGray);
			page.fillPolygon(pantsX, pantsY, pantsX.length);

			page.setColor(Color.yellow);
			page.fillOval(headX, headY, 50, 60);

			page.setColor(Color.black);
			page.drawPolyline(zigzagX, zigzagY, zigzagX.length);
			
			page.setColor(Color.red);
			page.fillPolygon(hairX, hairY, hairX.length);
			movePerson(150, 0);
		}
	}

	public void movePerson(int x, int y)

	{
		// shirt
		for (int i = 0; i < shirtX.length; i++)

		{
			shirtX[i] += x;
			shirtY[i] += y;
		}
		// pants
		for (int i = 0; i < pantsX.length; i++) {
			pantsX[i] += x;
			pantsY[i] += y;
		}
		// zigzag
		for (int i = 0; i < zigzagX.length; i++) {
			zigzagX[i] += x;
			zigzagY[i] += y;
		}
		
		for (int i = 0; i < hairX.length; i++)

		{
			hairX[i] += x;
			hairY[i] += y;
		}
		// head
		headX += x;
		headY += y;
	}
}