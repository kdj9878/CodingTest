import java.util.LinkedList;

public class BFSC {
	static class Node{
		int index;
		int data;
		boolean marked;
		LinkedList<Node> adj;
		Node(int index, int data){
			this.index = index; 
			this.data = data;
			this.marked = false;
			adj = new LinkedList<Node>();	// 간선의 정보를 담는 LinkedList<>
		}
	}
	
	static Node[] nodes;	// 정점인 Node들의 정보를 담을 배열
	static int count;
	// 데이터를 담아둘 List
	BFSC(int size, int[] array) {
		nodes = new Node[size];
		count = 0;
		int idx = 0;
		int c = 1;
		for (int i = 0; i < size;) {
			if(i == 0) {
				nodes[i] = new Node(i, 0);
				i++;
			}
			else {
				for(int j = 0; j < c; j++, i++) {
					nodes[i] = new Node(i, array[idx]);
					i++;
					nodes[i] = new Node(i, -array[idx]);
				}
				idx++;
				c *= 2;	// 계층이 증가할 때마다 정점의 개수가 2배가 되기때문에
			}
		}
	}

	static void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adj.contains(n2)) {
			n1.adj.add(n2);
		}
		if(!n2.adj.contains(n1)) {
			n2.adj.add(n1);
		}
	}

	 /* BFS */
	static void BFS(int s) {
		Node root = nodes[s];
		// 연결리스트 생성
		LinkedList<Node> queue = new LinkedList<>();
		// 최초 노드를 방문한 것으로 표시
		root.marked = true;
		queue.add(root);
		Node tn;
		while (queue.size() != 0) {
			// 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
			tn = queue.poll();
			for(Node n : tn.adj) {
				// 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
				if (!n.marked) {
					n.marked = true;
					System.out.printf("더할 데이터 값 : %d\r\n", n.data);
					queue.add(n);
				}
			}
			System.out.println("------------------");
		}
	}
	
	/* DFS */
//	static void DFS(int index, int size, int target) {
//		Node root = nodes[index];
//		Stack<Node> stack = new Stack<Node>();
//		stack.push(root);
//		root.marked = true;
//		while (!stack.isEmpty()) {
//			Node r = stack.pop();
//			for(Node n : r.adj) {
//				if(n.marked == false) {
//					n.marked = true;
//					stack.push(n);
//				}
//			}
//			visit(r, stack, size, target);
//		}
//	}
	
	static void DFSR(int index, int size) {
		Node r = nodes[index];
		DFSR(r, size);
	}
	
	static void DFSR(Node r, int size) {
		if(r == null) return;
		r.marked = true;
		visit(r, size);
		for(Node n : r.adj) {
			if(n.marked == false) {
				DFSR(n, size);
			}
		}
	}
	
	static void visit(Node r, int size) {
		System.out.printf("count : %d\r\n", count);
		count++;
		if(count == size) {
			System.out.println(r.data + "--");

		}
		else {
			System.out.println(r.data + " ");
		}
			
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int[] numbers2 = {4, 1, 2, 1};
		int target = 4;
		int size = (int)Math.pow(2, numbers2.length+1)-1;	// 정점의 모든 개수
		int edgeSize = (int)Math.pow(2, numbers2.length)-1;	// 자식노드를 가진 정점의 개수
		BFSC g = new BFSC(size, numbers2);
		
		int resetCount = 0;
		// 정점의 인덱스
		// g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(1, 3);
		// g.addEdge(1, 4);
		// g.addEdge(2, 5);
		// g.addEdge(2, 6);
		for(int i = 1; i < size;) {
			for(int j = 0; j < edgeSize;) {
				g.addEdge(j, i);
				i++;
				resetCount++;
				if(resetCount != 2) {
					continue;
				}
				j++;
				resetCount = 0;
			}
		}
		
		BFS(0);
//		DFSR(0, numbers2.length+1);
		System.out.println("===============");
	}
}
