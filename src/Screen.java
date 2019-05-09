import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;


public class Screen extends JPanel {

	private static final long serialVersionUID = 1L;
	Board chessBoard;
	private MovePiecesMouseListener listen;

	/*
	 * Make screen with new Board
	 */
	public Screen() {
		this.listen = new MovePiecesMouseListener();
		this.setFocusable(true);
		this.requestFocus();
		this.addMouseListener(listen);
		this.chessBoard = new Board();
		repaint();
	}

	/**
	 * paints all pieces currently in chessBoard.Pieces
	 */
	public void paint(Graphics g) {

		g.drawImage(this.chessBoard.Texture, 0, 0, null);

		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {

				if(this.chessBoard.BoardState[i][j].getImg() != null) {
					BufferedImage img = this.chessBoard.BoardState[i][j].getImg();
					g.drawImage(img, i*60, j*60, null);
				}

			}
		}

	}
	
	/*
	 * Listener class handles invoking moves based on mouse click locations
	 */
	public class MovePiecesMouseListener extends MouseAdapter {
		
		int clickNum, saveX, saveY;
		
		public MovePiecesMouseListener() {
			super();
			clickNum = 0;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			int xCord = p.x/60;
			int yCord = p.y/60;
			
			if(clickNum == 0) {
				this.saveX = xCord;
				this.saveY = yCord;
				clickNum++;
			} else {
				System.out.println(this.saveX + "," + this.saveY + " to " + xCord + ", " + yCord);
				chessBoard.tryMove(saveX, saveY, xCord, yCord);
				this.saveX = 0;
				this.saveY = 0;
				clickNum = 0;
			}
			repaint();
		}
		
	}



}

