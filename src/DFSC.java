import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;


public class DFSC {
	class Node {
		int data;
		boolean marked;
		LinkedList<Node> adj;
		Node(int data){
			this.data = data;
			this.marked = false;
			adj = new LinkedList<DFSC.Node>();
		}
	}
	static Node[] nodes;
	public DFSC(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adj.contains(n2)) {
			n1.adj.add(n2);
		}
		if(!n2.adj.contains(n1)) {
			n2.adj.add(n1);
		}
	}
	
	static void dfs() {
		dfs(0);
	}
	
	static void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		int idx = 0;
		int sum = 0;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			System.out.printf("부모 노드 : %d\r\n", r.data);
			for(Node n : r.adj) {
				if(n.marked == false) {
					System.out.printf("자식 노드 : %d\r\n", n.data);
					n.marked = true;
					stack.push(n);
					idx++;
				}
				else {
//					System.out.printf("idx : %d\r\n", idx);
//					System.out.println("push를 안함");
				}
			}
			
			visit(r);
		}
	}
	
	static void visit(Node r) {
		System.out.println(r.data + " ");
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int[] numbers2 = {4, 1, 2, 1};
		int target = 3;
		DFSC g = new DFSC((int)Math.pow(2, numbers.length)-1);
		g.addEdge(1, 2);
		g.addEdge(1, 7);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(7, 8);
		g.addEdge(7, 9);
		dfs(1);
	}

}

