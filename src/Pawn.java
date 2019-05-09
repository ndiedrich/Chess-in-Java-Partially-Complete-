import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;

public class Pawn implements Piece {
	
	BufferedImage img;
	String color;
	
	/*
	 * Create new Pawn of given color
	 */
	public Pawn(String color) {
		this.color = color;
		if(this.color.equals("white")) {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/Chess_plt60.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/b_pawn_1x.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	@Override
	public BufferedImage getImg() {
		return this.img;
	}



	@Override
	public boolean verifyMove(Board B, int fromX, int fromY, int toX, int toY) {

		if(B.BoardState[toX][toY].getColor().equals(this.color)) {
			return false;
		}
		
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}



	@Override
	public boolean isEmpty() {
		return false;
	}

	
	
}
