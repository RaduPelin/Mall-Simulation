public class FastFood extends YourBusiness{

    double space;
    double auxiliarSpace;
    
    public FastFood(String name, double pricePerSquare,String type, double space, double auxiliarSpace){
        super(name,pricePerSquare,type);
        if(space > 100){
            throw new TooMuchSpaceException();
        }
        this.space = space;
        this.auxiliarSpace = auxiliarSpace;
    }
    
    @Override
    public double totalPrice(){
        return (space + auxiliarSpace)*pricePerSquare;
    }
    
    @Override
    public double totalSpace(){
        return this.space + auxiliarSpace;
    }
    
    @Override
    public String toString(){
        return "FastFood: " + this.name + " Type: " + this.type + " Space: " + totalSpace() + " Price: " + totalPrice();
    }
}