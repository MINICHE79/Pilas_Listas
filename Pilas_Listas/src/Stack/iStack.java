package Stack;

import node.node;

public interface iStack<T> {
	public T       pop() throws StackEmptyException;
	public void    puch(T value) throws StackFullException;
	public boolean IsEmpty();
	public boolean IsFull();
	public T       peek() throws StackEmptyException;
	public int     size();
	public void    clear();
	public node<T>  Search(T value) throws StackEmptyException;
}
