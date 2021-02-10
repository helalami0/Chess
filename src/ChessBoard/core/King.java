/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard.core;

/**
 *
 * @author helalami
 */
public class King extends Pieces{
    private int kingMove = 0;
    
    public King(String name, String color){
        super(name, color);
    }
    
    public Boolean allowedMove(int initX, int initY, int newX, int newY, boolean takingPiece, boolean movingPiece)
    {
        if(newX == initX+1 || newX == initX-1 || newY == initY+1 || newX == initY-1 || (newX == initX+1 && newY == initY+1) || (newX == initX+1 && newY == initY-1) || (newX == initX-1 && newY == initY+1) || (newX == initX-1 && newY == initY-1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean allowedToCastle()
    {
        if(kingMove == 0)
        {
            return true;
        }
        return false;
    }
    public void addMove()
    {
        this.kingMove = kingMove + 1;
    }
}
