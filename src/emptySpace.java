import java.awt.image.BufferedImage;

public class emptySpace implements Piece {
	
	public emptySpace() {}

	/*
	 * return null
	 */
	@Override
	public BufferedImage getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyMove(Board B, int fromX, int fromY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

}
