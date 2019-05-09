import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;

public class Queen implements Piece {
	
	BufferedImage img;
	String color;
	
	/*
	 * Create new queen of given color
	 */
	public Queen(String color) {
		this.color = color;
		if(this.color.equals("white")) {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/Chess_qlt60.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/b_queen_1x.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/*
	 * return the image to represent this piece
	 */
	@Override
	public BufferedImage getImg() {
		return this.img;
	}


	@Override
	public boolean verifyMove(Board B, int fromX, int fromY, int toX, int toY) {

		if(B.BoardState[toX][toY].getColor().equals(this.color)) {
			return false;
		}
		if(fromX - toX == 0 ^ fromY - toY == 0) {
			return true;
		}
		int rise = (toY - fromY);
		int run = (toX - fromX);
		if(run == 0) {
			return false;
		}
		if(rise/run == 1 || rise/run == -1) {
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getColor() {
		return this.color;
	}


	@Override
	public boolean isEmpty() {
		return false;
	}

	
	
}
