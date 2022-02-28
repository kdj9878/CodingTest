import java.util.ArrayList;
import java.util.Collections;

public class needMoney {
    static ArrayList<Node> nodeList = new ArrayList<>();

	static class Node {
        int index;
        Double value;
        
        public Node(int i, Double v){
            this.index = i;
            this.value = v;
        }
        
    }
	
	public static int compareRateThenIndex(Node node1, Node node2) {
		if(node1.value < node2.value){
            return 1;
        }
        else if(node1.value > node2.value){
            return -1;
        }
        else {
        	return 0;
        }
	}
	
	public static void main(String[] args) {
		int N = 4;
		int[] stages = {4, 4, 4, 4,4};
		int[] answer = new int[N];
        int[] result = new int[N];
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int v : stages){
            list.add(v);
        }
        
        // ������ : ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
        for(int i = 1; i < N+1; i++){
            int challenger = 0; // �ش� ���忡 ������ ���
            int passer = 0;     // �ش� ���忡 ����� ���
            for(int j = 0; j < list.size(); j++){
                if(i <= list.get(j)){
                    challenger++;
                }
                if(i < list.get(j)){
                    passer++;
                }
            }
            Double fail = (double) 0;
            // �ش� ���忡 ������ ������ ��� ī��Ʈ
            if(challenger != 0) {
            	int notPasser = challenger - passer;
                //������
                fail = ((double)notPasser/(double)challenger)*10;
            }
            nodeList.add(new Node(i, fail));
        }
        
        Collections.sort(nodeList, (node1, node2) -> compareRateThenIndex(node1, node2));
        
        for(int i = 0; i < nodeList.size(); i++){
            answer[i] = nodeList.get(i).index;
        }
        
        for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
        
	}
	
	
}
