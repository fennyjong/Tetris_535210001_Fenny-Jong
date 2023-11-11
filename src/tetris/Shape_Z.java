/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

/**
 *
 * @FENNY JONG - 535210001
 */
public class Shape_Z extends Tetromino{
    public Shape_Z() {
        cells[0] = new Cell(0,4, Tetromino.Z);
        cells[1] = new Cell(0,5, Tetromino.Z);
        cells[2] = new Cell(1,3, Tetromino.Z);
        cells[3] = new Cell(1,4, Tetromino.Z);
        
        //menentukan titik koordinat
  states = new State[] { new State(new int[][] { { 0, 0 }, { -1, -1 }, { -1, 0 }, { 0, 1 } }),
           new State(new int[][] { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 0 } }) };
    }
}
