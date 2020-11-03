package java_test;

import java.util.Scanner;

class RawData {
	String m_stdId[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						"11", "12", "13", "14", "15", "16", "17", "18"};
	
	String m_stdName[] = { "박나래",	"이정재",	"정우성",	"김국진", "하춘하", "강호동",
			               "이수근",	"피오",	"공유",	"곽도원", "고은아", "규현",	
			               "전지현", "채연", "김청", "김수지", "전영록", "구창모"};
	
	double m_stdGrade[] = {15, 12, 11, 10, 9, 8, 7, 7, 7, 6, 6, 6, 6, 6, 5, 5, 4, 3};
	
	String m_stdGender[] = {"여", "남", "남", "남", "여", "남", "남", "남", "남",
							"남", "여", "남", "여", "여", "여", "여", "남", "남"};									
}


// 학생 정보 저장 클래스 (StdInfo 객체 한 개가 한 명 학생 나타냄)
class StdInfo {
	// 한 명 학생의 학번, 이름, 점수, 성별 저장
	private String stdId;
	private String stdName;
	private double stdGrade;
	private String stdGender;
	
	// 학생 객체 호출 시 초기화
	StdInfo(String argId, String argName, double argGrade, String argGender){
		stdId = argId;
		stdName = argName;
		stdGrade = argGrade;
		stdGender = argGender;
	}
	
	// 학생 학번 Get, Set
	String getId() {return stdId;}
	void setId(String argId) {stdId = argId;}
	// 학생 이름 Get, Set
	String getName() {return stdName;}
	void setName(String argName) {stdName = argName;}
	// 학생 점수 Get, Set
	double getGrade() {return stdGrade;}
	void setGrade(double argGrade) {stdGrade = argGrade;}
	// 학생 성별 Get, Set
	String getGender() {return stdGender;}
	void setGender(String argGender) {stdGender = argGender;}
}

class Node{
	private StdInfo stdInfo;
	private Node nextNode;
	
	// Node 생성할 때stdInfo, nextNode 초기화 작업
	Node(StdInfo argInfo, Node argNode){
		stdInfo = argInfo;
		nextNode = argNode;
	}
	
	// stdInfo 의 Get, Set
	StdInfo getStdInfo() { return stdInfo; }
	void setStdInfo(StdInfo argInfo) { stdInfo = argInfo; }
	
	// nextNode 의 Get, Set
	Node getNextNode() { return nextNode; }
	void setNextNode(Node argNode) { nextNode = argNode; }
}


// Linked-List Version 리스트 
class MyList {
	Node headNode;
	Node tailNode;
	int totalNum = 0;		// 학생 전체 수
	
	// Linked-List 를 생성할 때 headNode 와 tailNode 를 초기화
	MyList(){
		tailNode = new Node(null, null);
		headNode = new Node(null, tailNode);
	}
	
	//  List 내 argID 입력 값과 매칭되는 학생 객체(StdInfo) 반환
	//  매칭되는 학생이 없을 경우 Null 반환
	StdInfo getStdById(String argId) {
		Node tempNode = headNode;
		// tailNode 전 까지 반복
		while(tempNode.getNextNode() != tailNode) {
			// argId 와 학생 id를 비교
			if(tempNode.getNextNode().getStdInfo().getId() == argId) {
				return tempNode.getNextNode().getStdInfo();
			}
			tempNode = tempNode.getNextNode();
		}
		return null;
	}

	// List 내 argIndex 순서에 해당하는 StdInfo 객체 반환
	//  index 값 유효성 검사 실시 [입력 값이 -1 이하 이거나, List 내 저장 데이터 값보다 클경우]
	StdInfo get(int argIndex) {
		// 인덱스 값 유효성 검사
		if(isExistIndex(argIndex)) {
			Node tempNode = headNode;
			// headNode에서 입력받은 index 까지 이동
			for(int i = 0 ; i < argIndex ; i++) {
				tempNode = tempNode.getNextNode();
			}
			return tempNode.getNextNode().getStdInfo();
		}
		return null;
	}

