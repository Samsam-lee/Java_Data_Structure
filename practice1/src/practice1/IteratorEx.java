//package practice1;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//public class IteratorEx {
//	public static void main(String[] args) {
//		Set mySet = new HashSet();
//		
//		mySet.add(1);
//		mySet.add(2);
//		mySet.add(3);
//		mySet.add(4);
//		mySet.add(5);
//		
//		// HashSet의 원소 -> Iterator (주소 값)
//		Iterator myList = mySet.iterator();
//		
//		// Iterator 내 원소가 있는지 검사
//		while(myList.hasNext()) {
//			System.out.println(myList.next());		// 원소 값 반환 후 다음 원소로 이동
//			myList.remove();										// 원소 삭제
//		}
//		
//		// iterator 에서 삭제해도 주소 값으로 준 값이기 때문에 원래의 값도 삭제
//		System.out.println(mySet);						// []
//	}
//}
//
