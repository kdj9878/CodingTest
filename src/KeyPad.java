import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KeyPad {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Map<Integer, Object> spotMap = new HashMap<>();
        // �ʱ�ȭ
        
        spotMap.put(0, new int[]{0, -2});   // ���� �е� 0
        int ys = 1;
        int pad = 1;
        while(pad < 10){
            for(int i = -1; i < 2; i++){
                spotMap.put(pad, new int[]{i, ys});
                pad++;
            }
            ys--;
        }
        
        for(int key : spotMap.keySet()){
            System.out.println(Arrays.toString((int[]) spotMap.get(key)));
        }
	}
	

}
