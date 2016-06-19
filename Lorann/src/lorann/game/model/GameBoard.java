package lorann.game.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lorann.game.model.element.Element;
import lorann.game.model.element.Permeability;
import lorann.game.model.element.motion.Hero;
import lorann.game.model.element.motion.Mobile;
import lorann.game.model.element.motionless.MotionlessList;

public class GameBoard implements IGameBoard {
	
	private int nbCol; //nombre de colonnes de notre grille de jeu.
	private int nbLine; // nombre de lignes de notre grille de jeu.
	public Element board[][]; // La grille contenant les éléments du jeu.
	private ArrayList<Mobile> mobileList; //Liste de tout les éléments mobiles du jeu.
	private Hero hero;
	
	//Constructeur de notre grille de jeu
	public GameBoard(int nbLine, int nbCol, int xHero, int yHero){
		
		this.nbCol = nbCol;//
		this.nbLine = nbLine;//
		this.board = new Element[nbCol][nbLine];
		this.mobileList = new ArrayList<Mobile>();
		this.hero = new Hero(xHero, yHero);
		this.addMobile(hero);
	}
	
	//Constructeur de notre grille de jeu avec fichier
	public GameBoard(String fileName) throws IOException{
		int xHero;
		int yHero;
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("res/niveau/"+fileName+".txt")));
		String line;
		int numLine = 0;
		
		line = buffer.readLine();
		nbCol = Integer.parseInt(line);
		line = buffer.readLine();
		nbLine = Integer.parseInt(line);
		line = buffer.readLine();
		xHero = Integer.parseInt(line);
		line = buffer.readLine();
		yHero = Integer.parseInt(line);
		
		this.board = new Element[nbCol][nbLine];
		this.mobileList = new ArrayList<Mobile>();

		this.hero = new Hero(xHero,yHero);
		this.addMobile(hero);
		
		while ((line = buffer.readLine()) != null) {
			for (int i = 0; i < nbCol; i++) {
				if(MotionlessList.getFromSymbol(line.toCharArray()[i])!=null){
				this.insertElement(i, numLine, MotionlessList.getFromSymbol(line.toCharArray()[i]));
				}	
			}
			numLine++;
		}
		buffer.close();
	}
	
	//Méthode qui permet d'insérer des éléments dans notre grille de jeu
	public void insertElement(int x, int y, Element element){
		
		if(y>this.nbLine || x> this.nbCol || x<0 || y<0){
			System.out.println("Erreur de placement");
			return;
		} else {
			if(board[x][y] == null){
				element.setGameBoard(this);
				board[x][y] = element;
			} else {
				System.out.println("Zone occupée");
			}
		}
	}
	
	//Getters pour l'élément situé à la case x,y ainsi qu'un getter pour la largeur et la longueur de notre plateau
	public Element getElement(int x, int y){
		return board[x][y];		
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public int getNbCol() {
		return nbCol;
	}
	public int getNbLine() {
		return nbLine;
	}
	
	public Element[][] getGrille(){
		return this.board;
	}
	
	//////Gestion des Mobiles
	///Ajout d'un mobile à la liste de mobiles.
	public void addMobile(Mobile mobile){
		this.mobileList.add(mobile);
		mobile.setGameBoard(this);
	}
	
	///Suppression d'un mobile de la liste.
	public void deleteMobile(Mobile mobile){
		this.mobileList.remove(mobile);
	}
	
	///Renvois la liste de mobiles
	public ArrayList<Mobile> getMobileList(){
		return this.mobileList;
	}
	
	
	//Gestion de collisions dans la map, vérifie qu'il est possible de se déplacer à des coordonnées X, Y
	public boolean movePossible(int x, int y){
		if((x>this.nbCol || y>this.nbLine || x<0 || y<0)){
			return false;
		} else if (this.getElement(x, y)!=null && this.getElement(x, y).getPerm()==Permeability.BLOCK) {
			return false;
		} else {
			return true;
		}
	}
	
	
	///Déplacement de mobile
	public void moveMobile(Mobile mobile, Direction u){
		if(u==Direction.UP){
			if (movePossible(mobile.getX(), mobile.getY()-1)){
			mobile.setY(mobile.getY()-1);
			}
		} else if(u==Direction.LEFT){
			if (movePossible(mobile.getX()-1, mobile.getY())){
			mobile.setX(mobile.getX()-1);
			} 
		} else if(u==Direction.DOWN){
			if (movePossible(mobile.getX(), mobile.getY()+1)){
			mobile.setY(mobile.getY()+1);
			} 
		} else if(u==Direction.RIGHT) {
			if (movePossible(mobile.getX()+1, mobile.getY())){
			mobile.setX(mobile.getX()+1);
			} 
		} else if(u==Direction.UPLEFT){
			if (movePossible(mobile.getX()-1, mobile.getY()-1)){
			mobile.setX(mobile.getX()-1);
			mobile.setY(mobile.getY()-1);
			} 
		} else if(u==Direction.DOWNLEFT){
			if (movePossible(mobile.getX()-1, mobile.getY()+1)){
			mobile.setX(mobile.getX()-1);
			mobile.setY(mobile.getY()+1);
			} 
		} else if(u==Direction.DOWNRIGHT){
			if (movePossible(mobile.getX()+1, mobile.getY()+1)){
			mobile.setX(mobile.getX()+1);
			mobile.setY(mobile.getY()+1);
			} 
		}  else if(u==Direction.UPRIGHT){
			if (movePossible(mobile.getX()+1, mobile.getY()-1)){
			mobile.setX(mobile.getX()+1);
			mobile.setY(mobile.getY()-1);
			} else {
				return;
			}
		}
	}
//TODO Score managing
}
