import java.awt.GridLayout;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.awt.Color;

public class Frame extends JFrame {


	private static final long serialVersionUID = 1L;

	Screen s;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 500);
		setResizable(false);
		setTitle("Chess v4.0 by Nate Diedrich");

		init();
	}

	public void init() {
		setLocationRelativeTo(null);

		setLayout(new GridLayout(1,1,0,0));
		
		s = new Screen();
		super.add(s);
		
		setVisible(true);
	}
}