package circularQueue;

class myQueue{
	final int NUM_LENGTH;
	int startIndex = 0;
	int endIndex = 0;
	int num;
	int[] circularQ;
	
	myQueue(int argNum){
		NUM_LENGTH = argNum;
		circularQ = new int[NUM_LENGTH];
	}
	
	// 배열에 추가
	void enqueue(int argValue) {
		if(num == NUM_LENGTH) {
			System.out.println("배열 초과");
		} else {
			circularQ[endIndex] = argValue;
			endIndex = (endIndex+1) % NUM_LENGTH;
			num++;
		}
	}
	
	// 삭제
	int dequeue() {
		if(num == 0) {
			return Integer.MAX_VALUE;
		}
		
		int tempValue = circularQ[startIndex];
		startIndex = (startIndex+1) % NUM_LENGTH;
		num--;
		return tempValue;
	}
	
	// size 반환
	int getSize() {
		return num;
	}
	
	
	public String toString() {
		String msg = "Start Index : " + startIndex + "\tEnd Index : " + endIndex + "\tData size : " + num + "\n";
		
		msg += "Values in the queue : ";
		
		for(int i = 0 ; i < num ; i++) {
			msg += circularQ[(startIndex + i) % NUM_LENGTH] + " ";
		}
		
		msg += "\nValues in the array : ";
		for(int i = 0 ; i < NUM_LENGTH ; i++) {
			msg += circularQ[i] + " ";
		}
		
		return msg;
	}
}

public class circularQueue {
	public static void main(String[] args) {
		myQueue myQ = new myQueue(5);
		
		myQ.enqueue(5);
		System.out.println(myQ);
		
		myQ.enqueue(6);
		System.out.println(myQ);
		
		myQ.enqueue(7);
		System.out.println(myQ);
		
		System.out.println("dequeue : " + myQ.dequeue());
		System.out.println(myQ);

		myQ.enqueue(8);
		System.out.println(myQ);
		
		System.out.println("dequeue : " + myQ.dequeue());
		System.out.println(myQ);
	}
}
