public class NoSuchFloorsException extends RuntimeException{
    
    public NoSuchFloorsException(){
        super("A shop should have space only on the same floor or in the next floor!");
    }
}