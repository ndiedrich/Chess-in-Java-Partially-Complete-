import java.awt.image.BufferedImage;

public interface Piece {

	public BufferedImage getImg();
	public boolean verifyMove(Board B, int fromX, int fromY, int toX, int toY);
	public String getColor();
	public boolean isEmpty();
	
}
