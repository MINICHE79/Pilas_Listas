package Stack;

public class StackFullException extends Exception {
	public StackFullException(){}
	public StackFullException(String Causa){
		super(Causa);
	}
	public StackFullException(Throwable Causa){
		super(Causa);
	}

}
