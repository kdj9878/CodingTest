import java.util.*;
import java.io.*;

public class BaeckDFS{
    static ArrayList<Integer> dfsList;
    static ArrayList<Integer> bfsList; // BFS ��¹��� ����Ǵ� List
    
    // ����� ������ ���� Ŭ���� ����
    public class Node{
        int data; // ������ ��
        boolean marked; // �湮�ߴ��� ���θ� ��� ����
        LinkedList<Node> adj; // ��� ���� ����Ǿ� �ִ��� ��� ����
        public Node(int data){
            this.data = data;
            this.marked = false;
            adj = new LinkedList<Node>();
        }
    }
    
    Node[] nodes; // �ʱ�ȭ �� ������ ����Ǵ� �迭
    // MainŬ������ �����ڰ� ȣ��Ǹ鼭 �⺻ ����
    public BaeckDFS(int size){
        nodes = new Node[size];
        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();
        for(int i = 0; i < size; i++) nodes[i] = new Node(i);
    }
    
    // ���� ���� �����ϴ� �޼ҵ�
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(n1.adj.contains(n2)) n1.adj.add(n2);
        if(n2.adj.contains(n1)) n2.adj.add(n1);
    }
    
    // �Ű������� ���� �ش��ϴ� ������ �˻�
    void DFSR(int idx){
        Node r = nodes[idx];
        DFSR(r);
    }
    
    void BFS(int idx){
        Node r = nodes[idx];
        BFS(r);
    }
    
    // ��� �˰����� �̿��ؼ� ����
    void DFSR(Node r){
        if(r == null) return;
        saveDFS(r);
        r.marked = true;
        // ���� ���ں��� �湮�� �ؾ��ϹǷ� ������ ����
        Collections.sort(r.adj, new Comparator<Node>() {
            // ������ �����Ͱ� Ŭ ��� �ڸ��� �ٲ�(��������)
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
        int size = 0; // ��� ����
        int edgeSize = 0; // ������ ����
        int strIdx = 0; // ���ʷ� ���۵� ����� �ε���
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
        // ��� ���� ������ �����ϴ� �κ��� ������ ��
        for(int i = 0; i < edgeSize; i++) {
        	tempStr = br.readLine().split("\\s");
        	edgeList.add(tempStr);
        }

        BaeckDFS main = new BaeckDFS(size+1); // Ŭ���� �ʱ�ȭ, 0���� ������ �ǹǷ� ��尳������ 1�� �� ���� ����
        for(String[] arr : edgeList) { // ���� ���� ����
        	main.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        main.DFSR(strIdx); // ����
        for(int i = 0; i < dfsList.size(); i++) {
            if(i == bfsList.size()-1){
                System.out.print(dfsList.get(i));
            }
            else {
            	System.out.print(dfsList.get(i)+ " ");
            }
        }
        
        main = new BaeckDFS(size+1); // BFS�� �˻��ؾ��ϹǷ� �ٽ� �ʱ�ȭ
        System.out.print("\r\n");
        for(String[] arr : edgeList) { // �ʱ�ȭ�ϸ鼭 ���� ������ �������Ƿ� �ٽ� ����
        	main.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        main.BFS(strIdx); // ����
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