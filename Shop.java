public class Shop extends YourBusiness{
    
    int [] floor;
    double spacePerFloor;
    
    private void floorsException(int [] floor){
        if(floor.length > 2 ){
            throw new TooMannyException();
        }else{
            if(floor[0] == 0 && floor[1] == 2){
                throw new NoSuchFloorsException();
            }else{
                if(floor.length > 1 ){
                    if(floor[0] > floor[1]){
                        throw new NoSuchSequenceException();
                    }
                }
            }
        }
    }
    
    public Shop(String name, double pricePerSquare, String type, int [] floor, double spacePerFloor){
        super(name, pricePerSquare, type);
        this.spacePerFloor = spacePerFloor;
        this.floorsException(floor);
        this.floor = new int[floor.length];
        for( int i = 0;  i < floor.length; i++){
            this.floor[i] = floor[i];
        }
        spaceOccupied += this.floor.length*this.spacePerFloor;
    }
    
    @Override
    public double totalPrice(){
        if(floor.length == 1 ){
            return pricePerSquare*spacePerFloor*0.9;
        }else{
            if(floor[0] == 1 && floor[1] == 2 ){
                 return pricePerSquare*spacePerFloor*0.8*2;
            }else{
                if(floor[0] == 0 && floor[1] == 1){
                    return pricePerSquare*spacePerFloor*2;
                }else{
                    return pricePerSquare*spacePerFloor*2*1.1;
                }
            }
        }   
    }
    
    @Override
    public double totalSpace(){
        return this.floor.length*spacePerFloor;
    }
    
    @Override
    public String toString(){
        return "Shop: " + this.name + " Type: " + this.type + " Space: " + totalSpace() + " Price: " + totalPrice();
    }
}         


