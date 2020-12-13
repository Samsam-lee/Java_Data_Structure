package stack;

class StackArray {
	private int numOfData;
	private int stackArray[];
	private final int ARRAY_SIZE;
	
	StackArray(int arraySize){
		ARRAY_SIZE = arraySize;
		stackArray = new int[ARRAY_SIZE];
	}
	
	boolean IsFull() {
		if(numOfData == ARRAY_SIZE)
			return true;
		return false;
	}
	
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		return false;
	}
	
	boolean push(int argNum) {
		if(IsFull()) 
			return false;
		
		stackArray[numOfData] = argNum;
		numOfData++;
		return true;
	}
	
	int pop() {
		if(IsEmpty())
			return Integer.MAX_VALUE;
		numOfData--;
		int temp = stackArray[numOfData];
		stackArray[numOfData] = 0;
		return temp;
	}
	
	public String toString() {
		String msg = "";
		for(int i = 0; i < stackArray.length; i++) {
			msg += " " + stackArray[i];
		}
		return msg;
	}
	
}

public class mainStack {
	public static void main(String[] args) {
		StackArray myStack = new StackArray(5);
		
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		myStack.push(10);
		System.out.println(myStack);
		
		System.out.println("--- POP : " + myStack.pop() + " ---");
		System.out.println(myStack);
		
		System.out.println("--- POP : " + myStack.pop() + " ---");
		System.out.println(myStack);
		
		System.out.println("--- POP : " + myStack.pop() + " ---");
		System.out.println(myStack);
		
		System.out.println("--- POP : " + myStack.pop() + " ---");
		System.out.println(myStack);
		
		System.out.println("--- POP : " + myStack.pop() + " ---");
		System.out.println(myStack);
		
		myStack.push(10);
		System.out.println(myStack);
	}
}
