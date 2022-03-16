import java.util.*;
import java.io.*;

public class BaeckDFS{
    static ArrayList<Integer> dfsList;
    static ArrayList<Integer> bfsList; // BFS 출력물이 저장되는 List
    
    // 노드의 정보가 담기는 클래스 정의
    public class Node{
        int data; // 데이터 값
        boolean marked; // 방문했는지 여부를 담는 변수
        LinkedList<Node> adj; // 어느 노드랑 연결되어 있는지 담는 변수
        public Node(int data){
            this.data = data;
            this.marked = false;
            adj = new LinkedList<Node>();
        }
    }
    
    Node[] nodes; // 초기화 된 노드들이 저장되는 배열
    // Main클래스의 생성자가 호출되면서 기본 세팅
    public BaeckDFS(int size){
        nodes = new Node[size];
        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();
        for(int i = 0; i < size; i++) nodes[i] = new Node(i);
    }
    
    // 간선 정보 세팅하는 메소드
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(n1.adj.contains(n2)) n1.adj.add(n2);
        if(n2.adj.contains(n1)) n2.adj.add(n1);
    }
    
    // 매개변수의 값에 해당하는 노드부터 검색
    void DFSR(int idx){
        Node r = nodes[idx];
        DFSR(r);
    }
    
    void BFS(int idx){
        Node r = nodes[idx];
        BFS(r);
    }
    
    // 재귀 알고리즘을 이용해서 구현
    void DFSR(Node r){
        if(r == null) return;
        saveDFS(r);
        r.marked = true;
        // 작은 숫자부터 방문을 해야하므로 정렬을 해줌
        Collections.sort(r.adj, new Comparator<Node>() {
            // 왼쪽의 데이터가 클 경우 자리를 바꿈(오름차순)
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.data > n2.data) return 1; 
				else return -1;
			}
		});
        for(Node n : r.adj){
            if(n.marked == false){
                DFSR(n);
            }
        }
    }
    
    void BFS(Node r){
        Queue<Node> q = new LinkedList<>();
        r.marked = true;
        q.add(r);
        while(!q.isEmpty()){
            Node n = q.poll();
            Collections.sort(n.adj, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.data > n2.data) return 1;
				else return -1;
			}
		    });
            for(Node adjn : n.adj){
                if(adjn.marked == false){
                    adjn.marked = true;
                    q.add(adjn);
                }
            }
            saveBFS(n);
        }
    }
    
    void saveDFS(Node r){
        dfsList.add(r.data);
    }
    
    void saveBFS(Node r){
        bfsList.add(r.data);
    }
    
    public static void main(String[] args) throws IOException {
        int size = 0; // 노드 개수
        int edgeSize = 0; // 간선의 개수
        int strIdx = 0; // 최초로 시작될 노드의 인덱스
        int idx = 0;
        ArrayList<String[]> edgeList = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initStr = br.readLine();
        StringTokenizer st = new StringTokenizer(initStr);
        
        while (st.hasMoreTokens()) {
            int tmIntVal = Integer.parseInt(st.nextToken());
			if(idx == 0) size = tmIntVal;
			if(idx == 1) edgeSize = tmIntVal;
			if(idx == 2) strIdx = tmIntVal;
			idx++;
		}
        
        String[] tempStr;
        // 노드 간의 관계을 정의하는 부분을 가지고 옴
        for(int i = 0; i < edgeSize; i++) {
        	tempStr = br.readLine().split("\\s");
        	edgeList.add(tempStr);
        }

        BaeckDFS main = new BaeckDFS(size+1); // 클래스 초기화, 0부터 세팅이 되므로 노드개수보다 1개 더 많게 설정
        for(String[] arr : edgeList) { // 간선 정보 세팅
        	main.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        main.DFSR(strIdx); // 실행
        for(int i = 0; i < dfsList.size(); i++) {
            if(i == bfsList.size()-1){
                System.out.print(dfsList.get(i));
            }
            else {
            	System.out.print(dfsList.get(i)+ " ");
            }
        }
        
        main = new BaeckDFS(size+1); // BFS도 검색해야하므로 다시 초기화
        System.out.print("\r\n");
        for(String[] arr : edgeList) { // 초기화하면서 간선 정보도 없어지므로 다시 정의
        	main.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        main.BFS(strIdx); // 실행
        for(int j = 0; j < bfsList.size(); j++) {
            if(j == bfsList.size()-1){
                System.out.print(bfsList.get(j));
            }
            else {
            	System.out.print(bfsList.get(j) + " ");
            }
        }
        br.close();
        
    }
}