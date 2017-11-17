package Stack;

import java.util.Iterator;

import node.node;

public class Stack<T extends Comparable<T>> implements iStack<T>,Iterable<T> {
	
	private node<T> start = null, end = null;
	node<T> top;
	int count = 0;
	int size  = 10;
	
	
	public Stack(){
		start = new node<T>();
		start.setIndex(-1);
		end = new node<T>();
		end.setIndex(-1);
		node<T> n = new node<T>();
		start.setNext(n);
		node<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			node<T> nuevo = new node<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		top = start;
	}
	
	
	public Stack(int size){
		this.size = size;
		start = new node<T>();
		start.setIndex(-1);
		end = new node<T>();
		end.setIndex(-1);
		node<T> n = new node<T>();
		start.setNext(n);
		node<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			node<T> nuevo = new node<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		top = start;
	}
	
	public void index(){
		node<T> tmp = start;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			node<T> tmp = start;
			int i = 0;
			@Override
			public boolean hasNext() {
				tmp = tmp.getNext();
				return (i++ != count)?true:false;
			}
			@Override
			public T next() {
				return tmp.getValue();
			}
		};
	}
	

	@Override
	public T pop() throws StackEmptyException {
		if(IsEmpty()) throw new StackEmptyException("Pila vacía");
		T tmp;
		if(IsFull())	
			top=end;
		if(!IsEmpty())
			top=top.getBack();
		tmp = top.getValue();
		top.setValue(null);
		count--;
		return tmp;
		
	}

	@Override
	public void puch(T value) throws StackFullException {
		if(IsFull()) throw new StackFullException("Pila llena");
		if(top == start){
			top=top.getNext();
			top.setValue(value);
		}else{
			top.setValue(value);
		}
		count++;
		if(!IsFull())
			top=top.getNext();	
	}

	@Override
	public boolean IsEmpty() {
		return (count == 0);
	}

	@Override
	public boolean IsFull() {
		return (count == size);
	}

	@Override
	public T peek() throws StackEmptyException {
		if(IsEmpty()) throw new StackEmptyException("Pila vacía");
		if(IsFull())
			return top.getValue();
		return top.getBack().getValue();
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		node <T> tmp = start;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setValue(null);
		}
		top = start;
		count = 0;
	}

	@Override
	public node<T> Search(T value) throws StackEmptyException {
		if(IsEmpty()) throw new StackEmptyException("Pila vacía");	
		node<T> tmp = start.getNext();
		while (tmp.getValue() != null){
			if (tmp.getValue().equals(value))
				return tmp;
			tmp=tmp.getNext();
		}
		return null;
	}
}
