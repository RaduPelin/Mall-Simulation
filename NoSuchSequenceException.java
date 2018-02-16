public class NoSuchSequenceException extends RuntimeException{
    
    public NoSuchSequenceException(){
        super("A shop should have space only on the same floor or in the next floor!");
    }
}