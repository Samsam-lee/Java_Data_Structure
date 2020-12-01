package tree;

import java.util.LinkedList;

// 이진 트리 노드 클래스
class Node{
	int value;				// 노드 값
	Node left;				// 왼쪽 자식 노드
	Node right;			// 오른쪽 자식 노드
	
	Node(int value){
		this.value = value;
		right = null;
		left = null;
	}
}

// 이진 트리
class BSTree{
	Node root;
	
	// BTS 노드 추가
	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	// <-- BTS 노드 추가 - Recursive function
	private Node addRecursive(Node current, int value) {
		// 추가하고자 하는 노드가 비었을 경우 노드 추가
		if(current == null) {
			return new Node(value);
		}
		
		// 입력 값이 현재 값보다 작을 경우 왼쪽 자식 노드에 추가
		if(value < current.value) {
			current.left = addRecursive(current.left, value);
		}
		// 입력 값이 현재 값보다 클 경우 오른쪽 자식 노드에 추가
		else if(value > current.value) {
			current.right = addRecursive(current.right, value);
		}
//		// 값이 존재할 경우
//		else {
//			return current;
//		}
		return current;
	}
	// -->
	
	// <-- Tree 내 특정 값 존재 유무 검사
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	// Tree 내 특정 값 존재 유무 검사 - Recursive function
	private boolean containsNodeRecursive(Node current, int value) {
		// Leaf node 까지 도달 -> 즉 찾는 값 없음
		if(current == null) {
			return false;
		}
		
		// 검색 값 존재
		if(value == current.value) {
			return true;
		}
		
		// 검색 값이 현 노드에 없을 경우
		// 검색 값이 현 노드 값 보다 작을 경우 왼쪽 자식 노드 순회
		// 검색 값이 현 노드 값 보다 클 경우 오른쪽 자식 노드 순회
		return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
	}
	// -->
	
	
//------------------------------------------------------------------
// <--
// 전위 순회
	public void traversePreOrder(Node node) {
		if(node != null) {
			System.out.println(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
// 중위 순회
	public void traverseInOrder(Node node) {
		if(node != null) {
			traverseInOrder(node.left);
			System.out.println(" " + node.value);
			traverseInOrder(node.right);
		}
	}
	
// 후위 순회
	public void traversePostOrder(Node node) {
		if(node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.println(" " + node.value);
		}
	}
// -->
	
//------------------------------------------------------------------
// <-- 깊이 우선 탐색 ( Breadth-First traversal )
	public void traverseLevelOrder() {
		if(root == null) { return;}
		
		// 깊이 탐색 시 노드 값을 저장할 Queue
		LinkedList<Node> nodes = new LinkedList<Node>();
		
		nodes.add(root);
		
		// 노드 값이 없을 때 까지 반복
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			
			System.out.println(" " + node.value);
			
			if(node.left != null) {
				nodes.add(node.left);
			}
			
			if(node.right != null) {
				nodes.add(node.right);
			}
		}
	}
// -->
//------------------------------------------------------------------
	
// <-- binary tree delete
	private Node deleteRecursive(Node current, int value) {
		// 찾는 값이 없을 경우
		if(current == null)
			return null;
		
		// 찾는 값이 있을 경우
		if(value == current.value) {
			// case 1: 삭제 노드가 leaf node 일 경우
			if(current.left == null && current.right == null)
				return null;
			// case 2: 삭제 노드의 자식 노드가 한 개일 경우
			if(current.right == null)
				return current.left;
			
			if(current.left == null)
				return current.right;
			// case 3: 삭제 노드의 자식 노드가 두 개일 경우
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		
		// 왼쪽 노드 순회
		if(value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		
		// 오른쪽 노드 순회
		current.right = deleteRecursive(current.right, value);
		return current;
	}
	
	// sub tree 내 최소값
	private int findSmallestValue(Node root) {
		return root.left==null ? root.value : findSmallestValue(root.left);
	}
	
	// binary tree 삭제 함수
	public void delete(int value) {
		root = deleteRecursive(root,value);
	}
// -->
	
}

public class binaryTreeSearch {
	public static void main(String[] args) {
		BSTree bt = new BSTree();
		
		bt.add(6);																
		bt.add(4);																
		bt.add(8);																
		bt.add(3);																
		bt.add(5);																
		bt.add(7);																
		bt.add(9);									
		
		
		// 이진 트리 삭제 구현
		bt.traverseLevelOrder();
		System.out.println("------------");
		bt.delete(4);
		bt.traverseLevelOrder();
		System.out.println("------------");
		bt.delete(6);
		bt.traverseLevelOrder();
		System.out.println("------------");
		bt.delete(7);
		bt.traverseLevelOrder();
		
		
		// 넓이 우선 탐색
//		bt.traverseLevelOrder();
		
		
		// 순회
//		bt.traversePreOrder(bt.root);
//		System.out.println("--------------");
//		bt.traverseInOrder(bt.root);
//		System.out.println("--------------");
//		bt.traversePostOrder(bt.root);
		
		
//		System.out.println(bt.containsNode(8));		// true
//		System.out.println(bt.containsNode(10));	// false
	}
}
