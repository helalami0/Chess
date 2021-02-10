/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard.core;

/**
 *
 * @author helalami
 */
public class Square {
    private Pieces piece;
    private String color;
    private int x, y;
    private String squareName;
    
    public Square(String color, int x, int y){
        this.color = color;
        piece = null;
        this.x = x;
        this.y = y;
        squareName = null;
    }
    
    public Square(Pieces piece, String color, int x, int y, String squareName)
    {
        this.piece = piece;
        this.color = color;
        this.x = x;
        this.y = y;
        this.squareName = squareName;
    }
    
    public String getSquareColor(){
        return color;
    }
    
    public Pieces getSquarePiece(){
        return piece;
    }
    
    public void setSquarePiece(Pieces piece){
        this.piece = piece;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setSquareName(String squareName)
    {
        this.squareName = squareName;
    }
    
    public String getSquareName()
    {
        return squareName;
    }
    
    
        
}
