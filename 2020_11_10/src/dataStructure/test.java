package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
	public static void main(String[] args) {

		ArrayList<Integer> myList1 = new ArrayList<Integer>();
		ArrayList<Integer> myList2 = new ArrayList<Integer>();
		
		myList1.add(1);															// [1]
		myList1.add(2);															// [1, 2]
		myList1.add(3);															// [1, 2, 3]
		myList1.add(5);															// [1, 2, 3, 5]

		System.out.println(myList1);									// [1, 2, 3, 5]
		System.out.println(myList1.get(2));						// 3
		System.out.println(myList1.indexOf(2));				// 1
		System.out.println(myList1.lastIndexOf(2));		// 1
		System.out.println(myList1.remove(3));				// 5
		System.out.println(myList1);									// [1, 2, 3]
		System.out.println(myList1.set(1, 30));				// 2
		System.out.println(myList1);									// [1, 30, 3]

		myList2.add(4);															// [4]
		myList2.add(5);															// [4, 5]
		System.out.println(myList2);									// [4, 5]
		
		myList1.addAll(myList2);											// [1, 30, 3, 4, 5]
		System.out.println(myList1);									// [1, 30, 3, 4, 5]
		
		List tempList = myList1.subList(0, 4);					// [1, 30, 3, 4]
		System.out.println(tempList);									// [1, 30, 3, 4]
		
		myList1.removeAll(myList2);									// [1, 30, 3]
		System.out.println(myList1);									// [1, 30, 3]
		
		myList1.clear();															// []
		System.out.println(myList1);									// []
		
		
//		myList1.add(2);
//		myList1.add(3);
//		myList1.add(4);
//		myList1.add(4);
//		myList1.add(4);
//		myList1.add(6);
//		
//		for(int i = 0 ; i < myList1.size() ; i++) {
//			if(myList1.get(i) == 4) {
//				myList1.remove(i);
//				i--;
//			}
//		}
//		
//		System.out.println(myList1);
		
		
		
//		Set mySet = new HashSet();
//		
//		while(mySet.size() < 6) {
//			mySet.add((int)(Math.random() * 45 + 1));
//		}
//		
//		System.out.println(mySet);
		
		
		
//		HashMap myMap = new HashMap();
//		
//		myMap.put(7,  "김상수");
//		myMap.put(36, "이승엽");
//		myMap.put(21,  "오승환");
//		myMap.put(21,  "최지광");
//		
//		System.out.println(myMap);
	}
}
