package lorann.game.model.element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lorann.game.model.GameBoard;
import lorann.game.model.IGameBoard;

public abstract class Element {

	public IGameBoard gameBoard;
	private BufferedImage image;
	protected Permeability perm;
	private char c;
	
	public Element(String imageName, char c, Permeability perm){
		this.c=c;
		this.perm = perm;
		setImage(imageName);
	}
	
	public Permeability getPerm(){
		return this.perm;
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
	
	public void setImage(String imageName) {
		try {
			this.image = ImageIO.read(new File("res/image/" + imageName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IGameBoard getGameBoard(){
		return this.gameBoard;
	}
	
	public void setGameBoard(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	public char getC() {
		return c;
	}
	
}
