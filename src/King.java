import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;

public class King implements Piece {
	
	BufferedImage img;
	String color;
	
	/*
	 * creates new King of given color
	 */
	public King(String color) {
		this.color = color;
		if(this.color.equals("white")) {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/Chess_klt60.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/b_king_1x.png");
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
		
		int changeX = fromX - toX;
		int changeY = fromY - toY;
		
		if(-1 <= changeX && 1>= changeX &&
				-1 <= changeY && changeY <= 1) {
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
