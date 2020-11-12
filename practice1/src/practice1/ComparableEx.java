//package practice1;
//
//import java.util.ArrayList;
//
//class Student implements Comparable<Student>{
//	int id;
//	String name;
//	
//	Student(int argId, String argName){
//		id = argId;													// id 초기화
//		name = argName;									// name 초기화
//	}
//	
//	public int compareTo(Student o) {
//		// 비교 대상의 id가 같으면 0 리턴
//		if(id == o.id)
//			return 0;
//		
//		// 비교 대상의 id가 작으면 1, 크면 -1 리턴
//		return (id > ((Student)o).id) ? 1 : -1;
//	}
//	
//	@Override
//	// 출력
//	public String toString() {
//		return id + " : " + name;
//	}
//}
//
//public class ComparableEx {
//	public static void main(String[] args) {
//		
//		// ArrayList 선언
//		ArrayList<Student> myList = new ArrayList<Student>();
//		
//		myList.add(new Student(1, "정영철"));		// id : 1, name : 정영철 인 학생 객체 추가
//		myList.add(new Student(10, "이승엽"));		// id : 10, name : 이승엽 인 학생 객체 추가
//		myList.add(new Student(5, "김상수"));		// id : 5, name : 김상수 인 학생 객체 추가
//		myList.add(new Student(8, "원태인"));		// id : 8, name : 원태인 인 학생 객체 추가
//		
//		System.out.println(myList);							// [1: 정영철, 10 : 이승엽, 5 : 김상수, 8 : 원태인]
//		
//		myList.sort(null);											// 배열을 정렬
//		
//		System.out.println(myList);							// [1 : 정영철, 5 : 김상수, 8 : 원태인, 10 : 이승엽]
//		
//	}
//}
//
