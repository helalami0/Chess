/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard.core;

/**
 *
 * @author helalami
 */
public class Knight extends Pieces{
    public Knight(String name, String color){
        super(name, color);
    }
    
    public Boolean allowedMove(int initX, int initY, int newX, int newY, boolean takingPiece, boolean movingPiece)
    {
        if(takingPiece || movingPiece)
        {
            if(newX == initX-2 && (newY == initY-1 || newY == initY+1))
            {
                return true;
            }
            else if(newX == initX-1 && (newY == initY-2 || newY == initY+2))
            {
                return true;
            }
            else if(newX == initX+1 && (newY == initY+2 || newY == initY-2))
            {
                return true;
            }
            else if(newX == initX+2 && (newY == initY-1 || newY == initY+1))
            {
                return true;
            }
            else
            {
                System.out.println("Knights don't move like that");
                return false;
            }
        }
        return false;
    }
}