	// List 내 argIndex 순서에 해당하는 StdInfo 객체를 List 내 삭제 후 해당 객체 반환
	// index 값 유효성 검사 실시 [입력 값이 -1 이하 이거나, List 내 저장 데이터 값보다 클경우]
	StdInfo remove(int argIndex) {
		// 인덱스 값 유효성 검사
		if(isExistIndex(argIndex)) {
			Node tempNode = headNode.getNextNode();
			Node prevNode = headNode;
			// tempNode를 index 까지 이동하는데
			// prevNode는 그 전 index 까지 이동을 하여서 삭제할 때 사용합니다.
			// prevNode와 tempNode의 결합을 끊고 prevNode와 tempNode의 다음 노드와 결합
			for(int i = 0 ; i < argIndex ; i++) {
				prevNode = tempNode;
				tempNode = tempNode.getNextNode();
			}
			prevNode.setNextNode(tempNode.getNextNode());
			// 학생 수 1 감소
			totalNum--;
			return tempNode.getStdInfo();
		}
		return null;
	}
	
	// List 제일 마지막에 argStdInfo 객체 삽입
	void add(StdInfo argStdInfo) {
		Node tempNode = headNode;
		// tailNode 전 까지 이동하고
		// tempNode 의 다음 노드에 argStdInfo를 가지는 노드 삽입
		while(tempNode.getNextNode() != tailNode) {
			tempNode = tempNode.getNextNode();
		}
		tempNode.setNextNode(new Node(argStdInfo, tailNode));
		// 학생 수 1 증가
		totalNum++;
	}
	
	// 현 리스트 내 데이터 개수 반환
	int size() {
		return totalNum;
	}
	
	//  현 리스트 내 여학생 명수 반환
	int sizeOfFemaleStd() {
		int femaleNum = 0;		// 여학생 수
		Node tempNode = headNode;
		// tailNode 전 까지 이동하면서 학생객체에서 Gender를 꺼내와 "여" 라는 값과 비교 후 동일하면 femaleNum 증가
		while(tempNode.getNextNode() != tailNode) {
			if(tempNode.getNextNode().getStdInfo().getGender() == "여") {
				femaleNum++;
			}
			tempNode = tempNode.getNextNode();
		}
		return femaleNum;
	}
	
	// 현 리스트 내 남학생 명수 반환
	int sizeOfMaleStd() {
		int maleNum = 0;	// 남학생 수
		Node tempNode = headNode;
		// tailNode 전 까지 이동하면서 학생객체에서 Gender를 꺼내와 "남" 이라는 값과 비교 후 동일하면 maleNum 증가
		while(tempNode.getNextNode() != tailNode) {
			if(tempNode.getNextNode().getStdInfo().getGender() == "남") {
				maleNum++;
			}
			tempNode = tempNode.getNextNode();
		}
		return maleNum;
	}
	
	// index 값 유효성 검사
	boolean isExistIndex(int argIndex) {
		if(argIndex < 0 || argIndex > size()) {
			return false;
		}
		return true;
	}
	
}


// 조 편성 클래스
class GroupManager {
	int studentNum = 18;
	int		m_numOfGroup;   // 생성할 그룹 수 : 사용자(CLI)로부터 입력
	MyList	rawDataList; 	// 학생 정보 객체(StdInfo)들을 저장하는 리스트
	// 멤버변수, 멤버메서드 추가 가능 : 예) 여학생 객체 저장 MyList 추가
	
	MyList femaleDataList;			// 여학생 객체
	MyList maleDataList;				// 남학생 객체
	
	StdInfo[] femaleStdInfo;
	StdInfo[] maleStdInfo; 
	
	int femaleStdNum = 0;			// 여학생 수
	int maleStdNum;						// 남학생 수
	
