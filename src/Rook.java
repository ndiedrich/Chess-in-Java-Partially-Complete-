import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;

public class Rook implements Piece {

	BufferedImage img;
	String color;

	/*
	 * create a Rook of given color 
	 */
	public Rook(String color) {
		this.color = color;
		if(this.color.equals("white")) {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/Chess_rlt60.png");
				this.img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				InputStream input = this.getClass().getResourceAsStream("/Pictures/b_rook_1x.png");
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
		
		if(fromX - toX == 0) {
			
			if(toY > fromY) {
				for(int i=fromY+1; i<toY; i++) {
					
					if(!B.BoardState[i][toY].isEmpty())
						return false;
					
				}
				return true;
			}
			if(fromY > toY) {
				for(int i=toY+1; i<fromY; i++) {
					
					if(!B.BoardState[i][toY].isEmpty())
						return false;
					
				}
				return true;
			}
		}
		
		if(fromY - toY == 0) {
			
			if(toX > fromX) {
				for(int i=fromX+1; i<toX; i++) {
					
					if(!B.BoardState[i][toY].isEmpty())
						return false;
					
				}
				return true;
			}
			if(fromX > toX) {
				for(int i=toX+1; i<fromX; i++) {
					
					if(!B.BoardState[i][toY].isEmpty())
						return false;
				}
				return true;
			}
		}
		
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
