package lorann.game.model;

import java.util.ArrayList;

import lorann.game.model.element.Element;
import lorann.game.model.element.motion.Hero;
import lorann.game.model.element.motion.Mobile;

public interface IGameBoard {
	
	public static final int cellSize = 32;
	
	public int getNbCol();
	public int getNbLine();
	public void insertElement(int x, int y, Element element);
	public Element getElement(int x, int y);
	public Element[][] getGrille();
	public void moveMobile(Mobile mobile, Direction u);
	public ArrayList<Mobile> getMobileList();
	public void addMobile(Mobile mobile);
	public void deleteMobile(Mobile mobile);
	public Hero getHero();
	public boolean movePossible(int x, int y);

}
