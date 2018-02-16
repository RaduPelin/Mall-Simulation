public class TooSmallException extends RuntimeException{
    public TooSmallException(){
        super("The space for the room is too small!");
    }
}