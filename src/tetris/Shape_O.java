/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

/**
 *
 * @FENNY JONG - 535210001
 */
public class Shape_O extends Tetromino{
    public Shape_O() {
        cells[0] = new Cell(0,4, Tetromino.O);
        cells[1] = new Cell(0,5, Tetromino.O);
        cells[2] = new Cell(1,4, Tetromino.O);
        cells[3] = new Cell(1,5, Tetromino.O);
        
          //menentukan titik koordinat
       states = new State[] { new State(new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }) };
    }
}
