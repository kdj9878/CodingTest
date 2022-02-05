import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replaceStringToNumber {
	
	public static void main(String[] args) {
		String answer = "";
        
        HashMap<Integer, int[]> map = new HashMap<>();
        
        // list √ ±‚»≠
        for(int i = 1; i < 10; i++){
            map.put(i, new int[2]);
        }
        
        int num = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
            	int[] tempArray = {i, j};
            	map.put(num, tempArray);
            }
        }
        
        Pattern p = Pattern.compile("");
        
        
		
	}
}
