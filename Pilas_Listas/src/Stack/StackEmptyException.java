package Stack;

public class StackEmptyException extends Exception {
	public StackEmptyException(){}
	public StackEmptyException(String Causa){
		super(Causa);
	}
	public StackEmptyException(Throwable Causa){
		super(Causa);
	}
}
