import java.util.Scanner;
public class TicTacToe{
    // creating the arrays that are to be used in the given game.
   static char[] board=new char[9];
   static char[] PLAYERS={'X','O'};
   // here i refers to the current index that is being used in order to assign the numbering to each and every cell of the given matrix of tictactoe
   static void CellNumbering(int i){
    if(i==9) return;
    board[i]=(char)('1'+i);
    CellNumbering(i+1);
    
   }
   static int checkValidmove(Scanner sc,char player){
    int pos=sc.nextInt()-1;
    if(pos<0 || pos>8 || board[pos]=='X' || board[pos]=='O'){
        System.out.println("Invalid position choosen!");
        return checkValidmove(sc,player);
    }
      return pos;
   }
   static int[][] WINS={{0,1,2}, {3,4,5}, {6,7,8}, // rows
    {0,3,6}, {1,4,7}, {2,5,8}, // cols
    {0,4,8}, {2,4,6} // diagonals
     };// p here refers to the character of the player itself.
   static boolean checkWinner(int lineIdx, char p){
      if(lineIdx==WINS.length) return false;
      int[] win=WINS[lineIdx];
      if(board[win[0]]==p && board[win[1]]==p && board[win[2]]==p){
        return true;
      }
      return checkWinner(lineIdx+1,p);
   }
   static void playTurn(int moveCount,Scanner sc,int playerIdx){// decides whether to move on on being given the next turn or not.
    if(moveCount==9) {
        System.out.println("DRAW!");
        return;
    }
    char player=PLAYERS[playerIdx];
    System.out.printf("Player %d (%c), enter pos: ",playerIdx+1,player);
    int pos=checkValidmove(sc,player);// returns the position of the given cell at which the player wants to insert the character.
    board[pos]=player;
    printBoard();
    if(checkWinner(0,player)){
        System.out.printf("Player %d is the winner! %n",playerIdx+1);
        return;
    }
     playTurn(moveCount+1,sc,1-playerIdx);// swapping the players and also incrementing the index that is being moved.
    }
    static void printBoard(){
        System.out.println();
        for(int r=0;r<3;r++){
         System.out.printf("%c | %c | %c %n", board[3*r],board[3*r+1],board[3*r+2]);
         if(r<2) {
            System.out.println("--------------");
         }
        }
        System.out.println();
    }


    public static void main(String[] args){
     
    }
}