	MyList[] randomGroup;			// 그룹
	
	// 생성자
	GroupManager() {
		// rawDataList 리스트에 학생(StdInfo)객체 입력
		LoadData();
	}
	
	// 학생 정보 객체화 후 리스트에 저장
	void LoadData() {
		// RawData 클래스 멤버 변수의 자료들을
		// 각 StdInfo 객체로 생성 후 rawDataList 리스트에 추가 
			RawData data = new RawData();
			StdInfo[] studentInfo = new StdInfo[studentNum];
			
			// 여학생 수 카운트
			for(int i = 0 ; i < studentNum ; i++) {
				if(data.m_stdGender[i] == "여") {
					femaleStdNum += 1;
				}
			}
			// 남학생 수
			maleStdNum = studentNum - femaleStdNum;
			
			femaleStdInfo = new StdInfo[femaleStdNum];
			maleStdInfo = new StdInfo[maleStdNum];
			int tempMaleNum = 0;
			int tempFemaleNum = 0;
			
			// 학생 객체에 RawData 값 대입 시켜 학생 객체들을 만든다.
			for(int i = 0 ; i < studentNum ; i++) {
				studentInfo[i] = new StdInfo(data.m_stdId[i], data.m_stdName[i], data.m_stdGrade[i], data.m_stdGender[i]);
				if(data.m_stdGender[i] == "남") {
					// 남학생 객체 
					maleStdInfo[tempMaleNum] = new StdInfo(data.m_stdId[i], data.m_stdName[i], data.m_stdGrade[i], data.m_stdGender[i]);
					tempMaleNum++;
				} else {
					// 여학생 객체 
					femaleStdInfo[tempFemaleNum] = new StdInfo(data.m_stdId[i], data.m_stdName[i], data.m_stdGrade[i], data.m_stdGender[i]);
					tempFemaleNum++;
				}
			}
			
			tempMaleNum = 0;
			tempFemaleNum = 0;
			
			rawDataList = new MyList();				// 전체 학생 LinkedList
			
			maleDataList = new MyList();			// 남학생 LinkedList
			femaleDataList = new MyList();		// 여학생 LinkedList
			
			for(int i = 0 ; i < studentNum ; i++) {
				// LinkedList 로 학생 객체들을 이어 붙인다.
				rawDataList.add(studentInfo[i]);
				
				if(data.m_stdGender[i] == "남") {
					maleDataList.add(maleStdInfo[tempMaleNum]);
					tempMaleNum++;
				} else {
					femaleDataList.add(femaleStdInfo[tempFemaleNum]);
					tempFemaleNum++;
				}
			}
			
			
		//--------------------------------------------------------------- 결과 값 ----------------------------------------------------------------------------------------
		// 리스트 rawDataList에 입력 된 학생 정보 화면에 출력
//		PrtStdList(studentInfo);
//		
//		// 입력한 학번과 동일한 학생의 객체 반환
//		// getStdById()      <- 괄호  안의 값을 변경하면 객체 바꿔 올 수 있음
//		System.out.printf("입력한 학번과 동일한 학생의 학번 : %s, 이름 : %s\n",rawDataList.getStdById("1").getId(), rawDataList.getStdById("1").getName());
//		// 입력한 index에 해당하는 학생 객체 반환
//		System.out.printf("입력한 index에 해당하는 학생의 학번 : %s, 이름 : %s\n", rawDataList.get(0).getId(),  rawDataList.get(0).getName());
//		// 입력한 index에 해당하는 학생 객체 삭제하고 반환
//		System.out.printf("입력한 index에 해당하는 학생의 이름 : %s\n", rawDataList.remove(1).getName() );
//		// 여학생 수
//		System.out.printf("전체 여학생 수 : %d\n", rawDataList.sizeOfFemaleStd());
//		// 남학생 수
//		// 위에서 remove 함수를 한 번 사용해서 남학생 수가 1 줄어듬
//		System.out.printf("전체 남학생 수 : %d\n", rawDataList.sizeOfMaleStd());
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------
			
			for(int i = 0 ; i < tempMaleNum ; i++) {
				System.out.printf("%d) %s, %s, %s ", i+1, maleStdInfo[i].getName(), maleStdInfo[i].getId(), maleStdInfo[i].getGender());
				System.out.println(maleStdInfo[i].getGrade() + "\n");
			}
			for(int i = 0 ; i < tempFemaleNum ; i++) {
				System.out.printf("%d) %s, %s, %s ", i+1, femaleStdInfo[i].getName(), femaleStdInfo[i].getId(), femaleStdInfo[i].getGender());
				System.out.println(femaleStdInfo[i].getGrade() + "\n");
			}
			
			System.out.println("--------------------------------------");
			
			
	}
	
	
	// rawDataList 내 학생 정보(StdInfo 객체)를 화면에 출력
	void PrtStdList(StdInfo[] argInfo) {
		// 화면 출력 포맷 : 이름, 학번, 성별, 점수 순으로 출력 (아래 참조)
		// 1) 박나래, 1, "여", 10
		// 2) 이정재, 2, "남", 10
		
		for(int i = 0 ; i < studentNum ; i++) {
			System.out.printf("%d) %s, %s, %s ", i+1, argInfo[i].getName(), argInfo[i].getId(), argInfo[i].getGender());
			System.out.println(argInfo[i].getGrade() + "\n");
		}
	}
	
