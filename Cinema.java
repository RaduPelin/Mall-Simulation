public class Cinema extends YourBusiness{
    private static Cinema c;
    int rooms;
    double spacePerRoom;
    double auxiliarSpace;
    
    private Cinema(String name, double pricePerSquare, int rooms, double spacePerRoom, double auxiliarSpace){
        super(name,pricePerSquare,null);
        this.rooms = rooms;
        if(spacePerRoom < 50){
            throw new TooSmallException();
        }
        this.spacePerRoom = spacePerRoom;
        this.auxiliarSpace = auxiliarSpace;
        YourBusiness.spaceOccupied += this.rooms*spacePerRoom + this.auxiliarSpace;
    }
    
    public static Cinema getInstance(String name, double pricePerSquare,int rooms, double spacePerRoom, double auxiliarSpace){
        if( c == null){
            c = new Cinema(name, pricePerSquare,rooms,spacePerRoom,auxiliarSpace);
        }
        return c;
    }
    
    @Override
    public double totalPrice(){
        return (rooms*spacePerRoom + auxiliarSpace)*pricePerSquare;
    }
    
    @Override
    public double totalSpace(){
        return this.rooms*spacePerRoom + auxiliarSpace;
    }
    
    @Override
    public String toString(){
        return "Cinema: " + this.name + " Type: " + this.type + " Space: " + totalSpace() + " Price: " + totalPrice();
    }
}