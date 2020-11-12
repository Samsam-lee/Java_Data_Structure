//package practice1;
//
//import java.util.ArrayList;
//
//class StdInfo{
//	private int 		id;
//	private String 	name;
//	
//	StdInfo(int argId, String argName){
//		id 		= argId;
//		name 	= argName;
//	}
//	
//	int getStdId() 				{return id;}				// id 반환
//	String getStdName() {return name;}		// name 반환
//	
//	public String toString() {
//		String msg = id + ":" + name;
//		return msg;
//	}
//}
//
//public class ArrayListEx {
//	public static void main(String[] args) {
//		// ArrayList 객체 생성
//		ArrayList<StdInfo> stdStack = new ArrayList<StdInfo>();
//		
//		// <-- add함수로 stdStack 에 값 추가
//		stdStack.add(new StdInfo(1, "박한이"));
//		stdStack.add(new StdInfo(2, "원태인"));
//		stdStack.add(new StdInfo(3, "김윤동"));
//		System.out.println(stdStack);
//		// -->
//		
//		// <-- 0번 째 인덱스의 값 가져오기
//		System.out.println(stdStack.get(0));
//		System.out.println(stdStack);
//		//-->
//		
//		// <-- ArrayList 의 값 제거
//		System.out.println(stdStack.remove(stdStack.size() - 1 ));
//		System.out.println(stdStack.remove(stdStack.size()-1));
//		System.out.println(stdStack);
//		System.out.println(stdStack.size());
//		// -->
//		
//		// <-- add 함수로 stdStack 에 값 추가
//		stdStack.add(new StdInfo(4, "최지광"));
//		System.out.println(stdStack);
//		// -->
//		
//	}
//}
