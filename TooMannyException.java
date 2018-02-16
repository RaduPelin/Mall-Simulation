public class TooMannyException extends RuntimeException{
    
    public TooMannyException(){
        super("A shop can't function on more than two floors!");
    }
}