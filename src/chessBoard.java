import ChessBoard.core.*;
import Gui.*;

import java.util.Scanner;

public class chessBoard
{

  public static void main(String[] args)
  {

      ChessBoard test = new ChessBoard("White");
      Scanner scanner = new Scanner(System.in);
      boolean Continue = true;
      
      test.printChessBoardPiece();
      
      while(Continue == true)
      {
          System.out.println("Enter the piece to move (In Chess Notation ex: Nb1-c3/ or you can write exit): ");
          String notation = scanner.nextLine();
          if(notation.equals("exit"))
          {
              Continue = false;
          }
          else
          {
              test.movePieceNotation(notation);
              test.printChessBoardPiece();
          }
      }

      //Buttons test = new Buttons();
  }
}
