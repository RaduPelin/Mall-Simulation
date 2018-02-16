import java.io.*;
public abstract class YourBusiness implements Serializable{
    protected String name;
    protected double pricePerSquare;
    protected String type;
 
    protected static double spaceOccupied  = 0;
    
    public YourBusiness(String name, double pricePerSquare, String type){
        this.name = name;
        this.pricePerSquare = pricePerSquare;
        this.type = type;
    }
    
    public abstract double totalPrice();
    
    public abstract double totalSpace();
    
    public String getName(){
        return this.name;
    }
    
}
