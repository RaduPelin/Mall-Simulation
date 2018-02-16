public class TooMuchSpaceException extends RuntimeException{
    
    public TooMuchSpaceException(){
        super("This business can't occupy so much space in my mall!");
    }
}