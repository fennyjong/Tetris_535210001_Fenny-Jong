/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;


/**
 *
 * @FENNY JONG - 535210001
 */
public class State {
	int[] rows = new int[4];
	int[] cols = new int[4];
    int length;
        
	public State() {
	}

	public State(int[][] rowAndCol) {
		super();
		for (int i = 0; i < 4; i++) {
			this.rows[i] = rowAndCol[i][0];
			this.cols[i] = rowAndCol[i][1];
		}
	}
}