public class Restaurant extends YourBusiness{
    
    double space;
    int michelin;
    public static int restaurants;

    
    public Restaurant(String name, double pricePerSquare,String type,  double space, int michelin){
        super(name, pricePerSquare,type);
        
         if(restaurants > 3 ){
            throw new TooMannyException();
        }
        
        if(space > 1000){
            throw new TooMuchSpaceException();
        }
        this.space = space;
        this.michelin = michelin;
        spaceOccupied += space;
       
        restaurants ++;
    }
    
    @Override
    public double totalPrice(){
        if(michelin == 0){
            return pricePerSquare*space*0.8;
        }else{
            if(michelin == 1){
                return pricePerSquare*space;
            }else{
                return pricePerSquare*space*1.2;
            }
        }
    }
    
    @Override
    public double totalSpace(){
        return this.space;
    }
    
    @Override
    public String toString(){
        return "Restaurant: " + this.name + " Type: " + this.type + " Space: " + this.space + " Price: " + totalPrice();
    }
    
}