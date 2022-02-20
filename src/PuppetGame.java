import java.util.ArrayList;
import java.util.Stack;

public class PuppetGame {
	
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < moves.length; i++){
            int dollNum = 0;
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    dollNum = board[j][moves[i]-1];
                    list.add(dollNum);  // ���� ���� ��ȣ�� List�� ����
                    board[j][moves[i]-1] = 0; // ������ ���� ��ġ�� 0���� �ٲ�
                    break;  // ���� ���� �ִ� ������ �̰� �ݺ��� ���߱�
                }
            }
        }
        
        for(int i : list) System.out.println(i);
                
        for(int i = 0; i < list.size(); i++){
            // i�� 0�� ���� peek�� ���ϰ�
            if(i != 0){
                if(stack.peek() == list.get(i)){    // ���� ���� ���� ���� ���� ���� ��� List���� ����
                    list.remove(i);
                    if(list.size() != 1){	// list�� ���� 1�� �ƴ� ��쿡�� ����
                        list.remove(i-1);
                    }
                    stack.empty();
                    i = 0;
                    answer += 2;
                }
                else{
                    stack.push(list.get(i));
                }
            }
            stack.push(list.get(i));
        }
        
        return answer;
	}
}
