package ChessBoard.core;
import java.util.*;

public class ChessBoard
{
  private Square[][] chessBoard;
  private Pieces pawnWa = new Pawn("P", "W"), 
                 pawnWb = new Pawn("P", "W"), 
                 pawnWc = new Pawn("P", "W"), 
                 pawnWd = new Pawn("P", "W"), 
                 pawnWe = new Pawn("P", "W"), 
                 pawnWf = new Pawn("P", "W"), 
                 pawnWg = new Pawn("P", "W"), 
                 pawnWh = new Pawn("P", "W"), 
                 pawnBa = new Pawn("P", "B"),
                 pawnBb = new Pawn("P", "B"),
                 pawnBc = new Pawn("P", "B"),
                 pawnBd = new Pawn("P", "B"),
                 pawnBe = new Pawn("P", "B"),
                 pawnBf = new Pawn("P", "B"),
                 pawnBg = new Pawn("P", "B"),
                 pawnBh = new Pawn("P", "B"),
                 rookW = new Rook("R", "W"), 
                 rookB = new Rook("R", "B"),
                 knightW = new Knight("N", "W"), 
                 knightB = new Knight("N", "B"),
                 bishopW = new Bishop("B", "W"), 
                 bishopB = new Bishop("B", "B"),
                 queenW = new Queen("Q", "W"),
                 queenB = new Queen("Q", "B"),
                 kingW = new King("K", "W"),
                 kingB = new King("K", "B");
    
  //X and Y are flipped 0,0 = rook; 0,1 = Knight; 1,0 = Pawn; 1,1 = Pawn                          
  
  private List<Pieces> eatenPieces = new ArrayList();
  //Variables used by notation converter
  private int initX = -1, initY = 0, newX = 0, newY = 0;
  boolean takingPiece = false, movingPiece = false, isTurnWhite = true, isCheckMate = false;
  private String pieceS = "false", pieceE = "false", pieceType = "false";
  
