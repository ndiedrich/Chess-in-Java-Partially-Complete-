import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;

public class Knight implements Piece {
	
	BufferedImage img;
	String color;
	
	/*
	 * Create new Knight of given color
	 */
	public Knight(String color) {
		this.color = color;
		if(this.color.equals("white")) {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/Chess_nlt60.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/b_knight_1x.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
		
		if((fromX - toX == 2 && fromY - toY == 1) ||
				(fromX - toX == 2 && fromY - toY == -1) ||
				(fromX - toX == 1 && fromY - toY == 2) ||
				(fromX - toX == 1 && fromY - toY == -2) ||
				(fromX - toX == -1 && fromY - toY == 2) ||
				(fromX - toX == -1 && fromY - toY == -2) ||
				(fromX - toX == -2 && fromY - toY == 1) ||
				(fromX - toX == -2 && fromY - toY == -1)) {
			return true;
		}
		return false;
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
