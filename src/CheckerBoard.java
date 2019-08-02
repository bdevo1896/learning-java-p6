import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CheckerBoard extends JPanel implements ActionListener,MouseListener{

	private ArrayList<ArrayList<Square>> squares;
	private Random rand;
	private ArrayList<MovableObject> movObjects;
	private int movObNum;
	private boolean doneMoving;

	public CheckerBoard(){
		super();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(600,500));
		//This list is the checkerboard
		squares = makeGrid(10);
		//This is a list containing the pieces
		movObjects = createMovObjList();
		rand = new Random();
		addMouseListener(this);
		//This number keeps track of which piece is being moved
		movObNum = 0;
		doneMoving=true;
		this.setFocusable(true);
	}


	public void paintComponent(Graphics page){
		super.paintComponent(page);
		//These loops draw out the checkerboard
		for(int i = 0; i < squares.size(); i++){
			for(int j = 0; j < squares.get(i).size(); j++){
				squares.get(i).get(j).draw(page);
			}
		}

		//This loop draws the pieces
		for(int j = 0; j < movObjects.size(); j++){
			movObjects.get(j).draw(page);
		}

		//This will indicate which object is being moved.
		page.setColor(Color.green);
		page.drawRect(movObjects.get(movObNum).getX(), movObjects.get(movObNum).getY(), 50, 50);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(doneMoving){
			checkClickedSquare(e);
		}else{
			doneMoving = true;
		}
		System.out.println("Yo");
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This will check for checked square an
	 * @param e
	 */
	public void checkClickedSquare(MouseEvent e){
		if(doneMoving){
			for(int i = 0; i < (squares.size()); i++){
				for(int j = 0; j < (squares.get(i).size()); j++){
					Square s = squares.get(i).get(j);
					if(isClicked(s,e)){
						//s.changeColor(new Color((rand.nextInt(256)),(rand.nextInt(256)),(rand.nextInt(256))));
						movePiece(s);
					}
				}
			}
		}
	}

	/**
	 * This will check if a certian square is clicked, then it will return 'true' or 'false'.
	 * @param s
	 * @param e
	 * @return
	 */
	public boolean isClicked(Square s, MouseEvent e){
		boolean check = false;
		if(e.getX()>= s.getX() && e.getX()<= (s.getX()+s.getSide())){
			if(e.getY()>= s.getY() && e.getY()<= (s.getY()+s.getSide())){
				check = true;
			}
		}

		return check;
	}
	
	/**
	 * This will move a piece to a clicked square.
	 * @param s
	 */
	public void movePiece(Square s){
		movObjects.get(movObNum).setMoving(true);
		Runnable run = new Runnable(){
			public void run(){
				while(movObjects.get(movObNum).isMoving()){
					doneMoving = false;
					movObjects.get(movObNum).move(s);
					repaint();
					try {Thread.sleep(3);}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread thr = new Thread(run);
		thr.start();

		movObNum++;
		if(movObNum>3){
			movObNum = 0;
		}
		doneMoving = true;
	}

	/**
	 * This will return a list containing a grid of Square objects.
	 * @param size
	 * @return
	 */
	public ArrayList<ArrayList<Square>> makeGrid(int size){

		int x = 0;
		int y = 0;
		ArrayList<ArrayList<Square>> squares = new ArrayList<ArrayList<Square>>();
		//This boolean will switch up the colors of the squares
		boolean changer = true;

		//These loops create the grid of squares for the board
		for(int i = 0; i < size; i++){
			ArrayList<Square> tmpArray = new ArrayList<Square>();
			for(int j = 0; j < size; j++){
				if(changer){
					tmpArray.add(new Square(x*50,y*50,50,Color.black));
				}else{
					tmpArray.add(new Square(x*50,y*50,50,Color.white));
				}
				changer = !changer;
				x++;
			}
			if(changer){
				changer = false;
			}else{
				changer = true;
			}
			squares.add(tmpArray);
			x = 0;
			y++;
		}

		return squares;
	}

	/**
	 * This will return an Image by searching for an image file under the 'filename'
	 * @param filename
	 * @return
	 */
	public Image findImage(String filename){
		Image img = null;

		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("lol fail");
			e.printStackTrace();
		}

		return img;
	}

	/**
	 * This will create and return a list of MovableObjects.
	 * @return
	 */
	public ArrayList<MovableObject> createMovObjList(){
		Image img = findImage("mushroom.png");
		Image img2 = findImage("slime.png");
		Image img3 = findImage("sword.png");
		Image img4 = findImage("snowFlake.png");
		MovableObject mushroom = new MovableObject(550,0,img,false);
		MovableObject slime = new MovableObject(550,50,img2,false);
		MovableObject sword = new MovableObject(550,100,img3,false);
		MovableObject snowFlake = new MovableObject(550,150,img4,false);
		ArrayList<MovableObject> list = new ArrayList<MovableObject>();
		list.add(mushroom);
		list.add(slime);
		list.add(sword);
		list.add(snowFlake);
		return list;

	}
}