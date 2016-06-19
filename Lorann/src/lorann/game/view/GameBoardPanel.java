package lorann.game.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import lorann.game.model.IGameBoard;
import lorann.game.model.element.motion.Mobile;

public class GameBoardPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IGameBoard gameBoard;
	
	GameBoardPanel(IGameBoard GB){
		super();
		gameBoard = GB;
		setPreferredSize(new Dimension(gameBoard.getNbCol()*IGameBoard.cellSize, gameBoard.getNbLine()*IGameBoard.cellSize));
	}
	
	
	
	  public void paint(Graphics g)
      {		  
		  for(int i=0 ; i<gameBoard.getNbCol() ; i++){
			  for(int j=0 ; j<gameBoard.getNbLine() ; j++){
				  if (gameBoard.getElement(i,j)!=null){
					  BufferedImage buffImage = new BufferedImage(IGameBoard.cellSize, IGameBoard.cellSize, BufferedImage.TYPE_INT_ARGB);
					  Graphics imageGraph = buffImage.getGraphics();
					  imageGraph.drawImage(gameBoard.getElement(i,j).getImage(), 0, 0, IGameBoard.cellSize, IGameBoard.cellSize, null);
					  g.drawImage(buffImage, i*IGameBoard.cellSize, j*IGameBoard.cellSize, null);
				  }
			  }
		  }
		  
			for(Mobile mobile : gameBoard.getMobileList()){
				BufferedImage buffImage = new BufferedImage(IGameBoard.cellSize, IGameBoard.cellSize, BufferedImage.TYPE_INT_ARGB);
				Graphics imageGraph = buffImage.getGraphics();
				imageGraph.drawImage(mobile.getImage(), 0, 0, IGameBoard.cellSize, IGameBoard.cellSize, null);
				g.drawImage(buffImage, mobile.getX()*IGameBoard.cellSize, mobile.getY()*IGameBoard.cellSize, null);
			}
		  
      }
}
