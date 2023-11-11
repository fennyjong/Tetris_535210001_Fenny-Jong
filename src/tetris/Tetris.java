/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tetris;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @FENNY JONG - 535210001
 */
public class Tetris extends JPanel {   
    //score total
    private int totalScore = 0;
    private int totalLine = 0;
   
    private Tetromino current = Tetromino.randomOne();
    private Tetromino next = Tetromino.randomOne();
    
    private final int row = 20;
    private final int col = 10;
    
    private Cell[][] wall = new Cell[row][col];
    private static final int CELL_SIZE = 26;
       int level = 1;
    
    
    void drawWall(Graphics g) {
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int x = CELL_SIZE * j;
                int y = CELL_SIZE * i;
                
                Cell cell = wall[i][j];
                if (cell == null) {
                    g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
                } else {
                    g.drawImage(cell.getImage(), x, y, CELL_SIZE, CELL_SIZE, null);
                }
            }
        }
    } 
   
    public void paintScore(Graphics g) {
		 g.setFont (new Font ("italic", Font.BOLD, 20)); 
		 g.drawString ("Next:", 285, 20);

        g.drawRect(280, 125, 300 , 100);
        g.drawString ("Level:" + level, 285, 150);
        g.drawString ("Score:" + totalScore, 285, 180);
        g.drawString ("Lines:" + totalLine, 285, 210); 
        g.drawString ("UP       [Rotate]" , 300 , 270);
        g.drawString ("SPACE [Fast Drop]" , 300 , 300);
         g.drawString ("ESC     [Quit]" , 300 , 330);
 

		g.drawRect(300, 380, 170, 80);
		g.drawString("Right", 315, 400);
		g.drawString("Down", 370, 430);
		g.drawString("Left",415, 400);
	}
    
    
    void drawCurrent(Graphics g) {
        Cell[] cells = current.cells;
        for (Cell cell : cells) {
            int x = cell.getCol() * CELL_SIZE;
            int y = cell.getRow() * CELL_SIZE;
            g.drawImage(cell.getImage(), x, y, CELL_SIZE, CELL_SIZE, null);
        }
    }
    
    void drawNext(Graphics g) {
        Cell[] cells = next.cells;
        for (Cell cell : cells) {
            int x = cell.getCol() * CELL_SIZE + 260;
            int y = cell.getRow() * CELL_SIZE + 26;
            g.drawImage(cell.getImage(), x, y, CELL_SIZE, CELL_SIZE, null);
        }
    }
     void gameOver(Graphics g) {
           if (isGameOver () == true){
                g.setFont (new Font ("italic",Font.BOLD, 40)); 
                g.drawString ("GAME OVER" , 15 , 250);
           }
    } 
     
    @Override
    public void paint(Graphics g) {
        //menentukan posisi asal koordinat 
        g.translate(0, 0);
        super.paint(g);
        paintScore(g);
        drawWall(g);
        drawCurrent(g);
        drawNext(g);
        gameOver(g);
    }
    
    boolean outOfBound() { // di bawah
        Cell[] cells = current.cells;
        for (Cell cell: cells) {
            int celRow = cell.getRow();
            if (celRow <= 0 || celRow >= row-1){
                return true;
            }
        }
        return false;
    }
    
    boolean tooLeft() { // terlalu ke kiri
        Cell[] cells = current.cells;
        for (Cell cell: cells) {
            int celCol = cell.getCol();
            if (celCol <= 0){
                return true;
            }
        }
        return false;
    }
    
    boolean tooRight() { // terlalu ke kanan
        Cell[] cells = current.cells;
        for (Cell cell: cells) {
            int celCol = cell.getCol();
            if (celCol >= col-1){
                return true;
            }
        }
        return false;
    }
    
    boolean coincide() { // kalau ketemu bidak lainnya
        Cell[] cells = current.cells;
        for (Cell cell: cells) {
            int celCol = cell.getCol();
            int celRow = cell.getRow();
            if (wall[celRow][celCol] != null){
                return true;
            }
        }
        return false;
    }
    
    boolean isDrop() { // pemeriksaan kesempatan turun
        Cell[] cells = current.cells;
        for (Cell cell: cells) {
            int celCol = cell.getCol();
            int celRow = cell.getRow();
            
            if(celRow == row-1) {
                return false;
            }
            
            if (wall[celRow+1][celCol] != null){
                return false;
            }
        }
        return true;
    }
    
    void stopDropping () { // jika bidak sudah sampai bawah
        Cell[] cells = current.cells;
        for(Cell cell : cells) {
            int celrow = cell.getRow();
            int celcol = cell.getCol();
            wall[celrow][celcol] = cell;
        }
    }
    
    protected void softDrop() {
        if(isDrop()) {
            current.softDrop();
        } else {
            stopDropping();
            current = next;
            next = Tetromino.randomOne();
        }        
    }
    
    public boolean canDrop() {
		Cell[] cells=current.cells;
		for (Cell cell : cells) {
			int row=cell.getRow();
			int col=cell.getCol();
			if(row==19) {
				return false;
			}
			if(wall[row+1][col]!=null) {
				return false;
			}
		}
		
		return true;
	}

    public void quickDropAction() { //fast drop
		for (;;) {
			if (canDrop() == true) {
				current.softDrop();
			} else {
				break;
			}
		}
                landToWall();
		destroyLine();
	}
   
    public void landToWall() {
		Cell[] cells = current.cells;
		for (Cell c : cells) {
			int row = c.getRow();
			int col = c.getCol();
			 wall [row][col] = c;
		}
	}
    
    //score
    public void destroyLine() {
		int lines = 0; 

		Cell[] cells  = current.cells; 
		for (Cell c : cells) {
			 int row = c.getRow (); 
			while (row < 20) {
				 if (isFullLine (row) == true) { //jika baris penuh
                                     Tetromino.PlayClear();
					 lines ++;

					 wall [row] = new Cell[10];
					for (int i = row; i > 0; i--) {
						 System.arraycopy(wall [i-1], 0, wall [i], 0, 10);
					}
					wall[0] = new Cell[10];
				}
				row++;
			}
		}
		totalLine += lines;
                totalScore = totalLine * 150;
                if(totalScore >= 500 && totalScore <1000){
				level = 2;
			}
			if(totalScore >=1000 && totalScore <2000){
				level = 3;
			}
			if(totalScore >=2000 && totalScore <5000){
				level = 4;
			}
			if(totalScore >=5000){
				level = 5;
			}
                
	}
    
	public boolean isFullLine(int row) {
		Cell[] lines = wall[row];
		for (Cell c : lines) {
			if (c == null) {
				return false;
			}
		}
		return true;
	}
   
         public boolean isGameOver() {
		Cell[] cells = next.cells;
		for (Cell c : cells) {
			int row = c.getRow();
			int col = c.getCol();
			if (wall[row][col] != null) {
				return true;
			}
		}
		return false;
	}
         
         private void clearWall() {
		for (int row = 0; row < row; row++) {
			Arrays.fill(wall[row], null);
		}
	}
        
    protected void moveLeft() {
        if(!tooLeft() && !outOfBound() && !coincide())
            current.moveLeft();
    }
    
    protected void moveRight() {
        if(!tooRight() && !outOfBound() && !coincide())
            current.moveRight();
    }
    
   public void rotateAction() { // rotate
		current.rotateRight();
		if (outOfBound() == true || coincide() == true) {
			 current.rotateLeft ();
		}
	}
   
    public void start() {
        KeyListener keylist = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent args) {
                int key = args.getKeyCode();
                
                if (key == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                if (isGameOver())
                    return;
                                
                switch(key) {
                     case KeyEvent.VK_UP : {
                      rotateAction();
                        break;
                    }
                    case KeyEvent.VK_DOWN : {
                        softDrop();
                        break;
                    } case KeyEvent.VK_LEFT : {
                        moveLeft();
                        break;
                    } case KeyEvent.VK_RIGHT : {
                        moveRight();
                        break;
                    } case KeyEvent.VK_SPACE: {
                        quickDropAction();
                    }
                }
                repaint();
            }
        };
        
        this.addKeyListener(keylist);
        this.requestFocus();
        
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    if (isDrop()){
                        softDrop();
                     } else {
                    landToWall();
                    destroyLine();
                     if (isGameOver () == true){
                         Tetromino.playGameover();
                         break;
                    } else {
                        stopDropping();
                        current = next;
                        next = Tetromino.randomOne();
                    }
                }
                     repaint();
            }
        }
    }.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Tetris");
        frame.setSize(530, 580);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Tetris tetrisPanel = new Tetris();
        frame.add(tetrisPanel);
        frame.setVisible(true);
        tetrisPanel.start();
    } 
}
