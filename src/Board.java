import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Board {

	Piece[][] BoardState;
	BufferedImage Texture;
	String toMove;

	/*
	 * Create and fill in a new board
	 */
	public Board() {
		
		this.toMove = "white";

		try {
			InputStream input = this.getClass().getResourceAsStream("/Pictures/board-pic.png");
			this.Texture = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.BoardState = new Piece[8][8];

		// initialize black pieces
		this.BoardState[0][0] = new Rook("black");
		this.BoardState[1][0] = new Knight("black");
		this.BoardState[2][0] = new Bishop("black");
		this.BoardState[3][0] = new Queen("black");
		this.BoardState[4][0] = new King("black");
		this.BoardState[5][0] = new Bishop("black");
		this.BoardState[6][0] = new Knight("black");
		this.BoardState[7][0] = new Rook("black");
		
		// black pawns 
		for(int i=0; i<8; i++) {
			this.BoardState[i][1] = new Pawn("black");
		}

		// empty middle of board 
		for(int i=0; i<8; i++) {
			for(int j=2; j<6; j++) {
				this.BoardState[i][j] = new emptySpace();
			}
		}
		
		// white pawns 
		for(int i=0; i<8; i++) {
			this.BoardState[i][6] = new Pawn("white");
		}
		
		// initialize white pieces
		this.BoardState[0][7] = new Rook("white");
		this.BoardState[1][7] = new Knight("white");
		this.BoardState[2][7] = new Bishop("white");
		this.BoardState[3][7] = new Queen("white");
		this.BoardState[4][7] = new King("white");
		this.BoardState[5][7] = new Bishop("white");
		this.BoardState[6][7] = new Knight("white");
		this.BoardState[7][7] = new Rook("white");

	}

	/*
	 * Attempts to perform a move from one tile to another
	 */
	public void tryMove(int fromX, int fromY, int toX, int toY) {
		
		// verify move based on piece's rules as well as correct turn, tracked by board
		if(this.BoardState[fromX][fromY].verifyMove(this, fromX, fromY, toX, toY)
			&& this.BoardState[fromX][fromY].getColor().equals(this.toMove)) {
			
			this.executeMove(fromX, fromY, toX, toY);
			this.changeToMove();
			
		}
		
	}
	
	/*
	 * Performs a move from (fromX, fromY) to (toX, toY) 
	 */
	public void executeMove(int fromX, int fromY, int toX, int toY) {
		
		this.BoardState[toX][toY] = this.BoardState[fromX][fromY];
		this.BoardState[fromX][fromY] = new emptySpace();
		
	}
	
	/*
	 * Updates this.toMove so that turns work properly
	 */
	public void changeToMove() {
		if(this.toMove.equals("white")) {
			this.toMove = "black";
		} else this.toMove = "white";
	}
	
}
