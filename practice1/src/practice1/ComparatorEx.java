//package practice1;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//
//class Student {
//	int id;
//	String name;
//	
//	Student(int argId, String argName){
//		id = argId;															// id 초기화
//		name = argName;											// name 초기화
//	}
//	
//	public String toString() {
//		return id + " : " + name;
//	}
//}
//
//public class ComparatorEx {
//	public static void main(String[] args) {
//		ArrayList<Student> myList = new ArrayList<Student>();
//		
//		myList.add(new Student(1, "정영철"));		// id : 1, name : 정영철 인 학생 객체 추가
//		myList.add(new Student(10, "이승엽"));		// id : 10, name : 이승엽 인 학생 객체 추가
//		myList.add(new Student(5, "김상수"));		// id : 5, name : 김상수 인 학생 객체 추가
//		myList.add(new Student(8, "원태인"));		// id : 8, name : 원태인 인 학생 객체 추가
//		
//		System.out.println(myList);							// [1: 정영철, 10 : 이승엽, 5 : 김상수, 8 : 원태인]
//		
//		
//		// Comparator interface 구현
//		// Collection sort() 메서드 호출 시 객체 비교 알고리즘 작성
//		myList.sort(new Comparator<Student>() {
//			public int compare(Student o1, Student o2) {
//				if(o1.id == o2.id)										// id 값이 같으면 0, 바꾸지 않음
//					return 0;
//				
//				return (o1.id > o2.id)? 1 : -1;				// 현 id 값이 비교 id 보다 크면 바꿈 
//			}
//		});
//		
//		System.out.println(myList);							// [1 : 정영철, 5 : 김상수, 8 : 원태인, 10 : 이승엽]
//	}
//}
//
