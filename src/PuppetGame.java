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
                    list.add(dollNum);  // 뽑은 인형 번호를 List에 저장
                    board[j][moves[i]-1] = 0; // 인형을 뽑은 위치를 0으로 바꿈
                    break;  // 제일 위에 있는 인형을 뽑고 반복문 멈추기
                }
            }
        }
        
        for(int i : list) System.out.println(i);
                
        for(int i = 0; i < list.size(); i++){
            // i가 0일 때는 peek을 안하게
            if(i != 0){
                if(stack.peek() == list.get(i)){    // 이전 값과 새로 넣을 값이 같은 경우 List에서 제거
                    list.remove(i);
                    if(list.size() != 1){	// list의 길이 1이 아닐 경우에만 제거
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
