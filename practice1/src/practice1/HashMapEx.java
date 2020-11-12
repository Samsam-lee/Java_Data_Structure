package practice1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap myMap = new HashMap();
		
		myMap.put(7, "김상수" );
		myMap.put(36, "이승엽" );
		// index 값 동일하면 덮어씀
		myMap.put(21, "오승환" );
		myMap.put(21, "최지광" );
		
		// index : 7 삭제
		myMap.remove(7);
		System.out.println(myMap);			// {36 = 이승엽, 21 = 최지광}
		
		// index : 36 -> "정영철"로 덮어씀
		myMap.replace(36, "정영철");
		System.out.println(myMap);			// {36 = 정영철, 21 = 최지광}
		
		// Map -> Set
		Set mySet = myMap.entrySet();
		
		// Set -> Iterator
		Iterator myList = mySet.iterator();
		
		// 리스트 출력 하면서 삭제
		while(myList.hasNext()) {
			Map.Entry e = (Map.Entry)myList.next();
			System.out.println(e.getKey() + " : " + e.getValue());
			myList.remove();
		}
		
		System.out.println(myMap);			// { }
	}
}

