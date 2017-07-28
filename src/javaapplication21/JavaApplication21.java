/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dscs01
 */
public class JavaApplication21 {

    /**
     * @param args the command line arguments
     */
    static TicTacToe game;
    static Scanner s;
    static Random r = new Random() ;
    public static void main(String[] args) {
        // TODO code application logic here
// Create game and initialize it.
// First player will be 'x'
        game = new TicTacToe();
// Player 'x' places a mark in the top right corner row 0, column 2
// These values are based on a zero index array, so you may need to simply take in a row 1 and subtract 1 from it if you want that.
        s = new Scanner(System.in);
        while (!game.isBoardFull()) {

            insertValue();
            game.printBoard();
            checkForWinner();
            game.changePlayer();
            System.out.println("Computer enters the value ");
            insertValuePc();
            game.changePlayer();
// Lets print the board
            game.printBoard();
            checkForWinner();

// Did we have a winner?
        }

// No winner or draw, switch players to 'o'
        game.changePlayer();

// Repeat steps again for placing mark and checking game status..
    }
    static int row ;
    static int col ;
    public static void insertValue() {
        
        System.out.println("enter a cell no : ");
        putValues(s.nextInt());
        
        while (!game.placeMark(row, col)) {
            System.out.println("error ,...enter a cell no again : ");
            putValues(s.nextInt());
        }
    }
    public static void insertValuePc(){
            
            int i = r.nextInt((9 - 1) + 1) + 1;
            putValues(i);
            if(!game.placeMark(row, col)){
                insertValuePc();
            }
 
    }
    public static void putValues(int cell ){
        switch(cell){
            case 1:
                row = 0;
                col = 0;
                break;
            case 2:
                row = 0;
                col = 1;
                break;
            case 3:
                row = 0;
                col = 2;
                break;
            case 4:
                row = 1;
                col = 0;
                break;
            case 5:
                row = 1;
                col = 1;
                break;
            case 6:
                row = 1;
                col = 2;
                break;
            case 7:
                row = 2;
                col = 0;
                break;
            case 8: 
                row = 2;
                col = 1;
                break;
            case 9: 
                row = 2;
                col = 2;
                break;
            default:
                row = 9;
                col = 9;
                break;
        }
    }
    public static void checkForWinner() {
        if (game.checkForWin()) {
            System.out.println("We have a winner! Congrats!");
            System.exit(0);
        } else if (game.isBoardFull()) {
            System.out.println("Appears we have a draw!");
            System.exit(0);
        }
    }

}
