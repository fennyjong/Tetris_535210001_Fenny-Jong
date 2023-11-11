/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

/**
 *
 * @FENNY JONG - 535210001
 */
public class Shape_S extends Tetromino{
    public Shape_S() {
        cells[0] = new Cell(1,4, Tetromino.S);
        cells[1] = new Cell(0,3, Tetromino.S);
        cells[2] = new Cell(0,4, Tetromino.S);
        cells[3] = new Cell(1,5, Tetromino.S);
        
        //menentukan titik koordinat
   states = new State[] { new State(new int[][] { { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 } }),
            new State(new int[][] { { 0, 0 }, { -1, 0 }, { 1, 1 }, { 0, 1 } }) };
    }
}