	// 랜덤으로 그룹을 생성하여 화면에 출력
	void GenerateGroup() {
		// 생성 그룹 개수  사용자로부터 입력
		Scanner scan = new Scanner(System.in);
		System.out.printf("생성할 그룹의 수를 입력하여 주세요 : ");
		int groupNum = scan.nextInt();
		System.out.printf("입력한 그룹의 수 : %d\n", groupNum);
		
		int randomValue = (int)(Math.random()*groupNum);
		System.out.println("랜덤 밸류 : " + randomValue);
		
//		randomGroup = new MyList[groupNum];				// 사용자가 입력한 그룹 수 만큼 그룹 생성
//		
//		for(int i = 0 ; i < groupNum ; i++) {
//			randomGroup[i].add(femaleStdInfo[0]);
//		}
		

		// 아래 규칙을 적용하여 그룹 생성
		// 1) 남학생 중 성적 순으로 각 그룹에 랜덤하게 배정 :    
		//    예) 생성 그룹 : 3, 성적순으로 1~3위의 학생들을 랜덤하게 1, 2, 3조에 편성
		//    Math.Random() 메서드 이용 : 0~2 랜덤 값 생성 : (int)(Math.Random() * 3)
		// 2) 모든 남학생이 배정 될때까지 1) 반복
		// 3) 남학생 숫자가 생성 그룹 수와 맞아 떨어지지 않을 경우, 남은 학생들은 각 조별 총점이 낮은 순으로 배정
		//    예) 총 학생 수 : 9명, 생성 그룹 : 2, 8명까지 배정 후 조별 점수 총합 -> 1조 총점 : 80점, 2조 총점 : 90점
		//       -> 1조 학생들의 총 점수가 낮음으로 나머지 1명을  1조에 배정
		// 4) 여학생의 경우 1조부터 차례대로 Round Robin 방식으로 배정
        //    예) 생성 그룹 3, 여학생 수 5명 : 1, 2, 3, 1, 2조 순으로 배정
		
		
		// 조편성 결과 화면 출력
		// 출력 포맷은 시험지 참조
	}
}



public class GGenerator {
	public static void main(String args[]) {
		GroupManager myGrpMgr = new GroupManager();
		// 조 편성 프로그램 실행
		myGrpMgr.GenerateGroup();	
		
	}
}
