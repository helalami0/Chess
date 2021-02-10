package ChessBoard.core;


public abstract class Pieces {
    private String name;
    protected String color;
    
    public Pieces(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName(){
        return name;
    }
    
    public String getTeamColor(){
        return color;
    }
    
    public Boolean allowedMove(int initX, int initY, int newX, int newY, boolean takingPiece, boolean movingPiece)
    {
        return false;
    }
    
    public Boolean allowedToCastle()
    {
        return false;
    }
    public void addMove()
    {
       
    }
}
