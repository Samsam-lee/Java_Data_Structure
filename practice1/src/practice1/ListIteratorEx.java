//package practice1;
//
//import java.util.ArrayList;
//import java.util.ListIterator;
//
//public class ListIteratorEx {
//	public static void main(String[] args) {
//		ArrayList myList = new ArrayList();
//		
//		myList.add(1);
//		myList.add(2);
//		myList.add(3);
//		myList.add(4);
//		myList.add(5);
//		
//		// ArrayList -> ListIterator (주소 값)
//		ListIterator myIterator = myList.listIterator();
//		
//		// 정방향 순회
//		while(myIterator.hasNext()) {
//			System.out.println(myIterator.next());
//		}
//		
//		// 역방향 순회
//		while(myIterator.hasPrevious())
//			System.out.println(myIterator.previous());
//	}
//}
//
