/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard.core;

/**
 *
 * @author helalami
 */
public class Pawn extends Pieces{
    private int pawnMoves = 0;
    
    public Pawn(String name, String color){
        super(name, color);
    }
    
    public Boolean allowedMove(int initX, int initY, int newX, int newY, boolean takingPiece, boolean movingPiece)
    {
        if(takingPiece == true)
        {
            if(color.equals("W"))
            {                
                if((newY == initY-1 || newY == initY+1) && newX == initX-1)
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
                if((newY == initY-1 || newY == initY+1) && newX == initX+1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            
        }
        else if(movingPiece == true)
        {
            if(color.equals("W"))
            {
                if(pawnMoves == 0)
                {
                    if((newX == initX-1 || newX == initX-2) && initY == newY)
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
                    if(newX == initX-1 && newY == initY)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }

           }
           else
           {
               if(pawnMoves == 0)
               {
                   if((newX == initX+1 || newX == initX+2) && newY == initY)
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
                   if(newX == initX+1 && newY == initY)
                   {
                       return true;
                   }
                   else
                   {
                       return false;
                   }
               }
           }
       }
       else
       {
           System.out.println("Error on the notation");
       }
       return false;
   }
   public void addMove()
   {
       this.pawnMoves = pawnMoves + 1;
   }

    
}