 public ChessBoard(String color)
 {
    this.chessBoard = new Square[8][8];
    for(int i = 0; i<=7; i+=2)
    {
        for(int j = 0; j<=7; j+=2)
        {
            chessBoard[i][j] = new Square("White", i, j);
        }
        for(int j = 1; j<=7; j+=2)
        {
            chessBoard[i][j] = new Square("Black", i, j);
        }
    }
    for(int i = 1; i<=7; i+=2)
    {
        for(int j = 0; j<=7; j+=2)
        {
            chessBoard[i][j] = new Square("Black", i, j);
        }
        for(int j = 1; j<=7; j+=2)
        {
            chessBoard[i][j] = new Square("White", i, j);
        }
    }

    chessBoard[1][0].setSquarePiece(pawnBa);
    chessBoard[1][1].setSquarePiece(pawnBb);
    chessBoard[1][2].setSquarePiece(pawnBc);
    chessBoard[1][3].setSquarePiece(pawnBd);
    chessBoard[1][4].setSquarePiece(pawnBe);
    chessBoard[1][5].setSquarePiece(pawnBf);
    chessBoard[1][6].setSquarePiece(pawnBg);
    chessBoard[1][7].setSquarePiece(pawnBh);
    
    chessBoard[6][0].setSquarePiece(pawnWa);
    chessBoard[6][1].setSquarePiece(pawnWb);
    chessBoard[6][2].setSquarePiece(pawnWc);
    chessBoard[6][3].setSquarePiece(pawnWd);
    chessBoard[6][4].setSquarePiece(pawnWe);
    chessBoard[6][5].setSquarePiece(pawnWf);
    chessBoard[6][6].setSquarePiece(pawnWg);
    chessBoard[6][7].setSquarePiece(pawnWh);
    

    
    chessBoard[0][0].setSquarePiece(rookB);
    chessBoard[0][1].setSquarePiece(knightB);
    chessBoard[0][2].setSquarePiece(bishopB);
    chessBoard[0][3].setSquarePiece(queenB);
    chessBoard[0][4].setSquarePiece(kingB);
    chessBoard[0][5].setSquarePiece(bishopB);
    chessBoard[0][6].setSquarePiece(knightB);
    chessBoard[0][7].setSquarePiece(rookB);
    
    chessBoard[7][0].setSquarePiece(rookW);
    chessBoard[7][1].setSquarePiece(knightW);
    chessBoard[7][2].setSquarePiece(bishopW);
    chessBoard[7][3].setSquarePiece(queenW);
    chessBoard[7][4].setSquarePiece(kingW);
    chessBoard[7][5].setSquarePiece(bishopW);
    chessBoard[7][6].setSquarePiece(knightW);
    chessBoard[7][7].setSquarePiece(rookW);
    
    int x = 8;
    for(int i = 0; i<8; i++)
    {
        chessBoard[i][0].setSquareName("a" + x);
        chessBoard[i][1].setSquareName("b" + x);
        chessBoard[i][2].setSquareName("c" + x);
        chessBoard[i][3].setSquareName("d" + x);
        chessBoard[i][4].setSquareName("e" + x);
        chessBoard[i][5].setSquareName("f" + x);
        chessBoard[i][6].setSquareName("g" + x);
        chessBoard[i][7].setSquareName("h" + x);
        x--;
    }
      

  }
 public void printChessBoardSquare(Square[][] chessB)
 {
    for(int i = 0; i<chessB.length; i++)
    {
      for(int j = 0; j<chessB[i].length; j++)
      {
          System.out.print(chessB[i][j].getSquareName());
          System.out.print(" ");
      }
      System.out.println("");
    }
  }
 public void printChessBoardPiece()
 {
    
    for(int i = 0; i<chessBoard.length; i++)
    {
      for(int j = 0; j<chessBoard[i].length; j++)
      {
        if(chessBoard[i][j].getSquarePiece() != null){
            System.out.print("_" + chessBoard[i][j].getSquarePiece().getName());
            System.out.print(" ");
        }
        else{
            System.out.print(chessBoard[i][j].getSquareName());
            System.out.print(" ");       
        }
      }
      System.out.println("");
    }
  }
 public void printChessBoardPieceCopy(Square[][] chessB)
 {
    for(int i = 0; i<chessB.length; i++)
    {
      for(int j = 0; j<chessB[i].length; j++)
      {
        if(chessB[i][j].getSquarePiece() != null){
            System.out.print("_" + chessB[i][j].getSquarePiece().getName());
            System.out.print(" ");
        }
        else{
            System.out.print(chessB[i][j].getSquareName());
            System.out.print(" ");       
        }
      }
      System.out.println("");
    }
  }
 public Boolean canCastle(int x, int y, int nX, int nY)
 {
     if(chessBoard[x][y].getSquarePiece().getName().equals("K") && chessBoard[x][y].getSquarePiece().allowedToCastle())
     {
         if((x == 7 || x == 0) && y == 4)
         {
             if(chessBoard[nX][nY].getSquarePiece() != null && chessBoard[nX][nY].getSquarePiece().getName().equals("R"))
             {
                 if((nX == 0 && nY == 0) || (nX == 0 && nY == 7) || (nX == 7 && nY == 0) || (nX == 7 && nY == 7))
                 {
                        int a = 1;
                        int b = 1;
                        while(a < 8)
                        {
                            if(nX == a && y == nY+a)
                            {
                                while(b != nY+b)
                                {
                                    if(nY+b < 8)
                                    {
                                        if(chessBoard[a][nY+b].getSquarePiece() != null)
                                        {
                                            return false;
                                        }
                                    }
                                    b++;
                                }
                            }
                            else if(nX == a && b == b-a)
                            {
                                while(nY != b-b)
                                {
                                    System.out.println(nY-b);
                                    System.out.println(b);
                                    if(nY-b > 0)
                                    {
                                        if(chessBoard[a][nY-b].getSquarePiece() != null)
                                        {
                                            return false;
                                        }
                                    }
                                    b++;
                                }
                            }
                            a++;
                         }
                         return true;
                 }
             }
         }
     }
     return false;
 }
 public void movePieceNotation(String notation)
 {
     convertNotation(notation);
     movePieceLocation();
 }
 public Boolean isBeingAttacked(Square[][] chessB, int x, int y)
 {
    Boolean a = takingPiece, b = movingPiece;
    isTurnWhite = !isTurnWhite;
    takingPiece = true;
    movingPiece = false;
    for(int i = 0; i<chessB.length; i++)
    {
        for(int j = 0; j<chessB[i].length; j++)
        {
            if(chessB[i][j].getSquarePiece() != null)
            {
                System.out.println("attackin King ? not sure");
                if(canMove(chessB, i, j, x, y))
                {
                    System.out.println(canMove(chessB, i, j, x, y));
                    System.out.println("attackin King ? Yes");
                    takingPiece = a;
                    movingPiece = b;
                    isTurnWhite = !isTurnWhite;
                    return true;
                }
            }
        }
    }
    takingPiece = a;
    movingPiece = b;
    isTurnWhite = !isTurnWhite;
    System.out.println("attackin King ? No");
    return false;
 }
 public Boolean isInCheck(Square[][] chessB)
 {
     String pColor;
     if(isTurnWhite)
     {
         pColor = "W";
     }
     else
     {
         pColor = "B";
     }
     for(int i=0; i<chessB.length; i++)
     {
         for(int j=0; j<chessB[i].length; j++)
         {
             if(chessB[i][j].getSquarePiece() != null && chessB[i][j].getSquarePiece().getTeamColor().equals(pColor) && chessB[i][j].getSquarePiece().getName().equals("K"))
             {
                 if(isBeingAttacked(chessB, i, j))
                 {
                     System.out.println("In check ? Yes");
                     return true;
                 }
             }
         }
     }
     return false;
 }
 public Boolean isInCheckMate()
 {
     if(isInCheck(chessBoard))
     {
         for(int x = 0; x < 8; x++)
         {
             for(int y = 0; y < 8; y++)
             {
                 if(chessBoard[x][y].getSquarePiece() != null)
                 {
                     for(int i = 0; i < 8; i++)
                     {
                         for(int j = 0; j < 8; j++)
                         {
                             if(canReallyMove(x, y, i, j))
                             {
                                 return false;
                             }
                         }
                     }
                 }
             }
         }
         return true;
     }
     return false;
 }
 public void movePieceLocation()
 {
      if(canCastle(initX, initY, newX, newY))
      {
          if(newX == 7 && newY == 0)
          {
              isTurnWhite = !isTurnWhite;
              if(!isBeingAttacked(chessBoard, 7, 3) || !isBeingAttacked(chessBoard, 7, 2))
              {
                  chessBoard[initX][initY].getSquarePiece().addMove();
                  chessBoard[7][0].setSquarePiece(null);
                  chessBoard[7][4].setSquarePiece(null);

                  chessBoard[7][3].setSquarePiece(rookW);
                  chessBoard[7][2].setSquarePiece(kingW);
              }
          }
          else if(newX == 7 && newY == 7)
          {
              isTurnWhite = !isTurnWhite;
              if(!isBeingAttacked(chessBoard, 7, 6) || !isBeingAttacked(chessBoard, 7, 5))
              {
                  chessBoard[initX][initY].getSquarePiece().addMove();
                  chessBoard[7][7].setSquarePiece(null);
                  chessBoard[7][4].setSquarePiece(null);

                  chessBoard[7][5].setSquarePiece(rookW);
                  chessBoard[7][6].setSquarePiece(kingW);
              }
          }
          else if(newX == 0 && newY == 0)
          {
              isTurnWhite = !isTurnWhite;
              if(!isBeingAttacked(chessBoard, 0, 3) || !isBeingAttacked(chessBoard, 0, 2))
              {
                  chessBoard[initX][initY].getSquarePiece().addMove();
                  chessBoard[0][0].setSquarePiece(null);
                  chessBoard[0][4].setSquarePiece(null);

                  chessBoard[0][3].setSquarePiece(rookW);
                  chessBoard[0][2].setSquarePiece(kingW);
              }
          }
          else if(newX == 0 && newY == 7)
          {
              isTurnWhite = !isTurnWhite;
              if(!isBeingAttacked(chessBoard, 0, 6) || !isBeingAttacked(chessBoard, 0, 5))
              {
                  chessBoard[initX][initY].getSquarePiece().addMove();
                  chessBoard[0][7].setSquarePiece(null);
                  chessBoard[0][4].setSquarePiece(null);

                  chessBoard[0][5].setSquarePiece(rookW);
                  chessBoard[0][6].setSquarePiece(kingW);
              }
          }
          else
          {
              isTurnWhite = !isTurnWhite;
              System.out.println("You can't castle !");
          }
      }
      else if(canFinallyMove(initX, initY, newX, newY))
      {
          System.out.println("You can move");
          if(chessBoard[initX][initY].getSquarePiece().getName().equals("P") || chessBoard[initX][initY].getSquarePiece().getName().equals("K"))
          {
              chessBoard[initX][initY].getSquarePiece().addMove();
          }
          Pieces pieceToChange;
          pieceToChange = chessBoard[initX][initY].getSquarePiece();
          chessBoard[initX][initY].setSquarePiece(null);
          chessBoard[newX][newY].setSquarePiece(pieceToChange);
          isTurnWhite = !isTurnWhite;
      } 
      else
      {
          System.out.println("This is an illegal move for x, y or z reason ...");
      }
  }
 public Boolean pieceCanMove(String pieceTypeR, Square[][] chessB ,int a, int b, int nA, int nB)
 {
     if (pieceTypeR.equals("R")) {
         int x = 1;
         int y = 1;
         while (x < 8) {
             if (nA + x == a && nB == b) {
                 while (nA + y != a) {
                     if (nA + y < 8) {
                         if (chessB[nA + y][nB].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     y++;
                 }
             } else if (nA - x == a && nB == b) {
                 while (nA - y != a) {
                     if (nA - y > 0) {
                         if (chessB[nA - y][nB].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     y++;
                 }
             } else if (nB + x == b && nA == a) {
                 while (nB + y != b) {
                     if (nB + y < 8) {
                         if (chessB[nA][nB + y].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     y++;
                 }
             } else if (nB - x == b && nA == a) {
                 while (nB - y != b) {
                     if (nB - y < 8) {
                         if (chessB[nA][nB - y].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     y++;
                 }
             }
             x++;
         }
         return true;
     } else if (pieceTypeR.equals("B")) {
         System.out.println(a);
         System.out.println(b);
         System.out.println(nA);
         System.out.println(nB);
         System.out.print(pieceTypeR);
         int z = 1;
         int x = 1;
         while (x < 8) {
             if (nA + x == a && nB + x == b) {
                 while (nA + z != a && nB + z != b) {
                     if (nA + z < 8 && nB + z < 8) {
                         if (chessB[nA + z][nB + z].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     z++;
                 }
             } else if (nA - x == a && nB + x == b) {
                 while (nA - z != a && nB + z != b) {
                     if (nA - z < 8 && nB + z < 0) {
                         if (chessB[nA - z][nB + z].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     z++;
                 }
             } else if (nA + x == a && nB - x == b) {
                 while (nA + z != a && nB - z != b) {
                     if (nA + z < 8 && nB - z > 0) {
                         if (chessB[nA + z][nB - z].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     z++;
                 }
             } else if (nA - x == a && nB - x == b) {
                 while (nA - z != a && nB - z != b) {
                     if (nA - z > 0 && nB - z > 0) {
                         if (chessB[nA - z][nB - z].getSquarePiece() != null) {
                             return false;
                         }
                     }
                     z++;
                 }
             }
             x++;
         }
         return true;
     } else if (pieceTypeR.equals("Q")) {
         if (pieceCanMove("B", chessB, a, b, nA, nB) && pieceCanMove("R", chessB, a, b, nA, nB)) {
             return true;
         }
         return false;
     } else {
         return true;
     }
 }
 public Square[][] chessBoardCopy(Square[][] chess)
 {
     Square[][] chessCopy = new Square[8][8];
     for(int i = 0; i<chessBoard.length; i++){
         for(int j = 0; j<chessBoard[i].length; j++)
         {
             Pieces squarePiece = chessBoard[i][j].getSquarePiece();
             String squareColor = chessBoard[i][j].getSquareColor();
             int squareX = chessBoard[i][j].getX();
             int squareY = chessBoard[i][j].getY();
             String squareName = chessBoard[i][j].getSquareName();
             chessCopy[i][j] = new Square(squarePiece, squareColor, squareX, squareY, squareName);
         }
     } 
     return chessCopy;
 }
 public Boolean nextMoveIsInCheck(int x, int y, int nX, int nY)
 {
     if(canMove(chessBoard, x, y, nX, nY) || canCastle(x, y, nX, nY))
     {
          Square[][] chessBoardA = chessBoardCopy(chessBoard);
          Pieces piece = chessBoardA[x][y].getSquarePiece();
          chessBoardA[x][y].setSquarePiece(null);
          chessBoardA[nX][nY].setSquarePiece(piece);
          if(chessBoardA[nX][nY].getSquarePiece().getName().equals("P"))
          {
              chessBoardA[nX][nY].getSquarePiece().addMove();
          }
          if(isInCheck(chessBoardA))
          {
              System.out.println("Next move in Check");
              return true;
          }
          else
          {
              System.out.println("Next move not in Check");
              return false;
          }
     }
     return false;
 }
 public Boolean canReallyMove(int x, int y, int nX, int nY)
 {
     if(canMove(chessBoard ,x, y, nX, nY))
     {
         if(!nextMoveIsInCheck(x, y, nX, nY))
         {
             return true;
         }
         else
         {
             return false;
         }
     }
     else
     {
         System.out.println("Can't move");
         return false;
     }
 }
 public Boolean canFinallyMove(int x, int y, int nX, int nY)
 {
     if(!isInCheckMate() && !canReallyMove(x, y, nX, nY))
     {
         return false;
     }
     else{
         return true;
     }
 }
 public Boolean canMove(Square[][] chessB, int x, int y, int nX, int nY)
 {
      pieceType = chessB[x][y].getSquarePiece().getName();
      if(x != -1)
      {
         if(chessB[x][y].getSquarePiece() == null){
             System.out.println("The square " + pieceS + " is Empty");
             return false;
         }
         else
         {
             if(chessB[x][y].getSquarePiece().allowedMove(x, y, nX, nY, takingPiece, movingPiece))
             {
                 if(chessB[nX][nY].getSquarePiece() != null)
                 {
                     if(chessB[x][y].getSquarePiece().getTeamColor().equals(chessB[nX][nY].getSquarePiece().getTeamColor()))
                     {
                         System.out.println("There is already a " + chessB[nX][nY].getSquarePiece().getTeamColor() + " Piece in that square");
                         return false;
                     }
                     else
                     {
                         if(chessB[x][y].getSquarePiece().getTeamColor().equals("W") == isTurnWhite)
                         {
                             if((isTurnWhite == true && chessB[nX][nY].getSquarePiece().getTeamColor().equals("B") && takingPiece == true) || (isTurnWhite == false && chessB[nX][nY].getSquarePiece().getTeamColor().equals("W") && takingPiece == true))
                             {
                                 System.out.println(x);
                                 System.out.println(y);
                                 System.out.println(nX);
                                 System.out.println(nY);
                                 System.out.print(pieceType);
                                 if(pieceCanMove(pieceType, chessB, x, y, nX, nY))
                                 {
                                     System.out.println("the piece can move to there");
                                     return true;
                                 }
                                 System.out.println("the piece can't move to there");
                                 return false;
                             }
                             else
                             {
                                 System.out.println("You didn't mention taking in your notation");
                                 return false;
                             }
                         }
                         else
                         {
                             System.out.println("You are trying to move the wrong colored piece");
                             return false;
                         }
                     }
                 }
                 else
                 {
                     if(chessB[x][y].getSquarePiece().getTeamColor().equals("W") == isTurnWhite)
                     {
                        if(pieceCanMove(pieceType, chessB, x, y, nX, nY))
                        {
                            return true;
                        }
                        return false;
                     }
                     else
                     {
                         System.out.println("You are trying to move the wrong colored piece");
                         return false;
                     }
                 }
             }   
             else
             {
                 System.out.println("This is an illegal move, pieces don't move like that");
                 return false;
             }
         }
      }
      return false;
 }   
 public String getPieceName(String notation)
 {
      convertNotation(notation);
      if(chessBoard[initX][initY].getSquarePiece() != null)
      {        
          System.out.println(chessBoard[initX][initY].getSquarePiece().getName());
          return chessBoard[initX][initY].getSquarePiece().getName();
      }
      else{
          System.out.println("The square " + pieceS + " is Empty");
          return "Null";
      }
  }
 //Notation converter takes in a notation and stores Six variables
 public void convertNotation(String notation)
 {
     int ix = 0, iy = 2, fx = 3, fy = 5;
     Boolean a = false, b = false, c = true;
     String piece = "false";
     while(c == true)
     {
         if(notation.indexOf("-") >= 0 || notation.indexOf("x") >= 0)
         {
             piece = notation.substring(0, 1);
             takingPiece = false;
             movingPiece = true;

             if(piece.equals(piece.toLowerCase()) == true) 
             {
                 if(piece.equals("a") || piece.equals("b") || piece.equals("c") || piece.equals("d") || piece.equals("e") || piece.equals("f") || piece.equals("g") || piece.equals("h"))
                 {
                     pieceS = notation.substring(ix,iy);
                     pieceE = notation.substring(fx,fy);
                     pieceType = "P";
                 }
             }
             else if(piece.equals("R") || piece.equals("N") || piece.equals("B") || piece.equals("Q") || piece.equals("K"))
             {
                 pieceS = notation.substring(ix+1,iy+1);
                 pieceE = notation.substring(fx+1,fy+1);
                 pieceType = piece;
             }
             else
             {
                 System.out.println("Error on the Notation");
                 c = false;
             }
             if(pieceS.equals("false") || pieceE.equals("false"))
             {
                 System.out.println("PieceS or PieceE isn't modified");
                 c = false;
             }
             while(a != true)
             {
                 for(int i = 0; i < 8; i++)
                 {
                     for(int j = 0; j < 8; j++)
                     {
                        if(chessBoard[i][j].getSquareName().equals(pieceS))
                        {
                            initX = chessBoard[i][j].getX();
                            initY = chessBoard[i][j].getY();
                            a = true;
                        }
                     }
                 }
             }
             while(b != true)
             {
                 for(int i = 0; i < 8; i++)
                 {
                     for(int j = 0; j < 8; j++)
                     {
                        if(chessBoard[i][j].getSquareName().equals(pieceE))
                        {
                            newX = chessBoard[i][j].getX();
                            newY = chessBoard[i][j].getY();
                            b = true; 
                            c = false;
                        }
                     }
                 }
             }
            
             if(notation.indexOf("x") >= 0 && chessBoard[newX][newY].getSquarePiece() != null)
             {
                 movingPiece = false;
                 takingPiece = true;
             }
             else if(notation.indexOf("x") >= 0)
             {
                 movingPiece = false;
                 takingPiece = false;
                 System.out.println("You can't take an empty square");
             }
         }
         else if(notation.length() == 2)
         {
             piece = notation.substring(0, 1);

             if(piece.equals(piece.toLowerCase()) == true) 
             {
                 if(piece.equals("a") || piece.equals("b") || piece.equals("c") || piece.equals("d") || piece.equals("e") || piece.equals("f") || piece.equals("g") || piece.equals("h"))
                 {
                     pieceS = notation.substring(ix,iy);
                     pieceType = "P";
                 }
             }
             else if(piece.equals("R") || piece.equals("N") || piece.equals("B") || piece.equals("Q") || piece.equals("K"))
             {
                 pieceS = notation.substring(ix+1,iy+1);
                 pieceType = piece;
             }
             else
             {
                 System.out.println("Error on the Notation");
                 c = false;
             }
             if(pieceS.equals("false"))
             {
                 System.out.println("PieceS or PieceE isn't modified");
                 c = false;
             }
             while(a != true)
             {
                 for(int i = 0; i < 8; i++)
                 {
                     for(int j = 0; j < 8; j++)
                     {
                        if(chessBoard[i][j].getSquareName().equals(pieceS))
                        {
                            initX = chessBoard[i][j].getX();
                            initY = chessBoard[i][j].getY();
                            a = true;
                            c = false;
                        }
                     }
                 }
             }
         }
         else
         {
             System.out.println("Error on the notation");
             c = false;
         }
     }
  }
}

  
  
 