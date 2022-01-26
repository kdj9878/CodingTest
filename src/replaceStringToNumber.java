import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replaceStringToNumber {
	
	static String pattern = "(zero)|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)";
	static String[] numberStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static HashMap<String, String> numberMap = new HashMap<>();
	
	// ����(String) : ����(String)�� �����ؼ� HashMap�� ����
	static void init() {
        for(int i = 0; i < 10; i++){
            numberMap.put(numberStr[i], String.valueOf(i));
        }
	}

	public static void main(String[] args) {
		String s = "onetwo";	// ��ȯ �� ���ڿ�
        boolean upperFlag = true;	// ������ �帧�� �����ϴ� �÷���
        Pattern p = Pattern.compile(pattern);	// Pattern Ŭ������ compile()�� ���ؼ� ���� ������ ���ص� ������ ������
        
        init();	// [{"1" : "one"}, {"2" : "two"} ...] ������ Map�� ����
        
        while(upperFlag){
            Matcher m = p.matcher(s);
            boolean flag = m.find();
            if(flag){
                String engStr = s.substring(m.start(), m.end()); // ���Ͽ� ��ġ�ϴ� ���ڿ��� ���� ��ġ�� �� ��ġ�� ���ϰ� �ش� �κ��� �ڸ�
                for(String eng : numberMap.keySet()){
                    if(eng.equals(engStr)){	// Map�� �ڸ� ���ڿ�(ex. one)�� ��ġ�ϴ� �׸��� ���� ���
                        String number = numberMap.get(eng);	// �ش� �׸��� ����(ex. 1)�� ����
                        s = s.replace(engStr, number);	// ���� ���ڿ��� ���ڸ� ġȯ(ex. "one" => "1")
                    }
                }
            }
            upperFlag = m.find();	// ������ �ٽ� �ѹ� Ȯ��, ���Ͽ� ��ġ���� ���� ��� while�� ����
        }
        // answer = Integer.parseInt(s); �ڵ� �׽�Ʈ ���������� answer�� ��ƾ��ϴµ� Int���̶� ����ȯ�� �ʿ�����
        System.out.println(s); // ���� ��� : 12
	}
}
