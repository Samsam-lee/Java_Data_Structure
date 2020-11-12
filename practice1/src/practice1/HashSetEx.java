//package practice1;
//
//import java.util.HashSet;
//
//class Student{
//	int id;
//	String name;
//	
//	Student(int argId, String argName){
//		id = argId;																// id 초기화
//		name = argName;												// name 초기화
//	}
//	
//	// <-- 객체를 Set 의 원소로 사용하려면 equals(), hashcode() 메소드 오버라이딩 필수
//	public boolean equals(Object obj) {
//		return this.id == ((Student)obj).id;					// 학생 id로 객체 비교
//	}
//	
//	public int hashCode() {
//		return Integer.valueOf(id).hashCode();			// id 값으로 해시코드 생성, 사용
//	}
//	// -->
//	
//	public String toString() {
//		return id + " " + name;
//	}
//}
//
//public class HashSetEx {
//	public static void main(String[] args) {
//		Student std1 = new Student(1, "YCJung");	// id : 1, name : YCJung
//		// 동일한 id 값은 적용 X
//		Student std2 = new Student(1, "TIWon");	// id : 1, name : TIWon
//		Student std3 = new Student(3, "CHChoi");	// id : 3, name : CHChoi
//		Student std4 = new Student(4, "SSKim");	// id : 4, name : SSKim
//		
//		HashSet myList = new HashSet();
//		
//		myList.add(std1);
//		myList.add(std2);
//		myList.add(std3);
//		myList.add(std4);
//		
//		System.out.println(myList);								// [1 YCJung, 3 CHChoi, 4 SSKim]
//	}
//}
//
