import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replaceStringToNumber {
	
	static String pattern = "(zero)|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)";
	static String[] numberStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static HashMap<String, String> numberMap = new HashMap<>();
	
	// 숫자(String) : 영어(String)를 매핑해서 HashMap에 담음
	static void init() {
        for(int i = 0; i < 10; i++){
            numberMap.put(numberStr[i], String.valueOf(i));
        }
	}

	public static void main(String[] args) {
		String s = "onetwo";	// 변환 할 문자열
        boolean upperFlag = true;	// 패턴의 흐름을 조절하는 플래그
        Pattern p = Pattern.compile(pattern);	// Pattern 클래스의 compile()을 통해서 전역 변수로 정해둔 패턴을 컴파일
        
        init();	// [{"1" : "one"}, {"2" : "two"} ...] 식으로 Map에 담음
        
        while(upperFlag){
            Matcher m = p.matcher(s);
            boolean flag = m.find();
            if(flag){
                String engStr = s.substring(m.start(), m.end()); // 패턴에 일치하는 문자열의 시작 위치와 끝 위치를 구하고 해당 부분을 자름
                for(String eng : numberMap.keySet()){
                    if(eng.equals(engStr)){	// Map에 자른 문자열(ex. one)과 일치하는 항목이 있을 경우
                        String number = numberMap.get(eng);	// 해당 항목의 숫자(ex. 1)를 구함
                        s = s.replace(engStr, number);	// 영어 문자열과 숫자를 치환(ex. "one" => "1")
                    }
                }
            }
            upperFlag = m.find();	// 패턴을 다시 한번 확인, 패턴에 일치하지 않을 경우 while문 종료
        }
        // answer = Integer.parseInt(s); 코딩 테스트 문제에서는 answer에 담아야하는데 Int형이라 형변환이 필요했음
        System.out.println(s); // 예상 결과 : 12
	}
}
