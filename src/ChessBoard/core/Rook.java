/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard.core;

/**
 *
 * @author helalami
 */
public class Rook extends Pieces{
    public Rook(String name, String color){
        super(name, color);
    }
    
    public Boolean allowedMove(int initX, int initY, int newX, int newY, boolean takingPiece, boolean movingPiece)
    {
        int x = 1;
        
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
        return false;
    }
    
}
