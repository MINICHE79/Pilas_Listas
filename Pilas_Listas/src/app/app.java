package app;

import Stack.Stack;

public class app {

	public static void main(String[] args) {
		Stack <String> names = new Stack<String>(5);
		try {
			
			names.puch("pepe");
			names.puch("Ric");
			names.puch("Juan");
			names.puch("Pedro");
			names.puch("lara");
			
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
			System.out.println(names.pop());
     		System.out.println(names.pop());
			
			names.puch("pepe");
			names.puch("Ric");
			names.puch("Juan");
			names.puch("Pedro");
			names.puch("lara");
			
//			System.out.println(names.size());
//			names.clear();
			
			
//			System.out.println(names.Search("pepe"));
			
			
			System.out.println("");
			System.out.println("Imprimiendo Pila");
			for(String string: names){
				System.out.println(string);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
