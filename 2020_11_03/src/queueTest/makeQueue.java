package queueTest;

class Node {
	int value;
	Node nextNode;
	
	Node(int argValue, Node argNextNode){
		value = argValue;
		nextNode = argNextNode;
	}
}

class MyQueue {
	Node headNode;
	Node tailNode;
	int num = 0;
	
	MyQueue(){
		tailNode = new Node(0, null);
		headNode = new Node(0, tailNode);
	}
	
	// 제일 끝에 값 추가
	void enqueue(int argValue) {
		Node tempNode = headNode;
		while(tempNode.nextNode != tailNode) {
			tempNode = tempNode.nextNode;
		}
		tempNode.nextNode = new Node(argValue, tailNode);
		num++;
	}
	
	// 제일 첫 값 제거 후 반환
	int dequeue() {
		if(isEmpty())
			return Integer.MAX_VALUE;
		
		Node tempNode = headNode.nextNode;
		headNode.nextNode = tempNode.nextNode;
		num--;
		return tempNode.value;
	}
	
	int getSize() {
		return num;
	}
	
	boolean isEmpty() {
		if(num == 0)
			return true;
		return false;
	}
	
	public String toString() {
		String msg = "";
		Node tempNode = headNode.nextNode;
		
		while(tempNode.nextNode != null) {
			msg += " " + tempNode.value;
			tempNode = tempNode.nextNode;
		}
		
		return msg;
	}
}

public class makeQueue {
	public static void main(String[] args) {
		MyQueue myQ = new MyQueue();
		myQ.enqueue(11);
		myQ.enqueue(22);
		myQ.enqueue(33);
		System.out.println(myQ);
		myQ.dequeue();
		System.out.println(myQ);
		myQ.enqueue(44);
		System.out.println(myQ);
	}
}
