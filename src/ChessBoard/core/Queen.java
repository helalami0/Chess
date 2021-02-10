/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard.core;

/**
 *
 * @author helalami
 */
public class Queen extends Pieces{
    public Queen(String name, String color){
        super(name, color);
    }
    
    public Boolean allowedMove(int initX, int initY, int newX, int newY, boolean takingPiece, boolean movingPiece)
    {
        int x = 1;
        int y = 1;
        
        while(x < 8)
        {
            if(newX == initX+x && newY == initY)
            {
                return true;
            }
            if(newX == initX-x && newY == initY)
            {
                return true;
            }
            if(newX == initX && newY == initY+x)
            {
                return true;
            }
            if(newX == initX && newY == initY-x)
            {
                return true;
            }
            x++;
        }
        while(y < 8)
        {
            if(newX == initX+y && newY == initY+y)
            {
                return true;
            }
            if(newX == initX+y && newY == initY-y)
            {
                return true;
            }
            if(newX == initX-y && newY == initY+y)
            {
                return true;
            }
            if(newX == initX-y && newY == initY-y)
            {
                return true;
            }
            y++;
        }
        return false;
    }
    
}
