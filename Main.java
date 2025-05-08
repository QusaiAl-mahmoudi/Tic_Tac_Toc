package Tic_Tac_Toc;
/*  
 *  >> AL-mhmoudi .~
 * << By : Qusai Adam >>
 */

import java.util.Random;
import java.util.Scanner;

/*
 * @coder Qusai Adam
 */
 
public class Main {
    
   public static void printBoard(char board[][]) {
       System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
       System.out.println("-+-+-");
       System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
       System.out.println("-+-+-");
       System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
        
       }
    
    public static void  placeMove(char board[][],int op,char symbol){
        switch(op){
           case 1:
            board[0][0] = symbol;break;
            case 2:
            board[0][1] = symbol;break;
            case 3:
            board[0][2] = symbol;break;
            case 4:
            board[1][0] = symbol;break;
            case 5:
            board[1][1] = symbol;break;
            case 6:
            board[1][2] = symbol;break;
            case 7:
            board[2][0] = symbol;break;
            case 8:
            board[2][1] = symbol;break;
            case 9:
            board[2][2] = symbol;break;
            default:
            System.out.println(":(");
        }
    }
    public static  boolean isValidMove(char [][] board,int position){
        switch(position){
           case 1:
            return (board[0][0] == ' ');
            case 2:
            return (board[0][1] == ' ');
            case 3:
            return (board[0][2] == ' ');
            case 4:
            return (board[1][0] == ' ');
            case 5:
            return (board[1][1] == ' ');
            case 6:
            return (board[1][2] == ' ');
            case 7:
            return (board[2][0] == ' ');
            case 8:
            return (board[2][1] == ' ');
            case 9:
            return (board[2][2] == ' ');
            default:
             return true;
        }
    }
    public static boolean checkWin(char board[][],char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }
    public static boolean isGameFinshed(char board[][]){
        if(checkWin(board,'x')){
          printBoard(board);
            System.out.println("player is wins!");
            return true;
        }
        if(checkWin(board,'o')){
          printBoard(board);
            System.out.println("computer is wins!");
            return true;
        }
        
        
        for(int i= 0; i<board.length;i++){
            for(int j= 0; j<board[0].length;j++){
                if(board[i][j] == ' ')
                    return false;
        }
        }
        return true;
    }
    
    public static void playerTurn(char board[][],Scanner sc){
        int userInput;
        while(true){
        System.out.println("Where would you like to play :(1-9)");
         userInput = sc.nextInt();
              if( isValidMove(board, userInput))
                break;
            else 
                System.out.println(userInput+" is not a valid move !");
      
        }
         placeMove(board,userInput,'x');
    
    }
    
    public static void computerTurn(char board[][]){
        Random rand = new Random();
        int computerPlay ;
        while(true){
            computerPlay = rand.nextInt(9)+1;
            if( isValidMove(board,computerPlay))
                break;
        }
        System.out.println("Computer chose :"+computerPlay);
        placeMove(board,computerPlay,'o');
        
    }
    //main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char board[][] = new char[3][3];
        for(int i= 0; i<board.length;i++){
            for(int j= 0; j<board[0].length;j++)
                board[i][j] =' ';
        }
        printBoard(board);
        while(true){
            playerTurn(board,sc);
            if(isGameFinshed(board))
                break;
             printBoard(board);
             computerTurn(board);
            if(isGameFinshed(board))
                break;
             printBoard(board);
         }
    }
}